import com.github.crunchynomnom.aoc2022.puzzles.*
import java.lang.IllegalArgumentException

fun main(args: Array<String>) {
    if(args.size !in 2..3) {
        println("Invalid number of args; usage: <puzzle-number> puzzle|example <part-number>")
    }

    val input = readInput(args[0], args[1] == "puzzle")
    val day : Puzzle = when (args[0]) {
        "01" -> Day01()
        else -> throw IllegalArgumentException("Day not found!")
    }

    if (args.size == 3) {
        when (args[2]) {
            "1" -> day.part1(input)
            "2" -> day.part2(input)
        }
    } else day.runAll(input)

}

abstract class Puzzle {
    abstract fun runAll(input: List<String>)
    abstract fun part1(input: List<String>)
    abstract fun part2(input: List<String>)

    fun printHorizontalBreak() {
        println("===================================================================================================")
    }
}
