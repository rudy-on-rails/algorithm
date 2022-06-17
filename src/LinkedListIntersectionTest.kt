import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

internal class LinkedListIntersectionTest {
    @Test
    fun itWorks() {
        val intersectionNode = LinkedListIntersection
            .ListNode(8)
            .also {
                it.next = LinkedListIntersection
                    .ListNode(4)
                    .also {
                        it.next = LinkedListIntersection
                            .ListNode(5)
                    }
            }
        val l1 = LinkedListIntersection
            .ListNode(4)
            .also {
                it.next = LinkedListIntersection
                    .ListNode(1)
                    .also {
                        it.next = intersectionNode
                    }
            }

        val l2 = LinkedListIntersection
            .ListNode(6)
            .also {
                it.next = LinkedListIntersection
                    .ListNode(6)
                    .also {
                        it.next = LinkedListIntersection
                            .ListNode(1)
                            .also {
                                it.next = intersectionNode
                            }
                    }
            }

        assertEquals(8, LinkedListIntersection().getIntersectionNode(l1, l2)?.`val`)
    }
}
