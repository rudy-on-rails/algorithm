import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

internal class ThreeSumTest {
    private val threeSum = ThreeSum()

    @Test
    fun itWorks() {
        val nums = intArrayOf(-1,0,1,2,-1,-4)
        assertEquals(listOf(listOf(-1,0,1), listOf(-1,-1,2)), threeSum.threeSum(nums))
    }

}
