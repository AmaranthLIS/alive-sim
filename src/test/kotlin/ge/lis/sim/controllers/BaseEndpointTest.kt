package ge.lis.sim.controllers

import io.micronaut.http.HttpRequest
import io.micronaut.http.client.RxHttpClient
import io.micronaut.http.client.annotation.Client
import io.micronaut.test.extensions.junit5.annotation.MicronautTest
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

import org.slf4j.LoggerFactory
import java.time.LocalDateTime
import javax.inject.Inject

/**
 * Created by
 * @Author: lis, Igor Lu
 * Date: 20.10.2020  * Time: 23:30
 */
@MicronautTest
internal class BaseEndpointTest {

    private val logger = LoggerFactory.getLogger("${javaClass.name}")

    @Inject
    @field:Client("/")
    lateinit var client : RxHttpClient
    private val URL = "/api/sim"

    @Test
    fun testIndexRequest() {
        val request: HttpRequest<Any> = HttpRequest.GET("/")
        val body = client.toBlocking().retrieve(request)
        Assertions.assertNotNull(body)
        Assertions.assertEquals("Time is "+LocalDateTime.now(), body)
        logger.info(body)
    }

    @Test
    fun testGetList() {
        val request: HttpRequest<Any> = HttpRequest.GET("$URL/list")
        val body = client.toBlocking().retrieve(request)
        Assertions.assertNotNull(body)
        Assertions.assertEquals("Time is "+LocalDateTime.now(), body)
    }

    @Test
    fun testGetListNotifications() {
        val request: HttpRequest<Any> = HttpRequest.GET("/api/notification/list")
        val body = client.toBlocking().retrieve(request)
        Assertions.assertNotNull(body)
        Assertions.assertEquals("Time is "+LocalDateTime.now(), body)
    }

    @Test
    fun testUpdateItem() {
        val request: HttpRequest<Any> = HttpRequest.POST("$URL/item", listOf(""))
        val body = client.toBlocking().retrieve(request)
        Assertions.assertNotNull(body)
        Assertions.assertEquals("Time is "+LocalDateTime.now(), body)
    }

    @Test
    fun testDelete() {
        val request: HttpRequest<Any> = HttpRequest.DELETE("$URL/item")
        val body = client.toBlocking().retrieve(request)
        Assertions.assertNotNull(body)
        Assertions.assertEquals("Time is "+LocalDateTime.now(), body)
    }

    @Test
    fun testCreate() {
        val request: HttpRequest<Any> = HttpRequest.PUT("$URL/item", listOf(""))
        val body = client.toBlocking().retrieve(request)
        Assertions.assertNotNull(body)
        Assertions.assertEquals("Time is "+LocalDateTime.now(), body)
    }
}
