class ThreeSum {
    fun threeSum(nums: IntArray): List<List<Int>> {
        val output : MutableSet<List<Int>> = mutableSetOf()
        val table : HashMap<Int, Int> = hashMapOf()
        nums.forEachIndexed { index, num ->
            val target = 0 - num
            for (otherNumIndex in index + 1 until nums.size) {
                val otherNum = nums[otherNumIndex]
                if (table[otherNum] != null) {
                    val targetIndex = table[otherNum]!!
                    if (targetIndex != otherNumIndex) {
                        output.add(listOf(num, otherNum, nums[targetIndex]).sorted())
                    }
                }
                table[target - otherNum] = otherNumIndex
            }
            table.clear()
        }
        return output.toList()
    }
}
