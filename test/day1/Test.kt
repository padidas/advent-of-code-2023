package day1

import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class Test {

    @Test
    fun testA() {
        val expectedResult = 54697
        assertEquals(expectedResult, a())
    }

    @Test
    fun testB() {
        val expectedResult = 54885
        assertEquals(expectedResult, b())
    }
}