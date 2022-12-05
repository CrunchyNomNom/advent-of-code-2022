package com.github.crunchynomnom.aoc2022.puzzles

import Puzzle
import java.io.File

class Day04 : Puzzle() {
    override fun part1(input: File) {
        println(input
            .readLines()
            .map { it.split(",", "-") }
            .map { it.map { x -> x.toInt() } }
            .count { (l1, r1, l2, r2) ->
                ((l1..r1).contains(l2) and (l1..r1).contains(r2)) or ((l2..r2).contains(l1) and (l2..r2).contains(r1))}
        )
    }

    override fun part2(input: File) {
        println(input
            .readLines()
            .map { it.split(",", "-") }
            .map { it.map { x -> x.toInt() } }
            .count { (l1, r1, l2, r2) ->
                (l1..r1).any { (l2..r2).contains(it) } }
        )
    }

}

