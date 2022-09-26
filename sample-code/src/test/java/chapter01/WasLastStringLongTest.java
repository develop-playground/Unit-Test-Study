package chapter01;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class WasLastStringLongTest {

    @Test
    @DisplayName("WasLastStringLong의 두번째 result만 검증된다.")
    public void test() {
        boolean result = WasLastStringLong.isStringLong("abc");
        Assertions.assertEquals(false, result);
    }

}
