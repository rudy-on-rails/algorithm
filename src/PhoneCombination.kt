class PhoneCombination {
    fun letterCombinations(digits: String): List<String> {
        val mappings = createNumberMappings()
        val allLetters = digits.map { digitChar -> mappings[digitChar] }

        return combine(allLetters)
    }

    private fun combine(allLetters: List<List<Char>?>): List<String> {
        val combination = mutableSetOf<String>()
        if (allLetters.any()) {
            allLetters.first()?.forEach { digitLetter ->
                combineRecur(1, digitLetter.toString(), allLetters, combination)
            }
        }
        return combination.toList()
    }

    private fun combineRecur(
        idx: Int,
        digitLetter: String,
        allLetters: List<List<Char>?>,
        combination: MutableSet<String>
    ) {
        if (idx >= allLetters.size) {
            combination.add(digitLetter)
        } else {
            allLetters[idx]!!.forEach {
                combineRecur(idx+1, digitLetter + it, allLetters, combination)
            }
        }
    }

    private fun createNumberMappings(): Map<Char, List<Char>> {
        val resultMapping = hashMapOf<Char, List<Char>>()
        val allLetters = ('a'..'z').toMutableSet()
        val numbers = ('2'..'9')
        numbers.forEach{ number ->
            resultMapping[number] = if (number != '9' && number != '7') {
                allLetters.take(3)
            } else {
                allLetters.take(4)
            }
            allLetters.removeAll(resultMapping[number]!!.toSet())
        }
        return resultMapping
    }
}
