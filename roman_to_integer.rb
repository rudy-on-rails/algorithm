def roman_to_int(s)
  char_map = {
    "I" => 1,
    "V" => 5,
    "X" => 10,
    "L" => 50,
    "C" => 100,
    "D" => 500,
    "M" => 1000
  }
  mod_chars = {
    "I" => ["V","X"],
    "X" => ["L","C"],
    "C" => ["D","M"]
  }

  int = 0
  all_chars = s.chars
  all_chars.each.with_index do |char, idx|
    if mod_chars[char] && mod_chars[char].include?(all_chars[idx+1])
      int -= char_map[char]
    else
      int += char_map[char]
    end
  end
  int
end

pp roman_to_int("XIX")
