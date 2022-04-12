import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

internal class BinarySearchVersionTest {
    @Test
    fun isBadRevisionTest() {
        var binarySearchVersion = BinarySearchVersion(1702766719)
        assertEquals(1702766719, binarySearchVersion.firstBadVersion(2126753390))
        binarySearchVersion = BinarySearchVersion(1)
        assertEquals(1, binarySearchVersion.firstBadVersion(1))
    }
}
