package com.github.crunchynomnom.aoc2022.puzzles

import Puzzle
import java.io.File

class Day06 : Puzzle() {
    override fun part1(input: File) {
        println(input.readLines())
        for (line in input.readLines()) {
            var last3 = line.take(3).toMutableList()
            for (i in 3 until line.length) {
                last3.add(line[i])
                if (last3.size == last3.distinct().size) {
                    println(i+1)
                    break
                }
                last3.removeFirst()
            }
        }
    }

    override fun part2(input: File) {
        println(input.readLines())
        for (line in input.readLines()) {
            var last13 = line.take(13).toMutableList()
            for (i in 13 until line.length) {
                last13.add(line[i])
                if (last13.size == last13.distinct().size) {
                    println(i+1)
                    break
                }
                last13.removeFirst()
            }
        }
    }

}

