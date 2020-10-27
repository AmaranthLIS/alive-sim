package ge.lis.sim.models

import java.math.BigDecimal

/**
 * Created by
 * @Author: lis, Luganskiy Igor, udevlu73@gmail.com
 * Date: 27.10.2020  * Time: 12:02
 */
data class CardPayment(val id: Long, val userId: Long, val amount: BigDecimal, val status: PayStatus = PayStatus.PENDING, var createdAt: Long = 0, val desc: String = "") {
}

enum class PayStatus {
    PENDING,
    PROGRESS,
    SUCCESS,
    FAIL,
    CANCEL
}
