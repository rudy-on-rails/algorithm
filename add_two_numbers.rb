class ListNode
  attr_accessor :val, :next
  def initialize(val = 0, _next = nil)
      @val = val
      @next = _next
  end
end

def add_two_numbers(l1, l2)
  arr1 = []
  arr2 = []
  to_array(arr1, l1)
  to_array(arr2, l2)
  regular = arr1.length > arr2.length
  starting_array = regular  ? arr1 : arr2
  output = []
  rest = 0
  starting_array.each.with_index(0) do |el, idx|
    new_number = rest + el
    if regular
      new_number += (arr2[idx] ? arr2[idx] : 0)
    else
      new_number += (arr1[idx] ? arr1[idx] : 0)
    end
    if new_number % 10 != new_number
      rest = 1
      new_number = new_number % 10
    else
      rest = 0
    end
    output << new_number
  end
  if rest > 0
    output << rest
  end
  output
end

def to_array(start, node)
  start << node.val
  if node.next
    to_array(start, node.next)
  else
    start
  end
end

l1 = ListNode.new(2, ListNode.new(4, ListNode.new(9)))
l2 = ListNode.new(5, ListNode.new(6, ListNode.new(4, ListNode.new(9))))
pp add_two_numbers(l1, l2)
