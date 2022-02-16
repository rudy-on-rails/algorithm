class HashMap
  class Node
    attr_accessor :key, :value
    attr_reader :child
    def initialize(key, value)
      @key = key
      @value = value
      @child = nil
    end

    def add_child(node)
      @child = node
    end

    def to_s
      "Key: #{key} - Value: #{value} - Child: #{child}"
    end
  end

  def initialize(key, value)
    @root = Node.new(key, value)
  end

  def put(key, value)
    if @root.key == key
      @root.value = value
    else
      last_free_node.add_child(Node.new(key, value))
    end
  end

  def get(key)
    traverse_keys(@root, key)&.value
  end

  def to_s
    construct_tree_string(@root)
  end

  def keys
    get_key(@root)
  end

  def values
    get_values(@root)
  end

  private
  def get_key(node)
    keys = []
    if node
      keys << node.key
    end
    if node.child
      keys.concat(get_key(node.child))
    end
    keys
  end

  def get_values(node)
    values = []
    if node
      values << node.value
    end
    if node.child
      values.concat(get_values(node.child))
    end
    values
  end

  def traverse_keys(node, key)
    if node.key == key
      node
    else
      traverse_keys(node.child, key)
    end
  end

  def construct_tree_string(node)
    string = ''
    string = "#{node.to_s}.." if node
    string += construct_tree_string(node.child) if node
    string
  end

  def last_free_node(parent=@root)
    if parent.child == nil
      parent
    else
      last_free_node(parent.child)
    end
  end
end

hash = HashMap.new(1, 'Rudy')
hash.put(1, 'Test')
hash.put(2, 'HAHAHAHA')
hash.put(3, 'oooops')
puts hash.to_s
puts hash.get(1) == 'Test'
puts hash.get(2) == 'HAHAHAHA'
puts hash.get(3) == 'oooops'
puts hash.keys == [1,2,3]
puts hash.values == ['Test','HAHAHAHA','oooops']

hash = HashMap.new("1", 'Rudy')
hash_two = HashMap.new("2", hash)
puts hash_two.get("2").keys == ["1"]
puts hash_two.get("2").get("1") == 'Rudy'
