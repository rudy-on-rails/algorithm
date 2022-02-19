require 'set'

def minimum_deviation(nums)
  set = SortedSet.new
  nums.each.with_index do |num, idx|
    if num % 2 == 1
      set << num * 2
    else
      set << num
    end
  end

  diff = set.max - set.min

  while set.to_a[-1] % 2 == 0
    num = set.to_a[-1] / 2
    set << num
    set.delete(set.to_a[-1])
    diff = [diff, set.max - set.min].min
  end

  diff
end

pp minimum_deviation([2,8,6,1,6])
