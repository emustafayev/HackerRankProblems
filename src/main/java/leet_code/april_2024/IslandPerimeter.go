package main

func main() {

}

func islandPerimeter(grid [][]int) int {

	perimeter := 0

	for i := 0; i < len(grid); i++ {
		for j := 0; j < len(grid[0]); j++ {

			if grid[i][j] == 1 {
				perimeter += 4
				if i > 0 && grid[i-1][j] == 1 {
					perimeter -= 2
				}
				if j > 0 && grid[i][j-1] == 1 {
					perimeter -= 2
				}
			}

		}
	}

	return perimeter
}

func islandPerimeter2(grid [][]int) int {
	perimeter := 0

	return perimeter
}
