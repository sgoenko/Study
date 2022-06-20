package leetcode.jewelsstones;

import java.util.HashSet;
import java.util.Set;

public class Solution {
	public int numJewelsInStones(String jewels, String stones) {
		int number = 0;

		Set<Character> chars = new HashSet<>();
		for (Character c: jewels.toCharArray()) {
			chars.add(c);
		}

		for (Character c: stones.toCharArray()) {
			if (chars.contains(c)) {
				number++;
			}
		}

		return number;
	}
}
