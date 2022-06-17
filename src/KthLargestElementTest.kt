import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

internal class KthLargestElementTest {
    @Test
    fun doesTheJob() {
        val kthLargestElement = KthLargestElement()
        assertEquals(5, kthLargestElement.findKthLargest(intArrayOf(3,2,1,5,6,4), 2))
        assertEquals(4, kthLargestElement.findKthLargest(intArrayOf(3,2,3,1,2,4,5,5,6), 4))
    }
}
