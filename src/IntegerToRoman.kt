class IntegerToRoman {
    private val numToChar = listOf(
        1 to "I",
        4 to "IV",
        5 to "V",
        9 to "IX",
        10 to "X",
        40 to "XL",
        50 to "L",
        90 to "XC",
        100 to "C",
        400 to "CD",
        500 to "D",
        900 to "CM",
        1000 to "M"
    )

    fun intToRoman(num: Int): String {
        var numberCopy = num
        var roman = ""
        while (numberCopy > 0) {
            numToChar.forEachIndexed { index, pair ->
                if (numberCopy < pair.first && numberCopy > numToChar[index - 1].first) {
                    val prevPair = numToChar[index - 1]
                    roman += prevPair.second
                    numberCopy -= prevPair.first
                }
                if (numberCopy > pair.first && index == numToChar.lastIndex) {
                    roman += pair.second
                    numberCopy -= pair.first
                }
                if (numberCopy == pair.first) {
                    roman += pair.second
                    numberCopy -= pair.first
                }
            }
        }
        return roman
    }
}
