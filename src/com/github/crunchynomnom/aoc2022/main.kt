import com.github.crunchynomnom.aoc2022.puzzles.*
import java.io.File
import java.lang.IllegalArgumentException
import kotlin.time.DurationUnit
import kotlin.time.ExperimentalTime
import kotlin.time.measureTime

@ExperimentalTime
fun main(args: Array<String>) {
    if(args.size !in 2..3) {
        println("Invalid number of args; usage: <puzzle-number> puzzle|example <part-number>")
    }

    val input = readInput(args[0], args[1] == "puzzle")
    val day : Puzzle = when (args[0]) {
        "01" -> Day01()
        "02" -> Day02()
        "03" -> Day03()
        "04" -> Day04()
        "05" -> Day05()
        "06" -> Day06()
        "07" -> Day07()
        "08" -> Day08()
        else -> throw IllegalArgumentException("Day not found!")
    }

    val task = if (args.size == 3) {
        when (args[2]) {
            "1" -> Puzzle::part1
            "2" -> Puzzle::part2
            else -> Puzzle::runAll
        }
    } else Puzzle::runAll

    measureTime {
        task.invoke(day, input)
    }.also { println("\nDuration: " + it.toString(DurationUnit.SECONDS, 3)) }

}

abstract class Puzzle {
    abstract fun part1(input: File)
    abstract fun part2(input: File)

    fun runAll(input: File) {
        part1(input)
        println("===================================================================================================")
        part2(input)
    }
}
