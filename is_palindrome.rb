def is_palindrome(x)
  x.to_s.reverse == x.to_s
end

puts is_palindrome(-121)
