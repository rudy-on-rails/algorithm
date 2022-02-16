def length_of_longest_substring(s)
  return 0 if s.length == 0
  return 1 if s.length == 1
  if s.split(" ").size > 1
      chars = s.split(" ")[0].chars
      chars << " "
  else
      chars = s.chars
  end

  max = 0
  idx = 0

  while idx < chars.length
    ss = ""
    chars[idx..].each do |char|
      if ss.include?(char)
        ss = ""
      end
      ss << char
      if ss.length > max
        max = ss.length
      end
    end
    idx += 1
  end
  max
end

puts length_of_longest_substring("au")
