import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class ConcatenatedWordsTest {
    private val concatenatedWords = ConcatenatedWords()

    @Test
    fun testCase1() {
        val input = arrayOf("cat","dog","catdog")

        assertEquals(
            listOf("catdog"),
            concatenatedWords.findAllConcatenatedWordsInADict(input)
        )
    }

    @Test
    fun testCase2() {
        val input = arrayOf("cat","cats","catsdogcats","dog","dogcatsdog","hippopotamuses","rat","ratcatdogcat")
        val output = listOf("catsdogcats","dogcatsdog","ratcatdogcat")

        assertEquals(
            output,
            concatenatedWords.findAllConcatenatedWordsInADict(input)
        )
    }

    @Test
    fun testCase3() {
        val input = arrayOf("a","b","ab","abc")
        val output = listOf("ab")

        assertEquals(
            output,
            concatenatedWords.findAllConcatenatedWordsInADict(input)
        )
    }
}
