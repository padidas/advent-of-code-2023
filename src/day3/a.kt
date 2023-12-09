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

    for ((i, line) in input.withIndex()) {
        var p = 0
        var num = FoundNumber()

        while (p <= line.length - 1) {

            val char1 = line[p]

            if (char1.isDigit()) {
                num.number += char1
                num.indexes.add(p)
                p++
                continue
            }

            if (!char1.isDigit()) {
                if (num.number == "") {
                    p++
                    continue
                } else { // check surrounding for symbols

                    val betrachteteNumber = num.number

                    val firstIndex = if (num.indexes.first() - 1 >= 0) num.indexes.first() - 1 else 0
                    val lastIndex = if (num.indexes.last() == line.lastIndex) num.indexes.last() else num.indexes.last() + 1

                    // check line above
                    if (i != 0) {
                        for (index in firstIndex..lastIndex) {
                            val focusedChar = input[i - 1][index]
                            if (!focusedChar.isDigit() && focusedChar != '.') {
                                num.isPartNumber = true
                            }
                        }
                    }

                    // check line below
                    if (i != line.lastIndex) {
                        for (index in firstIndex..lastIndex) {
                            val focusedChar = input[i + 1][index]
                            if (!focusedChar.isDigit() && focusedChar != '.') {
                                num.isPartNumber = true
                            }
                        }
                    }

                    // check same line
                    if (!line[firstIndex].isDigit() && line[firstIndex] != '.' || !line[lastIndex].isDigit() && line[lastIndex] != '.') {
                        num.isPartNumber = true
                    }

                    if (num.isPartNumber) {
                        partNumbers.add(num.number.toInt())
                    }

                    p++
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
