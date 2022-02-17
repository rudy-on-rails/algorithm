def remove_kdigits(num, k)
  return "0" if num.length == k
  stack = []

  num.chars.each.with_index do |char, idx|
    while !stack.empty? && stack[-1] > char && k > 0
      if removed = stack.pop
        k -= 1
      end
    end
    stack.push(char)
  end

  while k > 0
    stack.pop
    k -= 1
  end

  while stack[0] == '0'
    stack.shift
  end

  stack.join.to_i.to_s
end

pp remove_kdigits("1234567890", 9) # should eq(200)
