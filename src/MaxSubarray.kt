
class MaxSubarray {
    fun maxSubArray(nums: IntArray): Int {
        var maxSum = 0
        if (nums.any()){
            maxSum = nums[0]
        }
        var sumFromCurrentStartIndex = 0
        for (idx in 0..nums.lastIndex) {
            sumFromCurrentStartIndex += nums[idx]
            if (sumFromCurrentStartIndex > maxSum) {
                maxSum = sumFromCurrentStartIndex
            }
            if (sumFromCurrentStartIndex < 0) {
                sumFromCurrentStartIndex = 0
            }
        }
        return maxSum
    }
}

// [1,2,3,4]
