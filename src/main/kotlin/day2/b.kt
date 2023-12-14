package day2

import readFile
import kotlin.system.measureTimeMillis

fun b(): Int {
    val input = readFile(2)

    val powers = mutableListOf<Int>()

    for (line in input) {
        val (_, list) = line.split("Game ")[1].split(": ")
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

        powers.add(reds * blues * greens)
    }

    return powers.sum()
}
