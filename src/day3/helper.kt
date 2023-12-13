package day3

data class FoundNumber(
    var number: String = "",
    val indexes: MutableList<Int> = mutableListOf(),
    var isPartNumber: Boolean = false,
    var star: Pair<Int, Int>? = null,
)

fun Char.isSpecial(): Boolean = this == '-' || this == '&'
        || this == '/' || this == '*' || this == '@' || this == '#'
        || this == '%' || this == '+' || this == '$' || this == '='

fun checkHitZoneA(hitZone: IntRange, line: String, num: FoundNumber) {
    for (hitZoneIndex in hitZone) {
        val focusedChar = line[hitZoneIndex]
        if (focusedChar.isSpecial())
            num.isPartNumber = true
    }
}

fun checkHitZoneB(hitZone: IntRange, line: String, num: FoundNumber, lineIndex: Int) {
    for (hitZoneIndex in hitZone) {
        val focusedChar = line[hitZoneIndex]
        if (focusedChar == '*') {
            num.isPartNumber = true
            num.star = Pair(lineIndex, hitZoneIndex)
        }
    }

}