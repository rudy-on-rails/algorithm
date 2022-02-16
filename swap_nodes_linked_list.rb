class ListNode
  attr_accessor :val, :next
  def initialize(val = 0, _next = nil)
    @val = val
    @next = _next
  end

  def to_s
    "#{val} -> #{@next}"
  end
end

def swap_pairs(head)
  return nil if head == nil
  array = to_array(head)
  new_array = []
  part = []
  idx = 0
  while el = array.shift
    idx += 1
    part << el
    if idx % 2 == 0 || array.length == 0
      new_array.concat(part.reverse)
      part = []
    end
  end
  to_list(new_array)
end

def to_list(array)
  if el = array.shift
    list = ListNode.new(el)
    list.next = to_list(array)
    list
  else
    list
  end
end

def to_array(list, array = [])
  array << list.val
  if list.next
    to_array(list.next, array)
  else
    array
  end
end

nodes = ListNode.new(1)
puts swap_pairs(nodes)
