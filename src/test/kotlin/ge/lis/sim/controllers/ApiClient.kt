package ge.lis.sim.controllers

import io.micronaut.http.annotation.Get
import io.micronaut.http.client.annotation.Client

/**
 * Created by
 *
 * @Author: lis, Luganskiy Igor
 * Date: 23.10.2020  * Time: 21:54
 */
@Client("/api/")
interface ApiClient {
    @Get("/item")
    fun getListItems(): String
}
