package ge.lis.sim.controllers

import ge.lis.sim.models.Card
import ge.lis.sim.today
import io.micronaut.core.type.Argument
import io.micronaut.http.HttpRequest
import io.micronaut.http.HttpStatus
import io.micronaut.http.client.RxHttpClient
import io.micronaut.http.client.annotation.Client
import io.micronaut.http.client.exceptions.HttpClientResponseException
import io.micronaut.test.extensions.junit5.annotation.MicronautTest
import kotlinx.serialization.json.Json
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

import org.slf4j.LoggerFactory
import javax.inject.Inject

/**
 * Created by
 * @Author: lis, Igor Lu
 * Date: 20.10.2020  * Time: 23:30
 */
@MicronautTest
internal class BaseEndpointTest {

    private val logger = LoggerFactory.getLogger(javaClass.name)

    @Inject
    @field:Client("/")
    lateinit var client : RxHttpClient
    private val URL = "/api/sim"

    @Test
    fun testIndexRequest() {
        val request: HttpRequest<Any> = HttpRequest.GET("/")
        val body = client.toBlocking().retrieve(request)
        Assertions.assertNotNull(body)
        Assertions.assertEquals("Time is "+today(), body)
        logger.info(body)
    }

    @Test
    fun testNotFound() {
        try {
            client.toBlocking().exchange(HttpRequest.GET<Any>("/foo/1680502395"), Argument.of(Card::class.java))
        } catch (e: HttpClientResponseException) {
            e.response.status == HttpStatus.UNAUTHORIZED
        }
    }

    @Test
    fun testGetList() {
        val request: HttpRequest<Any> = HttpRequest.GET("$URL/list")
        val body = client.toBlocking().retrieve(request)
        Assertions.assertNotNull(body)
//        Assertions.assertEquals(listOf(Card(1L, "test", "Country", "operator", 1L)), body)//cast body
    }


    @Test
    fun testDeleteSuccess() {
        val request: HttpRequest<Any> = HttpRequest.DELETE("$URL/item/1")
        val body = client.toBlocking().retrieve(request)
        Assertions.assertNotNull(body)
    }

    @Test
    fun testUpdateCardSuccess() {
        val request: HttpRequest<Any> = HttpRequest.PUT("$URL/item", Card(1L, "test", "Country", "operator", today()))
        val body = client.toBlocking().retrieve(request)
        Assertions.assertNotNull(body)
    }


    /*@Test
    fun testGetListNotifications() {
        val request: HttpRequest<Any> = HttpRequest.GET("/api/notification/list")
        val body = client.toBlocking().retrieve(request)
        Assertions.assertNotNull(body)
        Assertions.assertEquals("Time is "+LocalDateTime.now(), body)
    }

    fun getListPayments()
    */
}
