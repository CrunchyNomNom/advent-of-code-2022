package com.github.crunchynomnom.aoc2022.puzzles

import Puzzle
import java.io.File

class Day05 : Puzzle() {
    private var stacks = mutableMapOf<Int,MutableList<Char>>()
    private var steps = mutableListOf<List<Int>>()

    override fun part1(input: File) {
        parse(input)
        for (step in steps) {
            for (i in 1..step[0]) {
                stacks[step[2]]!!.add(stacks[step[1]]!!.last())
                stacks[step[1]]!!.removeLast()
            }
        }
    }

    override fun part2(input: File) {
        parse(input)
        for (step in steps) {
            for (i in stacks[step[1]]!!.takeLast(step[0])) {
                stacks[step[2]]!!.add(i)
            }
            stacks[step[1]] = stacks[step[1]]!!.subList(0, stacks[step[1]]!!.size-step[0])
        }
        for (i in 1..stacks.size)
            print("${stacks[i]!!.last()}")
    }

    private fun parse(input: File) =
        input.readLines().forEach { line ->
            when {
                line.startsWith('m') -> {
                    steps.add(Regex("move ([0-9]+) from ([0-9]+) to ([0-9]+)")
                        .find(line)?.groupValues?.takeLast(3)!!
                        .map { x -> x.toInt() })
                }
                line.contains('[') -> {
                    for (i in 1..line.length step 4) {
                        stacks.putIfAbsent(i/4+1, mutableListOf())
                        if (line[i] != ' ')
                            stacks[i/4+1]!!.add(0, line[i])
                    }
                }
            }
        }
}