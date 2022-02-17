def longest_palindrome(s)
  return s if s.length < 2
  s_length = s.length
  idx = 0
  longest_palindrome = ""
  same_chars = []

  for idx_rev in (s_length-1).downto(0)
    for idx in 0..s_length-1
      same_chars[idx] = s[idx] == s[idx_rev] && (idx - idx_rev < 3 || same_chars[idx-1])
      if same_chars[idx] && (longest_palindrome.length < idx - idx_rev + 1)
        longest_palindrome = s[idx_rev..(idx)]
      end
    end
  end
  longest_palindrome
end

pp longest_palindrome("babad")
