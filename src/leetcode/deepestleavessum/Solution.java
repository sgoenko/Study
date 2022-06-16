package leetcode.deepestleavessum;

import java.util.ArrayDeque;
import java.util.Deque;
import javafx.util.Pair;

public class Solution {
	public int deepestLeavesSum(TreeNode root) {
		int maxDepth = 0;
		int maxDepthSum = 0;
		int currentDepth = 0;
		Deque<Pair<TreeNode, Integer>> stack = new ArrayDeque<>();

		stack.push(new Pair<>(root, 0));

		while(!stack.isEmpty()) {
			Pair<TreeNode, Integer> p = stack.pop();
			root = p.getKey();
			currentDepth = p.getValue();

			if (root.left != null || root.right != null) {
				if (root.right != null) {
					stack.push(new Pair(root.right, currentDepth + 1));
				}

				if (root.left != null) {
					stack.push(new Pair(root.left, currentDepth +1 ));
				}
			} else {
				if (maxDepth < currentDepth) {
					maxDepthSum = root.val;
					maxDepth = currentDepth;
				} else if (maxDepth == currentDepth) {
					maxDepthSum += root.val;
				}

			}

		}

		return maxDepthSum;
	}
}
