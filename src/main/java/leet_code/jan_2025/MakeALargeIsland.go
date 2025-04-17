package main

import "fmt"

func main() {
	//fmt.Println(largestIsland([][]int{{1, 0}, {0, 1}}))
	//fmt.Println(largestIsland([][]int{{1, 1}, {1, 1}}))
	//fmt.Println(largestIsland([][]int{{1, 1, 0, 1}, {1, 0, 0, 1}, {0, 1, 1, 1}, {1, 0, 1, 0}}))
	fmt.Println(largestIsland([][]int{
		{0, 0, 0, 0, 0, 0, 0},
		{0, 1, 1, 1, 1, 0, 0},
		{0, 1, 0, 0, 1, 0, 0},
		{1, 0, 1, 0, 1, 0, 0},
		{0, 1, 0, 0, 1, 0, 0},
		{0, 1, 0, 0, 1, 0, 0},
		{0, 1, 1, 1, 1, 0, 0}}))
}

func largestIsland(grid [][]int) int {
	maxIsland := 0
	islandId := 2
	islandCountMap := make(map[int]int)
	printGrid(grid)

	// 1. Mark all islands with unique id
	for i := 0; i < len(grid); i++ {
		for j := 0; j < len(grid[i]); j++ {
			if grid[i][j] == 1 {
				islandCountMap[islandId] = exploreIsland(grid, i, j, islandId)
				islandId++
			}
		}
	}
	if len(islandCountMap) == 0 {
		return 1
	}

	if len(islandCountMap) == 1 {
		islandId--
		if islandCountMap[islandId] == len(grid)*len(grid[0]) {
			return islandCountMap[islandId]
		} else {
			return islandCountMap[islandId] + 1
		}
	}

	fmt.Println(islandCountMap)
	printGrid(grid)

	// 2. Check if we can make a large island by changing 0 to 1

	for i := 0; i < len(grid); i++ {
		for j := 0; j < len(grid[0]); j++ {
			combinedIslandSize := 1
			islandIdList := make(map[int]bool)

			if grid[i][j] == 0 {

				if i-1 >= 0 && grid[i-1][j] > 1 {
					islandIdList[grid[i-1][j]] = true
				}

				if i+1 < len(grid) && grid[i+1][j] > 1 {
					islandIdList[grid[i+1][j]] = true
				}

				if j-1 >= 0 && grid[i][j-1] > 1 {
					islandIdList[grid[i][j-1]] = true
				}

				if j+1 < len(grid[0]) && grid[i][j+1] > 1 {
					islandIdList[grid[i][j+1]] = true
				}

				fmt.Println("IslandIdList: ", islandIdList)

				for key := range islandIdList {
					fmt.Println(islandCountMap[key])
					combinedIslandSize += islandCountMap[key]
				}

				maxIsland = max(maxIsland, combinedIslandSize)
			}
		}
	}

	return maxIsland

}

func printGrid(grid [][]int) {
	for i := 0; i < len(grid); i++ {
		for j := 0; j < len(grid[i]); j++ {
			fmt.Print(grid[i][j], " ")
		}
		fmt.Println()
	}
}

func exploreIsland(grid [][]int, row, col, islandId int) int {

	if row < 0 || row >= len(grid) || col < 0 || col >= len(grid[0]) || grid[row][col] != 1 {
		return 0
	}

	grid[row][col] = islandId

	return 1 +
		exploreIsland(grid, row+1, col, islandId) +
		exploreIsland(grid, row-1, col, islandId) +
		exploreIsland(grid, row, col+1, islandId) +
		exploreIsland(grid, row, col-1, islandId)
}
