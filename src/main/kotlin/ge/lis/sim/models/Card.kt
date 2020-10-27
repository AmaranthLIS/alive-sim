package ge.lis.sim.models

import ge.lis.sim.today
import kotlinx.serialization.*

/**
 * Created by
 * @Author: lis, Luganskiy Igor
 * Date: 23.10.2020  * Time: 23:04
 */
@Serializable
data class Card(val id: Long, val title: String, val country: String, val operator: String = "", var expire: Long = 0, var createdAt: Long = 0) {
    constructor(id: Long, title: String, country: String, operator: String, expire: Long) : this(id, title, country) {
        createdAt = today()
    }
    constructor(id: Long, title: String, country: String, expire: Long) : this(id, title, country) {
        createdAt = today()
    }
}
