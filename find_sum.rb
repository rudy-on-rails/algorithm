def find_two_sum(nums, val)
  table = {}
  nums.each.with_index do |num, idx|
    if idx2 = table[num]
      return [idx2, idx] if idx != idx2
    end
    table[val - num] = idx
  end
  return []
end

pp find_two_sum([3,3], 6)
