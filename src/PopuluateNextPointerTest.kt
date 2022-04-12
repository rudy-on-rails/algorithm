import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

internal class PopuluateNextPointerTest {
    @Test
    fun itWorksFine() {
        val root = Node(1)
        root.left = Node(2)
        root.right = Node(3)
        root.right!!.right = Node(7)
        root.left!!.left = Node(4)
        root.left!!.right = Node(5)

        PopuluateNextPointer().connect(root).also {
            assertEquals(null, it?.next)
            assertEquals(3, it?.left?.next?.`val`)
            assertEquals(null, it?.right?.next?.`val`)
            assertEquals(5, it?.left?.left?.next?.`val`)
            assertEquals(7, it?.left?.right?.next?.`val`)
        }
    }
}
