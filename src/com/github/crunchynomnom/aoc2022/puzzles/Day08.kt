package com.github.crunchynomnom.aoc2022.puzzles

import Puzzle
import java.io.File
import java.lang.Integer.max

class Day08 : Puzzle() {
    private lateinit var forest: List<List<Tree>>

    override fun part1(input: File) {
        forest = input.readLines().map { x -> x.map { Tree(it.code) }.toList()}

        for (y in 0 until forest.size) {
            traverseEast(0, y, 0)
        }
        for (x in 0 until forest[0].size) {
            traverseSouth(x, 0, 0)
        }
        println(forest.sumOf { it.count { it.exposed } })
    }

    override fun part2(input: File) {
        forest = input.readLines().map { x -> x.map { Tree(it.code) }.toList()}

        for (y in 1 until forest.size-1) {
            for (x in 1 until forest[0].size-1) {
                forest[x][y].uVision = getVision(x, y, y-1 downTo 0, true).also { print("$it ") }
                forest[x][y].dVision = getVision(x, y, y+1 until forest.size, true).also { print("$it ") }
                forest[x][y].lVision = getVision(x, y, x-1 downTo 0, false).also { print("$it ") }
                forest[x][y].rVision = getVision(x, y, x+1 until forest[0].size, false).also { print("$it ") }
            }
        }
        println(forest.maxOf { it.maxOf { tree -> tree.dVision * tree.uVision * tree.rVision * tree.lVision } })
    }

    private fun traverseSouth(x: Int, y: Int, highestSoFar: Int): Int = traverse(x, y, highestSoFar, true)
    private fun traverseEast(x: Int, y: Int, highestSoFar: Int): Int = traverse(x, y, highestSoFar, false)

    // returns highest from the direction towards the traversing is conducted
    private fun traverse(x: Int, y: Int, highestSoFar: Int, goesDown: Boolean): Int {
        if (forest[x][y].height > highestSoFar) {
            forest[x][y].exposed = true
        }
        var returned = 0
        if (goesDown) {
            if (y + 1 == forest[0].size) {
                forest[x][y].exposed = true
                return forest[x][y].height
            }
            returned = traverseSouth(x, y + 1, max(highestSoFar, forest[x][y].height))
        } else {
            if (x + 1 == forest[0].size) {
                forest[x][y].exposed = true
                return forest[x][y].height
            }
            returned = traverseEast(x + 1, y, max(highestSoFar, forest[x][y].height))
        }
        forest[x][y].exposed = x == 0 || y == 0 || forest[x][y].exposed || returned < forest[x][y].height
        return max(forest[x][y].height, returned)
    }

    private fun getVision(x: Int, y: Int, range: IntProgression, vertical: Boolean): Int {
        var count = 0
        for (i in range) {
            count++
            if (vertical && (forest[x][i].height >= forest[x][y].height)) break
            if (!vertical && (forest[i][y].height >= forest[x][y].height)) break
        }
        return count
    }

    data class Tree(
        val height: Int,
        var dVision: Int = 0,
        var uVision: Int = 0,
        var rVision: Int = 0,
        var lVision: Int = 0,
        var exposed: Boolean = false
    ) {
        override fun toString(): String = "${height - '0'.code} ${if (exposed) "." else "H"}"
    }
}

