import java.util.TreeSet

class MinimumDeviation {
    fun minimumDeviation(nums: IntArray): Int {
        val treeSet = TreeSet<Int>()
        nums.forEach{ num ->
            if (num % 2 == 1) {
                treeSet.add(num * 2)
            } else {
                treeSet.add(num)
            }
        }
        if (treeSet.isEmpty()) {
            return 0
        }
        var diff = treeSet.last() - treeSet.first()

        while (treeSet.last() % 2 == 0) {
            val num = treeSet.last()
            treeSet.remove(num)
            treeSet.add(num / 2)
            diff = diff.coerceAtMost(treeSet.last() - treeSet.first())
        }
        return diff
    }
}
