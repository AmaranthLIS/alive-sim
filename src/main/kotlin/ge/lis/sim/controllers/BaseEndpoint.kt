package ge.lis.sim.controllers

import io.micronaut.http.MediaType
import io.micronaut.http.annotation.Controller
import io.micronaut.http.annotation.Get
import io.micronaut.http.annotation.Produces
import java.time.LocalDateTime

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
        return "Time is " + LocalDateTime.now()
    }
}
