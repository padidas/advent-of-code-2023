package day1

import readFile

fun a(): Int {

    val input = readFile(1)

    val calibrationValues = input.map { line ->
        var first: Int? = null
        var last: Int? = null

        for (char in line) {
            if (char.isDigit()) {
                if (first == null) first = char.digitToInt()
                last = char.digitToInt()
            }
        }
        return@map "$first$last".toInt()
    }

    val calibrationValuesSum = calibrationValues.sum()
    return calibrationValuesSum
}
