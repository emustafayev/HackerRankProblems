package main

import "fmt"

func main() {
	//fmt.Println(asteroidCollision([]int{5, 10, -5}))
	fmt.Println(asteroidCollision([]int{8, -8}))
	//fmt.Println(asteroidCollision([]int{10, 2, -5}))
}

func asteroidCollision(asteroids []int) []int {
	var stack []int
	for _, asteroid := range asteroids {
		//if there is asteroid in stack, and they are going to collide
		for len(stack) > 0 && stack[len(stack)-1] > 0 && asteroid < 0 {

			lastAsteroid := stack[len(stack)-1]
			if mod(lastAsteroid) == mod(asteroid) { // Both explode
				stack = stack[:len(stack)-1]
				goto endOfLoop
			} else if mod(lastAsteroid) > mod(asteroid) { // New asteroid explode
				goto endOfLoop
			} else { //Last asteroid explode
				stack = stack[:len(stack)-1]
			}
		}
		stack = append(stack, asteroid)
	endOfLoop:
	}
	return stack
}

func mod(a int) int {
	if a > 0 {
		return a
	} else {
		return a * -1
	}
}
