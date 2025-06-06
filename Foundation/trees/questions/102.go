package main

func levelOrder(root *TreeNode) [][]int {
	result := make([][]int, 0)
	queue := []*TreeNode{root}

	if root == nil {
		return result
	}
	for len(queue) > 0 {
		levelSize := len(queue)
		levelVals := make([]int, 0, levelSize)
		for i := 0; i < levelSize; i++ {
			node := queue[0]
			queue = queue[1:]

			levelVals = append(levelVals, node.Val)

			if node.Left != nil {
				queue = append(queue, node.Left)
			}
			if node.Right != nil {
				queue = append(queue, node.Right)
			}
		}
		result = append(result, levelVals)
	}
	return result
}
