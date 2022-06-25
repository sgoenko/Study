package palindrome;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class SolutionTest {
	Solution solution = new Solution();

	@Test
	public void lomgestPalindromeTest() {
		String input = "asdffds";
		assertEquals("sdffds", solution.lomgestPalindrome(input));
	}

}