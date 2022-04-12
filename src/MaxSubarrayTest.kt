import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

internal class MaxSubarrayTest {
    @Test
    fun itWorks() {
        var nums = intArrayOf(-2,1,-3,4,-1,2,1,-5,4)
        assertEquals(6, MaxSubarray().maxSubArray(nums))

        assertEquals(1, MaxSubarray().maxSubArray(intArrayOf(1)))

        nums = intArrayOf(5,4,-1,7,8)
        assertEquals(23, MaxSubarray().maxSubArray(nums))

        nums = intArrayOf(-1,0,-2)
        assertEquals(0, MaxSubarray().maxSubArray(nums))

        nums = intArrayOf(-2,-1)
        assertEquals(-1, MaxSubarray().maxSubArray(nums))
    }
}
