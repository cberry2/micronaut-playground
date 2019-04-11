//package cberry.dev.controller
//
//import io.micronaut.context.ApplicationContext
//import io.micronaut.http.HttpHeaders
//import io.micronaut.http.HttpRequest
//import io.micronaut.http.HttpResponse
//import io.micronaut.http.HttpStatus
//import io.micronaut.http.client.HttpClient
//import io.micronaut.http.client.exceptions.HttpClientResponseException
//import io.micronaut.runtime.server.EmbeddedServer
//import org.hamcrest.Matchers.`is`
//import org.hamcrest.Matchers.hasProperty
//import org.junit.AfterClass
//import org.junit.BeforeClass
//import org.junit.Rule
//import org.junit.Test
//import org.junit.rules.ExpectedException
//
//class ItemControllerTest {
//
//    @Rule
//    @JvmField
//    var thrown = ExpectedException.none()
//
//    @Test
//    fun supplyAnInvalidOrderTriggersValidationFailure() {
//        thrown.expect(HttpClientResponseException::class.java)
//        thrown.expect(hasProperty<Any>("response", hasProperty<Any>("status", `is`(HttpStatus.BAD_REQUEST))))
//        client!!.toBlocking().exchange<Any, Any>(HttpRequest.GET("/Items/list?order=foo"))
//    }
//
////    @Test
////    fun testFindNonExistingItemReturns404() {
////        thrown.expect(HttpClientResponseException::class.java)
////        thrown.expect(hasProperty<Any>("response", hasProperty<Any>("status", `is`(HttpStatus.NOT_FOUND))))
////        val response = client!!.toBlocking().exchange<Any, Any>(HttpRequest.GET("/Items/99"))
////    }
//
//    protected fun entityId(response: HttpResponse<*>): Long? {
//        val path = "/Items/"
//        val value = response.header(HttpHeaders.LOCATION) ?: return null
//        val index = value.indexOf(path)
//        return if (index != -1) {
//            java.lang.Long.valueOf(value.substring(index + path.length))
//        } else null
//    }
//
//    companion object {
//
//        private var server: EmbeddedServer? = null
//        private var client: HttpClient? = null
//
//        @JvmStatic
//        @BeforeClass
//        fun setupServer() {
//            server = ApplicationContext
//                .build()
//                .run(EmbeddedServer::class.java)
//            client = server!!.applicationContext.createBean(HttpClient::class.java, server!!.url)
//        }
//
//        @JvmStatic
//        @AfterClass
//        fun stopServer() {
//            if (server != null) {
//                server!!.stop()
//            }
//            if (client != null) {
//                client!!.stop()
//            }
//        }
//    }
//}