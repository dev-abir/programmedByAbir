package main

import (
	"fmt"
	/*"strings"*/)

func main() {

	var word string = "abcdefghij"

	//fmt.Println("Permutations : ", getPermutations(word))
    getPermutations(word)
    fmt.Println("Done")
}

func getPermutations(word string) []string {
	if len(word) == 1 {
		var x []string = make([]string, 1)
		x[0] = word
		return x
	}
	var permutations []string = make([]string, factorial(len(word)))
	var i, x int
	for i = 0; i < len(word); i++ {
		word = swap(word, i, 0)
		for _, value := range getPermutations(word[1:]) {
			permutations[x] = string(word[0]) + value
			x = x + 1
		}
	}
	return permutations
}

func swap(str string, currentIndex int, destinationIndex int) string {
	x := []rune(str)
	temp := x[currentIndex]
	x[currentIndex] = x[destinationIndex]
	x[destinationIndex] = temp
	return string(x)
	//return strings.Replace(str, string(str[currentIndex]), string(str[destinationIndex]), 1)
}

func factorial(n int) int {
	if (n == 1) || (n == 0) {
		return 1
	} else {
		return n * factorial(n-1)
	}
}
