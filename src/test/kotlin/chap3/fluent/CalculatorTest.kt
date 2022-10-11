package chap3.fluent

import chap3.Calculator
import org.hamcrest.MatcherAssert.assertThat
import org.hamcrest.Matchers.equalTo
import org.hamcrest.Matchers.`is`
import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class CalculatorTest {

    /**
     * Junit5의 assertEquals를 이용한 테스트 검증
     * @JunHyung
     */
    @Test
    fun sum_of_two_numbers1() {
        val first = 10.0
        val second = 20.0
        val sut = Calculator()

        val result = sut.sum(first, second)

        assertEquals(30.0, result)
    }

    /**
     * hamcrest 라이브러리의 assertThat를 이용한 테스트 검증(가독성 향상)
     * @JunHyung
     */
    @Test
    fun sum_of_two_numbers2() {
        val first = 10.0
        val second = 20.0
        val sut = Calculator()

        val result = sut.sum(first, second)

        assertThat(30.0, equalTo(result))
        assertThat(30.0, `is`(result))
    }
}