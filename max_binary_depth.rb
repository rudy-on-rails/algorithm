class TreeNode
    attr_accessor :val, :left, :right
    def initialize(val = 0, left = nil, right = nil)
        @val = val
        @left = left
        @right = right
    end

    def to_s
      "L -> #{left}, R -> #{right}"
    end
end

def max_depth(root, depth_right = 1, depth_left = 1)
    if root == nil
      return 0
    end

    if root.left
        depth_left += max_depth(root.left, depth_left)
    end

    if root.right
        depth_right += max_depth(root.right, depth_right)
    end

    [depth_left, depth_right].max
end

tree = TreeNode.new(1, TreeNode.new(2, TreeNode.new(3, TreeNode.new(4, TreeNode.new(5)))))
puts "#{max_depth(tree)}"
