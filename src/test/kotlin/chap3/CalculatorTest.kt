package chap3

import org.junit.jupiter.api.AfterEach
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class CalculatorTest {

//    private lateinit var _sut: Calculator
//
//    @BeforeEach
//    fun setUp() {
//        _sut = Calculator()
//    }

    @Test
    fun sum_of_two_numbers() {
        val first: Double = 10.0
        val second: Double = 20.0
        val calculator = Calculator()

        val result = calculator.sum(first, second)

        assertEquals(30.0, result)

//        val sut = calculator.sum(first, second)

//        assertEquals(30.0, sut)
    }
}