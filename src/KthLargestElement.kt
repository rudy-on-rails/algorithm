class KthLargestElement {
    fun findKthLargest(nums: IntArray, k: Int): Int {
        val sorted = nums
            .sortedArray()
        val index = sorted.lastIndex - k + 1
        return sorted[index]
    }
}
