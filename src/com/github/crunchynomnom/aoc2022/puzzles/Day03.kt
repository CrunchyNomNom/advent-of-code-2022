package com.github.crunchynomnom.aoc2022.puzzles

import Puzzle
import java.io.File

class Day03 : Puzzle() {
    override fun part1(input: File) {
        println(input.readLines().sumOf { getPrio(findMatch(it)) })
    }

    override fun part2(input: File) {
        println(input.readLines().chunked(3).sumOf { getPrio(getCommonFor3(it)) })
    }

    // returns common letter
    private fun findMatch(backpack: String): Char {
        val existsOnLeft = BooleanArray(53) { _ -> false}
        for (i in 0 until backpack.length/2) {
            existsOnLeft[getPrio(backpack[i])] = true
        }
        for (i in 0 until backpack.length/2) {
            if (existsOnLeft[getPrio(backpack[backpack.length/2 + i])]) {
                return backpack[backpack.length/2 + i]
            }
        }
        return '!'
    }

    private fun getPrio(c: Char): Int {
        if (c.isLowerCase()) return c.minus('`')
        return c.minus('&')
    }

    private fun getCommonFor3(backpacks: List<String>): Char {
        val b = backpacks.sortedBy { it.length }
        val existsOnFirst = BooleanArray(53) { _ -> false}
        val existsOnSecond = BooleanArray(53) { _ -> false}
        for (l in b[0])
            existsOnFirst[getPrio(l)] = true
        for (l in b[1])
            existsOnSecond[getPrio(l)] = true
        for (l in b[2]) {
            val ll = getPrio(l)
            if (existsOnFirst[ll] and existsOnSecond[ll])
                return l
        }
        return '!'
    }
}

