package main

import (
	"fmt"
)

func main() {

	stack := Constructor()
	stack.Push(-2)
	stack.Push(0)
	stack.Push(-3)
	fmt.Println(stack.GetMin())
	stack.Pop()
	fmt.Println(stack.Top())
	fmt.Println(stack.GetMin())

}

type MinStack struct {
	stack []int
	min   []int
	top   int
}

func Constructor() MinStack {
	return MinStack{[]int{}, []int{}, -1}
}

func (this *MinStack) Push(val int) {

	if this.top == -1 {
		this.min = append(this.min, val)
	} else {
		this.min = append(this.min, min(this.min[this.top], val))
	}
	this.stack = append(this.stack, val)
	this.top++
}

func (this *MinStack) Pop() {
	this.stack = this.stack[:this.top]
	this.min = this.min[:this.top]
	this.top--
}

func (this *MinStack) Top() int {
	return this.stack[this.top]
}

func (this *MinStack) GetMin() int {
	return this.min[this.top]
}

/**
 * Your MinStack object will be instantiated and called as such:
 * obj := Constructor();
 * obj.Push(val);
 * obj.Pop();
 * param_3 := obj.Top();
 * param_4 := obj.GetMin();
 */
