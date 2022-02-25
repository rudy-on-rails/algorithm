import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

internal class CompareVersionsTest {
    private val compareVersions = CompareVersions()

    @Test
    fun compareVersionsTests() {
        assertEquals(0, compareVersions.compareVersion("1.001","1.01"))
        assertEquals(0, compareVersions.compareVersion("1.0.0","1.0"))
        assertEquals(-1, compareVersions.compareVersion("0.1", "1.1"))
    }
}
