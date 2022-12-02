package com.github.crunchynomnom.aoc2022.puzzles

import Puzzle

class Day01 : Puzzle() {
    override fun runAll(input: List<String>) {
        part1(input); part2(input);
    }

    override fun part1(input: List<String>) {
        println(input)
        var fattest = 0
        var current = 0
        for (x in input) {
            if (x == "") {
                if (fattest < current) fattest = current
                current = 0
            } else current += x.trim().toInt()
        }
        if (fattest < current) fattest = current
        println(fattest)
        println()
    }

    override fun part2(input: List<String>) {
        printHorizontalBreak()
        println("part2")
        var fattest3 = listOf(0, 0, 0)
        var current = 0
        for (x in input) {
            if (x == "") {
                fattest3 = fattest3.plus(current).sorted().subList(1, 4)
                current = 0
            } else current += x.trim().toInt()
        }
        fattest3 = fattest3.plus(current).sorted().subList(1, 4)
        println(fattest3)
        println(fattest3.sum())
    }

}