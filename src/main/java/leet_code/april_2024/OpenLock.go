package main

import (
	"container/list"
	"slices"
	"strconv"
)

type State struct {
	lock string
	time int
}

func openLock(deadends []string, target string) int {
	// Your code here.
	if slices.Contains(deadends, target) || slices.Contains(deadends, "0000") {
		return -1
	}

	var queue = list.New()

	initial_state := State{
		"0000",
		0,
	}
	queue.PushBack(initial_state)

	var state State
	var element *list.Element
	var visited = map[string]struct{}{}

	visited[initial_state.lock] = struct{}{}
	for _, deadend := range deadends {
		visited[deadend] = struct{}{}
	}

	for queue.Len() > 0 {

		element = queue.Front()       // getting a generic element from list of type list.Element
		state = element.Value.(State) // using type assertion
		queue.Remove(element)

		if state.lock == target {
			return state.time
		}

		locks := nextLockCombination(state.lock, visited)
		for _, lock := range locks {
			visited[lock] = struct{}{}
			queue.PushBack(State{
				lock: lock,
				time: state.time + 1,
			})
		}
	}

	return -1
}

func nextLockCombination(lock string, visited map[string]struct{}) []string {

	nextLocks := []string{}

	for idx := 0; idx < len([]rune(lock)); idx++ {
		elem := lock[idx]
		// fmt.Println(elem)
		next_elem := (int(elem) - 48 + 1) % 10
		prev_elem := (int(elem) - 48 - 1)

		if prev_elem < 0 {
			prev_elem += 10
		}

		next_lock := lock[:idx] + strconv.Itoa(next_elem) + lock[idx+1:]
		prev_lock := lock[:idx] + strconv.Itoa(prev_elem) + lock[idx+1:]

		_, ok := visited[next_lock]
		if !ok {
			nextLocks = append(nextLocks, next_lock)
		}

		_, ok = visited[prev_lock]
		if !ok {
			nextLocks = append(nextLocks, prev_lock)
		}

	}

	return nextLocks

}
