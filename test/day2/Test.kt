package day2

import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class Test {

    @Test
    fun testA() {
        val expectedResult = 2679
        assertEquals(expectedResult, a())
    }

    @Test
    fun testB() {
        val expectedResult = 77607
        assertEquals(expectedResult, b())
    }
}