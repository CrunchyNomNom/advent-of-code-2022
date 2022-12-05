package com.github.crunchynomnom.aoc2022.puzzles

import Puzzle
import java.io.File

class Day02 : Puzzle() {

    override fun part1(input: File) {
        var tot = 0
        for(round in input.readLines()) {
            val opp = round[0].minus('@')   // maps A->1 B->2 C->3
            val me = round[2].minus('W')    // maps X->1 Y->2 Z->3
            val a = (me - opp + 4) % 3
            val b = a*3 + me

            tot += b
        }
        println(tot)
    }

    override fun part2(input: File) {
        var tot = 0
        for(round in input.readLines()) {
            val opp = round[0].minus('@')   // maps A->1 B->2 C->3
            val guide = round[2].minus('Y')    // maps X->-1 Y->0 Z->1
            val me = (opp + guide + 2) % 3 + 1
            val b = (guide + 1) * 3 + me

            tot += b
        }
        println(tot)
    }
}
