package day3

import readFile

/**
 * already tried before:
 * - 549292
 *
 */

fun main() {
    val input = readFile(3)
    val partNumbers = mutableListOf<Int>()

    for ((lineIndex, line) in input.withIndex()) {
        var num = FoundNumber()

        for ((charIndex, char) in line.withIndex()) {

            if (char.isDigit()) {
                num.number += char
                num.indexes.add(charIndex)
                continue
            }

            if (!char.isDigit()) {
                if (num.number == "") {
                    continue
                } else { // check surrounding for symbols

                    val betrachteteNumber = num.number

                    val firstIndex = if (num.indexes.first() > 0) num.indexes.first() - 1 else 0
                    val lastIndex = if (num.indexes.last() == line.lastIndex) num.indexes.last() else num.indexes.last() + 1
                    val hitZone = firstIndex..lastIndex

                    // check line above
                    if (lineIndex != 0) {
                        for (hitZoneIndex in hitZone) {
                            val focusedChar = input[lineIndex - 1][hitZoneIndex]
                            if (focusedChar.isSpecial())
                                num.isPartNumber = true
                        }
                    }

                    // check line below
                    if (lineIndex != line.lastIndex) {
                        for (hitZoneIndex in hitZone) {
                            val focusedChar = input[lineIndex + 1][hitZoneIndex]
                            if (focusedChar.isSpecial())
                                num.isPartNumber = true
                        }
                    }

                    // check same line
                    if (line[firstIndex].isSpecial() || line[lastIndex].isSpecial())
                        num.isPartNumber = true

                    if (num.isPartNumber)
                        partNumbers.add(num.number.toInt())

                    num = FoundNumber()
                }
            }
        }
    }

    println(partNumbers.sum())
}

data class FoundNumber(
    var number: String = "",
    val indexes: MutableList<Int> = mutableListOf(),
    var isPartNumber: Boolean = false
)

fun Char.isSpecial(): Boolean =
    this == '-'
    || this == '&'
    || this == '/'
    || this == '*'
    || this == '@'
    || this == '#'
    || this == '%'
    || this == '+'
    || this == '$'
    || this == '='
