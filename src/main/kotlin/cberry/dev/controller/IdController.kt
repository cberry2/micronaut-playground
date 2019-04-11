package cberry.dev.controller

import io.micronaut.http.MediaType
import io.micronaut.http.annotation.Controller
import io.micronaut.http.annotation.Get
import io.micronaut.http.annotation.Produces

@Controller("/id")
class IdController {

    @Get("/{?id}")
    @Produces(MediaType.TEXT_PLAIN)
    fun index(id: Long?) = "Your id is $id"
}