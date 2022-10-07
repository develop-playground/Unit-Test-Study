package chapter03.naming;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.time.LocalDateTime;
import java.util.stream.Stream;

public class DeliveryTests {

    @Test
    @DisplayName("과거 배송일은 유효하지 않음을 검증")
    public void isDeliveryValidInvalidDateReturnsFalse() {
        DeliveryService sut = new DeliveryService();
        LocalDateTime pastDate = LocalDateTime.now().plusDays(-1);
        Delivery delivery = new Delivery();
        delivery.date = pastDate;

        boolean isValid = sut.isDeliveryValid(delivery);

        Assertions.assertFalse(isValid);
    }

    @ParameterizedTest
    @ValueSource(ints = {-1,0,1})
    @DisplayName("어제, 오늘, 내일 날짜 배송일 실패에 대한 검증")
    public void detectsAnInvalidDeliveryDate(int daysFromNow) {
        DeliveryService sut = new DeliveryService();
        LocalDateTime deliveryDate = LocalDateTime.now().plusDays(daysFromNow);
        Delivery delivery = new Delivery();
        delivery.date = deliveryDate;

        boolean isValid = sut.isDeliveryValid(delivery);

        Assertions.assertFalse(isValid);
    }

    @Test
    @DisplayName("이틀 후 배송일 유효한지 검증")
    public void theSoonestDeliveryDateIsTwoDaysFromNow() {
        DeliveryService sut = new DeliveryService();
        LocalDateTime date = LocalDateTime.now().plusDays(2);
        Delivery delivery = new Delivery();
        delivery.date = date;

        boolean isValid = sut.isDeliveryValid(delivery);

        Assertions.assertTrue(isValid);
    }

    @ParameterizedTest
    @MethodSource("validDays")
    @DisplayName("복잡한 매개변수 데이터를 사용하여 잘못된 날짜의 배송을 올바르게 식별하는지 검증")
    public void canDetectAnInvalidDeliveryDate(int daysFromNow, boolean expected) {
        DeliveryService sut = new DeliveryService();
        LocalDateTime deliveryDate = LocalDateTime.now().plusDays(daysFromNow);
        Delivery delivery = new Delivery();
        delivery.date = deliveryDate;

        boolean isValid = sut.isDeliveryValid(delivery);

        Assertions.assertEquals(expected, isValid);
    }

    private static Stream<Arguments> validDays() {
        return Stream.of(
            Arguments.of(-1, false),
            Arguments.of(0, false),
            Arguments.of(1, false),
            Arguments.of(2, true)
        );
    }

}
