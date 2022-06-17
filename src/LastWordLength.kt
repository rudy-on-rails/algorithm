class LastWordLength {
    fun lengthOfLastWord(s: String): Int {
        return s
            .split(" ").lastOrNull { it.length > 1 }
            ?.length ?: 1
    }
}
