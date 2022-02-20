def remove_element(nums, val)
  idx = 0
  while idx < nums.size
    if nums[idx] == val
      nums.delete_at(idx)
      nums.push(nil)
      idx -= 1
    end
    idx += 1
  end
  nums
end

pp remove_element([1,2,2,3,4,5,2,2],2)
