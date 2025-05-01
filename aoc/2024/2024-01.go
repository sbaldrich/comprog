package main

import (
	"fmt"
	"os"
	"slices"
)

func main() {
	file, _ := os.Open(GetInputFile())
	defer file.Close()
	var left, right []int
	for {
		var l, r int
		if _, err := fmt.Fscanf(file, "%d %d", &l, &r); err != nil {
			break
		}
		left = append(left, l)
		right = append(right, r)
	}
	slices.Sort(left)
	slices.Sort(right)

	var ans int
	abs := func(n int) int {
		if n < 0 {
			return -n
		}
		return n
	}
	for i := 0; i < len(left); i++ {
		ans += abs(left[i] - right[i])
	}

	fmt.Printf("Part 1 sum: %d\n", ans)

	m := make(map[int]int)
	for _, r := range right {
		m[r]++
	}
	ans = 0
	for _, l := range left {
		ans += l * m[l]
	}

	fmt.Printf("Part 2 sum: %d\n", ans)

}
