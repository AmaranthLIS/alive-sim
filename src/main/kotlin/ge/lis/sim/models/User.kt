package ge.lis.sim.models

/**
 * Created by
 * @Author: lis, Luganskiy Igor, udevlu73@gmail.com
 * Date: 26.10.2020  * Time: 18:42
 */
data class User(val id: Long, val username: String, val password: String, val name: String = "", val token: String = "", var createdAt: String? = null)
