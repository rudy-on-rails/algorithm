require 'set'
def three_sum(nums)
  three_sums = Set.new
  while nums.length > 0
    first = nums.pop
    table = {}
    target = 0 - first

    nums.each.with_index do |num, idx|
      if f = table[num]
        three_sums << [first, num, nums[f]].sort if f != idx
      end
      table[target-num] = idx
    end
  end
  three_sums.to_a
end

pp three_sum([0]*500+[-1]*500+[1]*500)
