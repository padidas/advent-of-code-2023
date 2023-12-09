package day2

import readFile

/**
 *
 * Game 1: 3 blue, 4 red; 1 red, 2 green, 6 blue; 2 green
 *
 * Game 2: 1 blue, 2 green; 3 green, 4 blue, 1 red; 1 green, 1 blue
 *
 * Game 3: 8 green, 6 blue, 20 red; 5 blue, 4 red, 13 green; 5 green, 1 red
 *
 * Game 4: 1 green, 3 red, 6 blue; 3 green, 6 red; 3 green, 15 blue, 14 red
 *
 * Game 5: 6 red, 1 blue, 3 green; 2 blue, 1 red, 2 green
 *
 * 12 red, 13 green, 14 blue
 */

fun main() {
    val input = readFile(2)

        val redLimit = 12
        val greenLimit = 13
        val blueLimit = 14

        val matchingIds = mutableListOf<Int>()

        for (line in input) {
            val (id, list) = line.split("Game ")[1].split(": ")
            val colorAmountArr = list.split(",", ";")

            val reds = colorAmountArr
                .filter { it.contains("red") }
                .maxOfOrNull { it.strip().split(" ")[0].toInt() } ?: 0
            val blues = colorAmountArr
                .filter { it.contains("blue") }
                .maxOfOrNull { it.strip().split(" ")[0].toInt() } ?: 0
            val greens = colorAmountArr
                .filter { it.contains("green") }
                .maxOfOrNull { it.strip().split(" ")[0].toInt() } ?: 0

            if (greens <= greenLimit && reds <= redLimit && blues <= blueLimit)
                matchingIds.add(id.toInt())
        }

        println(matchingIds.sum())
}