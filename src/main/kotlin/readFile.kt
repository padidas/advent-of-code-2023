import java.io.File

fun readFile(day: Int): List<String> = File("src/main/kotlin/day$day/input.txt").useLines { it.toList() }