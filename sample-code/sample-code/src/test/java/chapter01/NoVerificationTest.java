package chapter01;

import org.junit.jupiter.api.Test;

public class NoVerificationTest {

    /*
    아래 테스트는 코드 커버리지와 분기 커버리지가 둘다 100%를 나타내지만 쓸모가 없는 테스트다.
    */
    @Test
    public void test() {
        boolean result1 = IsStringLong.isStringLongAfter("abc"); // false 반환
        boolean result2 = IsStringLong.isStringLongAfter("abcdef"); // true 반환
    }

}
