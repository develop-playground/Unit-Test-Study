package chapter01;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class IsStringLongTest {

    @Test
    @DisplayName("isStringLongBefore(), 커버리지 66%")
    public void isStringLongBeforeTest() {
        boolean result = IsStringLong.isStringLongBefore("abc");
        Assertions.assertEquals(false, result);
    }

    @Test
    @DisplayName("isStringLongAfter(), 커버리지 100%")
    public void isStringLongAfterTest() {
        boolean result = IsStringLong.isStringLongAfter("abc");
        Assertions.assertEquals(false, result);
    }


}
