package day3

import readFile

fun a(): Int {
    val input = readFile(3)
    val partNumbers = mutableListOf<Int>()

    for ((lineIndex, line) in input.withIndex()) {
        var num = FoundNumber()

        for ((charIndex, char) in line.withIndex()) {

            if (char.isDigit()) {
                num.number += char
                num.indexes.add(charIndex)
            }

            if (!char.isDigit() || charIndex == line.lastIndex) {
                if (num.number == "") {
                    continue
                } else { // check surrounding for symbols

                    val firstIndex = if (num.indexes.first() > 0) num.indexes.first() - 1 else 0
                    val lastIndex = if (num.indexes.last() == line.lastIndex) num.indexes.last() else num.indexes.last() + 1
                    val hitZone = firstIndex..lastIndex

                    // check same line
                    checkHitZoneA(hitZone, input[lineIndex], num)

                    // check line above
                    if (lineIndex != 0)
                        checkHitZoneA(hitZone, input[lineIndex - 1], num)

                    // check line below
                    if (lineIndex != line.lastIndex)
                        checkHitZoneA(hitZone, input[lineIndex + 1], num)

                    if (num.isPartNumber)
                        partNumbers.add(num.number.toInt())

                    // reset num
                    num = FoundNumber()
                }
            }
        }
    }

    return partNumbers.sum()
}
