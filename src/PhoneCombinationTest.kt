import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

internal class PhoneCombinationTest {
    private val phoneCombination = PhoneCombination()

    @Test
    fun letterCombinationsFor23() {
        val expectations = listOf("ad","ae","af","bd","be","bf","cd","ce","cf")
        assertEquals(expectations, phoneCombination.letterCombinations("23"))
    }

    @Test
    fun letterCombinationsForBlank() {
        val expectations = emptyList<String>()
        assertEquals(expectations, phoneCombination.letterCombinations(""))
    }

    @Test
    fun letterCombinationsFor2() {
        assertEquals(listOf("a","b","c"), phoneCombination.letterCombinations("2"))
    }
}
