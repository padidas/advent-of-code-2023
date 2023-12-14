package day3

import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class Test {

    @Test
    fun testA() {
        val expectedResult = 550934
        assertEquals(expectedResult, a())
    }

    @Test
    fun testB() {
        val expectedResult = 81997870
        assertEquals(expectedResult, b())
    }
}