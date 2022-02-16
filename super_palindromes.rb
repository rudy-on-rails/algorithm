def superpalindromes_in_range(left, right)
  count = 0
  nbr = left.to_i
  while nbr < right.to_i
    count += 1 if Math.sqrt(nbr) % 1 == 0.00 && is_palindrome?(nbr.to_i) && is_super_palindrome?(nbr.to_i)
  end
end

def is_palindrome?(nbr)
  nbr.to_s.reverse == nbr.to_s
end

def is_super_palindrome?(nbr)
  is_palindrome?(Integer.sqrt(nbr))
end
puts superpalindromes_in_range("40000000000000000", "50000000000000000")
