package main

import (
	"fmt"
)

// 数组长度必须是常量，且是类型的组成部分。

// 给你一个整数数组 nums ，请你找出一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。
// 子数组 是数组中的一个连续部分。
/**
  动态规划
*/
func maxSubArray2(nums []int) int {
	var dp = make([]int, len(nums))
	dp[0] = nums[0]
	max := nums[0]
	for i := range nums {
		if i == 0 {
			continue
		}
		if dp[i-1] < 0 {
			dp[i] = nums[i]
		} else {
			dp[i] = dp[i-1] + nums[i]
		}
		if dp[i] > max {
			max = dp[i]
		}
	}
	return max
}

/**
  超时，前缀和
*/
func maxSubArray(nums []int) int {
	if len(nums) == 1 {
		return nums[0]
	}
	max := nums[0]
	var arr []int
	arr = append(arr, 0)
	// 前缀和
	for i := 1; i <= len(nums); i++ {
		arr = append(arr, arr[i-1]+nums[i-1])
	}
	for i := range arr {
		for j := i; j < len(arr)-1; j++ {
			tmp := arr[j+1] - arr[i]
			if tmp > max {
				max = tmp
			}
		}
	}
	return max
}

func main() {
	fmt.Println(maxSubArray([]int{-2, 1, -3, 4, -1, 2, 1, -5, 4}))
	fmt.Println(maxSubArray2([]int{-2, 1, -3, 4, -1, 2, 1, -5, 4}))
	fmt.Println(maxSubArray2([]int{5, 4, -1, 7, 8}))
}
