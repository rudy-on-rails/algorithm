import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

internal class SearchInsertFinderTest {
    @Test
    fun testSearchInsert() {
        val nums = intArrayOf(1,3,5,6)
        val searchInsertFinder = SearchInsertFinder()

        assertEquals(2, searchInsertFinder.searchInsert(nums, 5))
        assertEquals(1, searchInsertFinder.searchInsert(nums, 2))
        assertEquals(4, searchInsertFinder.searchInsert(nums, 7))
        assertEquals(1, searchInsertFinder.searchInsert(intArrayOf(1,3), 2))

        assertEquals(0, searchInsertFinder.searchInsert(intArrayOf(1,3,5,6), 0))
    }
}
