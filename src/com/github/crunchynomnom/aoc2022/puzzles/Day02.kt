package com.github.crunchynomnom.aoc2022.puzzles

import Puzzle
import kotlin.streams.toList

class Day02 : Puzzle() {

    override fun part1(input: List<String>) {
        println(input)
        var tot = 0
        for(round in input) {
            val opp = round[0].minus('@')   // maps A->1 B->2 C->3
            val me = round[2].minus('W')    // maps X->1 Y->2 Z->3
            val a = (me - opp + 4) % 3
            val b = a*3 + me

            println("$opp $me  $a $b")
            tot += b
        }
        println(tot)
    }

    override fun part2(input: List<String>) {
        TODO("Not yet implemented")
    }

}
