def combination_sum(candidates, target)
  candidates = candidates.select{ |n| n <= target }
  result = []
  find_with_backtrack(target, [], 0, candidates, result)
  result
end

def find_with_backtrack(reminder, combinations, idx, candidates, result)
  if reminder == 0
    result << combinations.clone
    return
  elsif reminder < 0
    return
  end

  while idx < candidates.length
    combinations << candidates[idx]
    find_with_backtrack(reminder - candidates[idx], combinations, idx, candidates, result)
    combinations.pop
    idx += 1
  end
end

pp combination_sum([2,3,6,7], 7) # [[2,2,3],[7]]
pp combination_sum([2,3,5], 8) # [[2,2,2,2],[2,3,3],[3,5]]
pp combination_sum([2], 1) # []
