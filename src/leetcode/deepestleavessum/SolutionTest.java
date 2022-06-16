package leetcode.deepestleavessum;

import org.junit.Test;

import static org.junit.jupiter.api.Assertions.*;

public class SolutionTest {

	Solution solution = new Solution();

	@Test
	public void deepestLeavesSumTest() {
		TreeNode root = new TreeNode(1);

		TreeNode left = new TreeNode(2);
		left.left = new TreeNode(4);
		left.right = new TreeNode(5);
		root.left = left;

		TreeNode right = new TreeNode(3);
		right.right = new TreeNode(6);
		root.right = right;

		assertEquals(15, solution.deepestLeavesSum(root));
	}

}