#!/bin/zsh

if [ -z "$1" ]; then
    echo "provide day as an arg (e.g. 07)"
fi

echo "package com.github.crunchynomnom.aoc2022.puzzles

import Puzzle

class Day${1} : Puzzle() {
    override fun part1(input: List<String>) {
        TODO(\"Not yet implemented\")
    }

    override fun part2(input: List<String>) {
        TODO(\"Not yet implemented\")
    }

}
" >> ./src/com/github/crunchynomnom/aoc2022/puzzles/"Day${1}".kt

mkdir -p ./input/"${1}"
touch ./input/"${1}"/example.txt
touch ./input/"${1}"/puzzle.txt
