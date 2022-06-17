class MySqrRoot {
    fun mySqrt(x: Int): Int {
        if (x < 2) {
            return x
        }

        var right = x
        var left = 1

        while (left <= right) {
            val mid: Int = (left + right) / 2
            if (x / mid == mid) {
                return mid
            } else if (mid > x / mid) {
                right = mid - 1
            } else {
                left = mid + 1
            }
        }

        return right

    }

}
