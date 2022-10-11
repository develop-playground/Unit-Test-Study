package chap3.naming

import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource
import org.junit.jupiter.params.provider.ValueSource
import java.time.LocalDateTime
import java.util.stream.Stream
import kotlin.test.assertEquals
import kotlin.test.assertFalse
import kotlin.test.assertTrue

class DeliveryServiceTest {

    @Test
    @DisplayName("잘못된 날짜의 배송을 올바르게 식별하는지 검증")
    fun isDeliveryValid_invalid_returnFalse() {

        val sut = DeliveryService()
        val pastDate: LocalDateTime = LocalDateTime.now().plusDays(-1)
        val delivery = Delivery()
        delivery.date = pastDate

        val isValid = sut.isDeliveryValid(delivery)

        assertFalse(isValid)
    }

    @ParameterizedTest
    @ValueSource(ints = [-1, 0, 1])
    @DisplayName("어제, 오늘, 내일 날짜에 주문하면 배송이 실패되는지에 대한 검증")
    fun detects_an_invalid_delivery_date(
        daysFromNow: Int
    ) {

        val sut = DeliveryService()
        val pastDate: LocalDateTime = LocalDateTime.now().plusDays(daysFromNow.toLong())
        val delivery = Delivery()
        delivery.date = pastDate

        val isValid = sut.isDeliveryValid(delivery)

        assertFalse(isValid)
    }

    @Test
    @DisplayName("오늘로부터 이틀 후에 배송이 성공적으로 되는지에 대한 검증")
    fun the_soonest_delivery_date_is_two_days_from_now() {

        val sut = DeliveryService()
        val pastDate: LocalDateTime = LocalDateTime.now().plusDays(2)
        val delivery = Delivery()
        delivery.date = pastDate

        val isValid = sut.isDeliveryValid(delivery)

        assertTrue(isValid)
    }

    @ParameterizedTest
    @MethodSource("validDays")
    @DisplayName("복잡한 매개변수 데이터를 사용하여 잘못된 날짜의 배송을 올바르게 식별하는지 검증")
    fun can_detect_an_invalid_delivery_date(
        daysFromNow: Int,
        expected: Boolean
    ) {
        val sut = DeliveryService()
        val pastDate: LocalDateTime = LocalDateTime.now().plusDays(daysFromNow.toLong())
        val delivery = Delivery()

        delivery.date = pastDate

        val isValid = sut.isDeliveryValid(delivery)
        assertEquals(expected, isValid)
    }

    companion object {
        @JvmStatic
        private fun validDays(): Stream<Arguments> {
            return Stream.of(
                Arguments.of(-1, false),
                Arguments.of(0, false),
                Arguments.of(1, false),
                Arguments.of(2, true)
            )
        }
    }
}