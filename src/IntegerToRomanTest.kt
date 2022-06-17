import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*

internal class IntegerToRomanTest {
    @Test
    fun intToRoman() {
        assertEquals("I", IntegerToRoman().intToRoman(1))
        assertEquals("III", IntegerToRoman().intToRoman(3))
        assertEquals( "LVIII", IntegerToRoman().intToRoman(58))

        assertEquals("IV", IntegerToRoman().intToRoman(4))
        assertEquals("MCMXCIV", IntegerToRoman().intToRoman(1994))
    }
}
