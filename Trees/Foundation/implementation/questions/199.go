package main

func rightSideView(root *TreeNode) []int {
	result := make([]int, 0)

	if root == nil {
		return []int{}
	}
	queue := []*TreeNode{root}
	for len(queue) > 0 {
		levelSize := len(queue)
		for i := 0; i < levelSize; i++ {

			node := queue[0]
			queue = queue[1:]

			if i == levelSize-1 {
				result = append(result, node.Val)
			}
			if node.Left != nil {
				queue = append(queue, node.Left)
			}
			if node.Right != nil {
				queue = append(queue, node.Right)
			}
		}
	}
	return result
}
