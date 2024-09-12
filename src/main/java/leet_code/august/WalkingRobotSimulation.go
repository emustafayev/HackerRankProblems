package main

import "fmt"

func main() {

	fmt.Println(robotSim([]int{4, -1, 3}, [][]int{}))
	fmt.Println(robotSim([]int{4, -1, 4, -2, 4}, [][]int{{2, 4}}))
	fmt.Print(robotSim([]int{6, -1, -1, 6}, [][]int{}))
}

func robotSim(commands []int, obstacles [][]int) int {
	var directions = [][2]int{{0, 1}, {1, 0}, {0, -1}, {-1, 0}}

	directionIndex := 0

	X, Y := 0, 0

	obstacleMap := make(map[string]struct{})

	for _, obstacle := range obstacles {
		obstacleMap[fmt.Sprintf("%v,%v", obstacle[0], obstacle[1])] = struct{}{}
	}
	maxEucladian := 0

	for i := 0; i < len(commands); i++ {

		command := commands[i]

		switch command {
		case -2:
			directionIndex = (directionIndex + 3) % 4

		case -1:
			directionIndex = (directionIndex + 1) % 4
		default:

			for step := 0; step < command; step++ {

				newX, newY := X+directions[directionIndex][0], Y+directions[directionIndex][1]

				if _, exists := obstacleMap[fmt.Sprintf("%v,%v", newX, newY)]; exists {
					break
				}

				X = newX
				Y = newY

				maxEucladian = max(X*X+Y*Y, maxEucladian)

			}

		}

	}

	return maxEucladian

}

func max(a, b int) int {
	if a > b {
		return a
	}
	return b
}

func robotSim2(commands []int, obstacles [][]int) int {
	dirs := [...]struct {
		dx, dy int
	}{
		{dx: 0, dy: 1},  // north
		{dx: 1, dy: 0},  // east
		{dx: 0, dy: -1}, // south
		{dx: -1, dy: 0}, // west
	}

	blocked := map[[2]int]bool{}
	for _, o := range obstacles {
		k := [2]int{o[0], o[1]}
		blocked[k] = true
	}

	r := struct{ x, y, dir int }{}
	var ans int
	for _, cmd := range commands {
		if cmd == -1 {
			// turn right
			nd := r.dir + 1
			if nd >= len(dirs) {
				nd = 0
			}

			r.dir = nd
			continue
		}

		if cmd == -2 {
			// turn left
			nd := r.dir - 1
			if nd < 0 {
				nd = len(dirs) - 1
			}

			r.dir = nd
			continue
		}

		// movement
		dir := dirs[r.dir]
		for i := 1; i <= cmd; i++ {
			nx := r.x + dir.dx
			ny := r.y + dir.dy

			if blocked[[2]int{nx, ny}] {
				break
			}

			r.x = nx
			r.y = ny
		}

		ans = max(ans, (r.x*r.x)+(r.y*r.y))
	}

	return ans
}
