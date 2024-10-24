package main

func main() {

}

func maxUniqueSplit(s string) int {

	ans := 1

	visited := make(map[string]bool)

	var dfs func(int, int)
	dfs = func(index int, counter int) {
		if len(s) <= index {
			ans = max(ans, counter)
			return
		}

		for i := index + 1; i < len(s); i++ {
			currStr := s[index:i]

			if !visited[currStr] {
				visited[currStr] = true
				dfs(i, counter+1)
				visited[currStr] = false
			}
		}

	}

	return ans
}
