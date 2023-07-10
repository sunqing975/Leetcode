package main

import "fmt"

func merge(intervals [][]int) [][]int {
	l := len(intervals)
	if l == 1 {
		return intervals
	}
	var res [][]int
	count := 0
	for i := 1; i < l; i++ {
		if intervals[i-1][1] >= intervals[i][0] {
			tmp := []int{intervals[i-1][0], intervals[i-1][1], intervals[i][0], intervals[i][1]}
			minInt := intervals[i-1][0]
			maxInt := intervals[i-1][0]
			for j := range tmp {
				if tmp[j] > maxInt {
					maxInt = tmp[j]
				}
				if tmp[j] < minInt {
					minInt = tmp[j]
				}
			}
			//res[count] = tmp
			res = append(res, []int{minInt, maxInt})
		} else {
			//res[count] = intervals[i]
			if i == 1 {
				res = append(res, intervals[i-1])
			}
			res = append(res, intervals[i])

		}
		count++
	}
	return res
}

func main() {
	fmt.Println(merge([][]int{{1, 3}, {2, 6}, {8, 10}, {15, 18}}))
	fmt.Println(merge([][]int{{1, 4}, {4, 5}}))
	fmt.Println(merge([][]int{{1, 4}, {5, 6}}))
}
