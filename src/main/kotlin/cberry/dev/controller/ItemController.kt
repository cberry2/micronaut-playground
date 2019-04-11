package cberry.dev.controller

import io.micronaut.http.annotation.Controller
import io.micronaut.http.annotation.Get

@Controller("/item")
class ItemController {

    @Get("/")
    fun index() = "test"
}