def is_valid(s)
  par_map = {
    "(" => ")",
    "{" => "}",
    "[" => "]"
  }.invert
  par_stack = []
  s.chars.each.with_index do |char, index|
    if par_map[char]
      if par_map[char] != par_stack.pop
        return false
      end
    else
      par_stack << char
    end
  end
  if par_stack.any?
    return false
  end
  return true
end

pp is_valid("()")
pp is_valid("{[]}")
pp is_valid("([[])")

