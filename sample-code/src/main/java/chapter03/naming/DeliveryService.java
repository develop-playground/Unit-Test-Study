package chapter03.naming;

import java.time.LocalDateTime;

public class DeliveryService {

    /*
    * 기존 예제 코드에서는
    * delivery.date >= LocalDateTime.now().plusDays((long) 1.999));
    * 날짜 끼리는 비교 연산자를 쓰면 안되는건가?
    * 날짜 비교 방법엔 compareTo(), equals() 등 사용
     */
    public boolean isDeliveryValid(Delivery delivery) {
        return LocalDateTime.now().plusDays(1).isBefore(delivery.date);
    }

}
