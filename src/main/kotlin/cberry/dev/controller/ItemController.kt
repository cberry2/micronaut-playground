package cberry.dev.controller

import cberry.dev.ItemRepository
import cberry.dev.ItemSaveCommand
import cberry.dev.domain.Item
import io.micronaut.http.HttpResponse
import io.micronaut.http.MutableHttpResponse
import io.micronaut.http.annotation.*
import io.micronaut.validation.Validated
import java.net.URI
import javax.validation.Valid

@Validated
@Controller("/item")
class ItemController(
    private val itemRepo: ItemRepository
) {

    @Get("/{id}")
    fun getItem(id: Long): Item? =
        itemRepo.findById(id).orElse(null)

    @Post("/")
    fun saveItem(@Body @Valid saveCommand: ItemSaveCommand): MutableHttpResponse<Any>? {
        val item = itemRepo.save(saveCommand.title, saveCommand.body)

        return HttpResponse
            .created<Any>(item)
            .headers { headers -> headers.location(location(item.id)) }
    }

    @Delete("/{id}")
    fun deleteItem(id: Long): HttpResponse<*> {
        itemRepo.deleteById(id)
        return HttpResponse.noContent<Any>()
    }

    protected fun location(id: Long?): URI {
        return URI.create("/item/" + id!!)
    }
}