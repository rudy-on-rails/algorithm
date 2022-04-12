#
# Given an input array, find the size of the longest sequence.
#
# Each index of the array contains a number with a valid index of the same array. The same number can’t exists in the same sequence. Examples:
#
def longest_sequence(array)
  longest_sequence = 0
  array.each do |next_index|
    current_sequence = count_sequence_starting_from(array, next_index, 1, [])
    if current_sequence > longest_sequence
      longest_sequence = current_sequence
    end
  end
  longest_sequence
end

def count_sequence_starting_from(array, next_index, current_count, sequence_numbers)
  if array[next_index] < next_index
    sequence_numbers << next_index
    count_sequence_starting_from(array, array[next_index], current_count+1, sequence_numbers)
  else
    current_count
  end
end

pp longest_sequence([2, 1, 0])
pp longest_sequence([5, 2, 1, 3, 0, 4])
