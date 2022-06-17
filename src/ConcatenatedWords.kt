class ConcatenatedWords {
    fun findAllConcatenatedWordsInADict(words: Array<String>): List<String> {
        val output = mutableSetOf<String>()
        val wordsSet = words.toSet()

        wordsSet.forEachIndexed { idx, word ->

        }

        return output.toList()
    }

    private fun isConcatenationOfTwoOrMoreWordsIn(
        words: Set<String>,
        targetWord: String
    ): Boolean {
        var count = 0
        var targetWordCopy = targetWord
        words.forEach { word ->
            if (targetWordCopy.contains(word)) {
                targetWordCopy = targetWordCopy.replace(word, "")
                count += 1
                if (count > 1 && targetWordCopy.isEmpty()){
                    return true
                }
            }
        }
        return false
    }
}
