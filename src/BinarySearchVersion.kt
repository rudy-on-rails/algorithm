class BinarySearchVersion(private val badVersion: Int) {
    fun firstBadVersion(n: Int) : Int {
        var start = 1
        var end = n
        var lowestBadVersion = start
        while (start <= end) {
            val mid = start + (end - start) / 2
            if (!isBadVersion(mid)) {
                start = mid + 1
            } else {
                lowestBadVersion = mid
                end = mid - 1
            }
        }
        return lowestBadVersion
    }

    private fun isBadVersion(version: Int): Boolean {
        return version >= badVersion
    }
}
