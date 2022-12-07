package com.github.crunchynomnom.aoc2022.puzzles

import Puzzle
import java.io.File


class Day07 : Puzzle() {
    var dirHeap: MutableList<Dir> = mutableListOf()

    override fun part1(input: File) {
        var result = 0
        for (line in input.readLines()) {
            when {
                line.endsWith('.') -> {
                    val tmp = dirHeap.removeLast()
                    result += tmp.getAdjustedSize()
                    dirHeap.last().dirs.add(tmp)
                }
                line.startsWith("$ cd") -> dirHeap.add(Dir())
                line.contains(Regex("[0-9]+")) -> dirHeap.last().files.add(line.split(" "))
            }
        }
        while (dirHeap.size > 1) {
            val tmp = dirHeap.removeLast()
            result += tmp.getAdjustedSize()
            dirHeap.last().dirs.add(tmp)
        }
        result += dirHeap.last().getAdjustedSize()
        println(result)
    }

    override fun part2(input: File) {
        part1(input) // loads the directory
        val req = dirHeap.last().getTotalSize() + 30000000 - 70000000
        println(dirHeap.last().getBestSize(req))
    }

}

data class Dir(
    val dirs: MutableList<Dir> = mutableListOf(),
    val files: MutableList<List<String>> = mutableListOf(),
    var size: Int? = null
) {
    fun getAdjustedSize(limit: Int = 100000): Int {
        val result = getTotalSize()
        return (if(result <= limit) result else 0)
    }

    fun getBestSize(req: Int): Int {
        if (dirs.isEmpty()) return getTotalSize()
        var best = Int.MAX_VALUE
        for (dir in dirs) {
            val subbest = dir.getBestSize(req)
            if (subbest > req && subbest - req < best - req)
                best = subbest
        }
        return (if (getTotalSize() > req && getTotalSize() - req < best - req) getTotalSize() else best)
    }

    fun getTotalSize(): Int {
        if (size == null) {
            size = dirs.sumOf { x -> x.getTotalSize() } +
                files.sumOf { x -> x.first().toInt() }
        }
        return (size as Int)
    }
}