package leetcode.deepestleavessum;

import org.junit.Test;

import static org.junit.jupiter.api.Assertions.*;

public class SolutionTest {

	Solution solution = new Solution();

	@Test
	public void deepestLeavesSumTest() {
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.right = new TreeNode(3);

		assertEquals(5, solution.deepestLeavesSum(root));
	}

}