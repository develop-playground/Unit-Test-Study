package chap3.aaa

import chap3.Calculator
import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class CalculatorTest {

    /**
     * AAA 또는 Given-When-Then 패턴을 사용한 테스트
     * @JunHyung
     */
    @Test
    fun sum_of_two_numbers1() {

        // 준비 or given
        val first: Double = 10.0
        val second: Double = 20.0
        val calculator = Calculator()

        // 실행 or when
        val result = calculator.sum(first, second)

        // 검증 or then
        assertEquals(30.0, result)
    }

    /**
     * 의존성과 SUT를 구별하기 위해 변수 이름 지정하기
     * @JunHyung
     */
    @Test
    fun sum_of_two_numbers2() {

        // 준비 or given
        val first: Double = 10.0
        val second: Double = 20.0
        val sut = Calculator()

        // 실행 or when
        val result = sut.sum(first, second)

        // 검증 or then
        assertEquals(30.0, result)
    }
}