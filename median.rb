def find_median_sorted_arrays(nums1, nums2)
    total = (nums1 + nums2).sort
    if total.length % 2 == 1
      mid = total.length / 2
      total[mid]
    else
      mid = (total.length / 2) - 1
      (total[mid] + total[mid+1]) /  2.to_f
    end
end

puts find_median_sorted_arrays([1,3], [2])
puts find_median_sorted_arrays([1,3], [2,4])
puts find_median_sorted_arrays([],[1,2,3,4,5])
