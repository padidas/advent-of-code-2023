package day2

import readFile

fun a(): Int {
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

        return matchingIds.sum()
}