import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

internal class LastWordLengthTest {
    @Test
    fun works() {
        assertEquals(4, LastWordLength().lengthOfLastWord("   fly me   to   the moon  "))
    }
}
