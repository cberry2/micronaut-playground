package cberry.dev.controller

import cberry.dev.ItemRepository
import cberry.dev.ItemSaveCommand
import cberry.dev.domain.Item
import io.micronaut.http.HttpResponse
import io.micronaut.http.annotation.Controller
import io.micronaut.http.annotation.Delete
import io.micronaut.http.annotation.Get
import io.micronaut.http.annotation.Post
import io.micronaut.validation.Validated
import java.net.URI

@Validated
@Controller("/item")
class ItemController(
    private val itemRepo: ItemRepository
) {

    @Get("/{id}")
    fun getItem(id: Long): Item? =
        itemRepo.findById(id).orElse(null)

    @Post("/")
    fun updateItem(saveCommand: ItemSaveCommand): Item =
        itemRepo.save(saveCommand.title, saveCommand.body)

    @Delete("/{id}")
    fun deleteItem(id: Long): HttpResponse<*> {
        itemRepo.deleteById(id)
        return HttpResponse.noContent<Any>()
    }

    protected fun location(id: Long?): URI {
        return URI.create("/genres/" + id!!)
    }
}