package chapter03.sut;

import chapter03.Calculator;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class CalculatorTests {

    /*
    * 의존성과 SUT 구별하기
     */
    @Test
    public void sumOfTwoNumbersOne() {
        // Given
        double first = 10;
        double second = 20;
        Calculator sut = new Calculator();

        // When
        double result = sut.sum(first, second);

        // Then
        Assertions.assertEquals(30, result);
    }

    /*
    * 빈 줄로 각 구절을 구분하기
    * 주석 제거
     */
    @Test
    public void sumOfTwoNumbersTwo() {
        double first = 10;
        double second = 20;
        Calculator sut = new Calculator();

        double result = sut.sum(first, second);

        Assertions.assertEquals(30, result);
    }
}
