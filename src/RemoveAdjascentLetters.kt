import java.util.Stack

class RemoveAdjascentLetters {
    companion object {
        fun removeDuplicates(input: String, numberOfChars: Int): String {
            var currChar = ' '
            var startIndex = 0
            var endIndex: Int
            input.forEachIndexed { index, c ->
                if (currChar.isWhitespace() || currChar == c) {
                    currChar = c
                    endIndex = index
                    if ((index - startIndex + 1) >= numberOfChars) {
                        return removeDuplicates(input.removeRange(startIndex, endIndex+1), numberOfChars)
                    }
                } else {
                    startIndex = index
                    currChar = c
                }
            }
            return input
        }

        fun removeDuplicatesStack(input: String, numberOfChars: Int): String {
            val stack = Stack<CharCount>()
            input.forEach { c ->
                if (!stack.empty() && stack.peek().char == c) {
                    if (stack.peek().count + 1 == numberOfChars) {
                        stack.pop()
                    } else {
                        stack.peek().count+=1
                    }
                } else {
                    stack.push(CharCount(c))
                }
            }
            var outputString = ""
            stack.toList().forEach {
                for (n in 0 until it.count) {
                    outputString += it.char
                }
            }
            return outputString
        }

        data class CharCount(
            var char: Char,
            var count: Int = 1
        )
    }
}

