package map;

import java.util.Map;
import java.util.Set;

public class TestLRUCache {
	public static void main(String[] args) {
		LRUCache<Integer, String> cache = new LRUCache<>(10);

		for (int i = 0; i< 15; i++) {
			cache.put(i, "" + i);
		}
		Set<Map.Entry<Integer, String>> entries = cache.entrySet();
		Object[] objects = entries.toArray();


	}
}
