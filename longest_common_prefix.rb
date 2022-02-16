def longest_common_prefix(strs)
  prefix = ""
  strs.first.chars.each do |str|
    if all_words_have_prefix?(strs, prefix + str)
      prefix += str
    end
  end
  prefix
end

def all_words_have_prefix?(words, prefix)
  words.all?{|a| a.start_with?(prefix)}
end

puts longest_common_prefix(["flower","flow","flight"])
