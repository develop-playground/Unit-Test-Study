package chap3.fluent

import chap3.Calculator
import org.hamcrest.MatcherAssert.assertThat
import org.hamcrest.Matchers.equalTo
import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class CalculatorTest {

    @Test
    fun sum_of_two_numbers1() {
        val first = 10.0
        val second = 20.0
        val sut = Calculator()

        val result = sut.sum(first, second)

        assertEquals(30.0, result)
    }

    @Test
    fun sum_of_two_numbers2() {
        val first = 10.0
        val second = 20.0
        val sut = Calculator()

        val result = sut.sum(first, second)

        assertThat(30.0, equalTo(result))
    }
}