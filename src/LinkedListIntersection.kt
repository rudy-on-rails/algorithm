import java.util.ArrayDeque

class LinkedListIntersection {
  class ListNode(var `val`: Int) {
      var next: ListNode? = null
  }

    fun getIntersectionNode(headA:ListNode?, headB:ListNode?):ListNode? {
        if (headA == null || headB == null) return null
        var nextA = headA
        val nodeArrayDequeA = ArrayDeque<ListNode>()
        while (nextA != null) {
            nodeArrayDequeA.add(nextA)
            nextA = nextA.next
        }
        var nextB = headB
        val nodeArrayDequeB = ArrayDeque<ListNode>()
        while (nextB != null) {
            nodeArrayDequeB.add(nextB)
            nextB = nextB.next
        }

        while (nodeArrayDequeA.size > nodeArrayDequeB.size) {
            nodeArrayDequeA.pop()
        }
        while (nodeArrayDequeB.size > nodeArrayDequeA.size) {
            nodeArrayDequeB.pop()
        }

        while (nodeArrayDequeA.size > 0) {
            val node = nodeArrayDequeA.pop()
            if (node == nodeArrayDequeB.pop()) {
                return node
            }
        }

        return null

    }
}
