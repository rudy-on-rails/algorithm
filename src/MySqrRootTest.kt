import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class MySqrRootTest {
    @Test
    fun testCases() {
        val sqrRoot = MySqrRoot()

        assertEquals(2, sqrRoot.mySqrt(4))
        assertEquals(3, sqrRoot.mySqrt(9))
        assertEquals(8, sqrRoot.mySqrt(64))
        assertEquals(2, sqrRoot.mySqrt(8))
        assertEquals(1, sqrRoot.mySqrt(1))
        assertEquals(1, sqrRoot.mySqrt(2))
        assertEquals(2, sqrRoot.mySqrt(6))
        assertEquals(46340, sqrRoot.mySqrt(2147483647))
    }
}
