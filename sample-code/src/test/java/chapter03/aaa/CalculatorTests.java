package chapter03.aaa;

import chapter03.Calculator;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class CalculatorTests {

    @Test
    public void sumOfTwoNumbers() {
        double first = 10;
        double second = 20;
        Calculator calculator = new Calculator();

        double result = calculator.sum(first, second);

        Assertions.assertEquals(30, result);
    }

}
