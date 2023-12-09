import java.io.File

fun readFile(day: Int): List<String> = File("src/day$day/input.txt").useLines { it.toList() }