package cberry.dev.controller

import io.micronaut.context.ApplicationContext
import io.micronaut.http.client.HttpClient
import io.micronaut.runtime.server.EmbeddedServer
import org.junit.jupiter.api.Assertions.assertEquals
import org.spekframework.spek2.Spek
import org.spekframework.spek2.style.specification.describe

object HelloControllerSpec: Spek({
    describe("HelloController Test Suite") {
        val server = ApplicationContext.run(EmbeddedServer::class.java)
        val client = HttpClient.create(server.url)

        it("test /hello responds Hello World") {
            val rsp = client.toBlocking().retrieve("/hello")
            assertEquals(rsp, "Hello World")
        }

        afterGroup {
            client.close()
            server.close()
        }
    }
})