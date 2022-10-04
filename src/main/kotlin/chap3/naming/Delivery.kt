package chap3.naming

import java.time.LocalDateTime


class Delivery {
    var date: LocalDateTime = LocalDateTime.now()
        set(value) {
            field = value
        }
}