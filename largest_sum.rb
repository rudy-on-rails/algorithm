    str_tree = %{55
               94 48
             95 30 96
           77 72 26 67
          97 13 76 38 45
         07 36 79 16 37 68
        48 07 09 18 70 26 06
       18 72 79 46 59 79 29 90
      20 76 87 11 32 07 07 49 18
     27 83 58 35 72 11 25 57 29 85
    14 64 36 96 27 11 58 56 92 18 55
   02 90 03 60 48 49 41 46 33 36 47 23}

levels = str_tree.split("\n").map{|level| level.split(' ')}

def divide_levels(levels, output={}, index=0)
  output ||= {}
  if levels[index]
    output[levels[index]] = divide_levels(levels[index+1..-1], output[levels[index]], index)
  end
  output
end

def build_numbers_graph(sub_levels, compare_index=0)
  sub_levels.each.with_object({}) do |(keys,values), hash|
    keys.each.with_index(0) do |key, index|
      if compare_index == index || compare_index + 1 == index
        hash[key] = build_numbers_graph(values, index)
      end
    end
  end
end

def largest_path(node, current=[])
  if node
    largest = node.keys.sort.last
    current << largest if largest
    largest_path(node[largest], current)
  end
  current
end

tree = build_numbers_graph(divide_levels(levels))
pp largest_path(tree)
