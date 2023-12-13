package day1

import readFile

class Pointers(var one: Int = 0, var two: Int = 0, var focus: String = "") {
    fun reset() {
        this.one++
        this.two = this.one
        this.focus = ""
    }
}

fun b(): Int {
    val input = readFile(1)

    val calibrationValues = input.map { line ->

        val matches = mutableListOf<Char>()
        val p = Pointers()

        while (p.one <= line.length - 1) {

            if (line[p.one].isDigit()) {
                matches.add(line[p.one])
                p.reset()
                continue
            }

            if (p.two == line.length || line[p.two].isDigit()) {
                p.reset()
                continue
            }

            p.focus += line[p.two]
            p.two++

            if (digitsMap.containsKey(p.focus)) {
                matches.add(digitsMap[p.focus]!!)
                p.reset()
            }
        }

        return@map "${matches.first()}${matches.last()}".toInt()
    }

    return calibrationValues.sum()
}


val digitsMap = mapOf(
    "one" to '1',
    "two" to '2',
    "three" to '3',
    "four" to '4',
    "five" to '5',
    "six" to '6',
    "seven" to '7',
    "eight" to '8',
    "nine" to '9',
)