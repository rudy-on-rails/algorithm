def remove_duplicates(nums)
  dups = []
  for idx in 0..nums.length - 1
    if nums[idx] == nums[idx + 1]
      dups << idx + 1
    end
  end
  idx = 0
  dups.each.with_index do |dup_idx, idx|
    nums.delete_at(dup_idx - idx)
  end
  nums.size
end

pp remove_duplicates([0,0,1,1,1,1,1,2,2,3,3,4])
