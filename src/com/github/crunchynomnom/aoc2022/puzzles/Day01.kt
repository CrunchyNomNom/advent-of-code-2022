package com.github.crunchynomnom.aoc2022.puzzles

import Puzzle
import java.io.File

class Day01 : Puzzle() {

    override fun part1(input: File) {
        var fattest = 0
        var current = 0
        for (x in input.readLines()) {
            if (x == "") {
                if (fattest < current) fattest = current
                current = 0
            } else current += x.trim().toInt()
        }
        if (fattest < current) fattest = current
        println(fattest)
        println()
    }

    override fun part2(input: File) {
        println("part2")
        var fattest3 = listOf(0, 0, 0)
        var current = 0
        for (x in input.readLines()) {
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