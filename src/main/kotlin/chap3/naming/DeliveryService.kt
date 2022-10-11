package chap3.naming

import java.time.LocalDateTime

class DeliveryService {
    fun isDeliveryValid(delivery: Delivery): Boolean {
        return delivery.date >= LocalDateTime.now().plusDays(1.999.toLong())
    }
}