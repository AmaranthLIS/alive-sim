package ge.lis.sim.controllers

import ge.lis.sim.models.Card
import ge.lis.sim.models.Res
import ge.lis.sim.today
import io.micronaut.http.HttpResponse
import io.micronaut.http.HttpStatus
import io.micronaut.http.MediaType
import io.micronaut.http.annotation.*
import io.github.oshai.kotlinlogging.KotlinLogging

/**
 * Created by
 * @Author: lis,Igor Lu
 * Date: 20.10.2020  * Time: 17:41
 */
@Controller("/")
class BaseEndpoint {

    @Get("/")
    @Produces(MediaType.TEXT_PLAIN)
    fun index() : String {
        return "Time is " + today()
    }

    @Get("/time")
    fun list() : HttpResponse<*> {
        return HttpResponse.ok("ok")
    }
}

@Controller("/api/sim")
class SimEndpoint {

    private val logger = KotlinLogging.logger {}

    @Get("/list")
    fun index() : Any {
        logger.debug { "Get list of Cards!" }
        return listOf(Card(1L,"test", "Counter", "operator", 1L))
    }

    @Get("/")
    fun list() : HttpResponse<*> {
        val m = HashMap<String, Any>()
        m["status"] = 401
        m["error"] = "Unauthorized"
        m["message"] = "No message available"
        return HttpResponse.status<Any>(HttpStatus.OK).body(m)
// return HttpResponse.ok(Card("test", ""))
    }

    @Post("/item")
    fun createCard(card: Card) : HttpResponse<*> {
        if (card.expire < today())
            return HttpResponse.badRequest(Res(1))
        return HttpResponse.ok(Res())
    }

    @Delete("/item/{id}")
    fun deleteCard(id: Long) : HttpResponse<*> {
        if (id < 1)
            return HttpResponse.badRequest(Res(2))
        return HttpResponse.ok(Res())
    }

    @Put("/item")
    fun updateCard(@Body card: Card) : HttpResponse<*> {
        if (card.id < 1)
            return HttpResponse.badRequest(Res(2))
        return HttpResponse.ok(Res())
    }
}
