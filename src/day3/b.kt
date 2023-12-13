package day3

import readFile

fun b(): Int {
    val input = readFile(3)
    val partNumbers = mutableListOf<FoundNumber>()

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
                    checkHitZoneB(hitZone, input[lineIndex], num, lineIndex)

                    // check line above
                    if (lineIndex != 0)
                        checkHitZoneB(hitZone, input[lineIndex - 1], num, lineIndex - 1)

                    // check line below
                    if (lineIndex != line.lastIndex)
                        checkHitZoneB(hitZone, input[lineIndex + 1], num, lineIndex + 1)

                    if (num.isPartNumber)
                        partNumbers.add(num)

                    // reset num
                    num = FoundNumber()
                }
            }
        }
    }

    val partNumberPairs = mutableListOf<Pair<Int, Int>>()

    partNumbers.forEach { focusNumber ->
        val matches = partNumbers.filter { it.star == focusNumber.star }
        if (matches.size == 2) {
            partNumberPairs.add(Pair(matches[0].number.toInt(), matches[1].number.toInt()))
        }
    }

    return partNumberPairs.fold(0) { acc, pair -> acc + (pair.first * pair.second) } / 2
}

// wrong:
// 22620944
// 11310472