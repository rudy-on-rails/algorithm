class Node(var `val`: Int) {
    var left: Node? = null
    var right: Node? = null
    var next: Node? = null
}

class PopuluateNextPointer {
    fun connect(root: Node?): Node? {
        val threeHashMapLevel = mutableMapOf<Int, MutableList<Node?>>()
        threeHashMapLevel[0] = mutableListOf(root)
        addNewLevel(1, root, threeHashMapLevel)
        threeHashMapLevel.forEach { (_, u) ->
            val notNullList = u.filterNotNull()
            notNullList.forEachIndexed { index, node ->
                if (notNullList.lastIndex >= index+1) {
                    node.next = notNullList[index + 1]
                }
            }
        }
        return root
    }

    private fun addNewLevel(i: Int, node: Node?, threeHashMapLevel: MutableMap<Int, MutableList<Node?>>){
        if (threeHashMapLevel[i] == null) {
            threeHashMapLevel[i] = mutableListOf()
        }

        if (node != null) {
            threeHashMapLevel[i]!!.add(node.left)
            threeHashMapLevel[i]!!.add(node.right)
            addNewLevel(i + 1, node.left, threeHashMapLevel)
            addNewLevel(i + 1, node.right, threeHashMapLevel)
        }
    }
}
