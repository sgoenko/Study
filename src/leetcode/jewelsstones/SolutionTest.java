package leetcode.jewelsstones;

import leetcode.jewelsstones.Solution;

import org.junit.Test;

import static org.junit.jupiter.api.Assertions.*;

public class SolutionTest {
	Solution solution = new Solution();

	@Test
	public void nunJewelsInStonesTest() {
		String jewels = "aA";
		String stones = "aAAbbbb";

		assertEquals(3, solution.numJewelsInStones(jewels, stones));
	}


}