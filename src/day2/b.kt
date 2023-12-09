package day2

import readFile
import kotlin.system.measureTimeMillis

/**
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

    val timer = measureTimeMillis {

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

            powers.add(reds*blues*greens)

        }

        println(powers.sum())
    }


    println("timer $timer")
}