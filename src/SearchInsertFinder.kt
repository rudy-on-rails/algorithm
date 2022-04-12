class SearchInsertFinder {
    fun searchInsert(nums: IntArray, target: Int): Int {
        nums.forEachIndexed { index, i ->
            if (i == target) {
                return index
            } else if (index == 0 && i > target){
                return 0
            } else if (index + 1 <= nums.lastIndex && nums[index+1] > target) {
                return index + 1
            } else if (index == nums.lastIndex) {
                return index + 1
            }
        }
        return 0
    }
}
