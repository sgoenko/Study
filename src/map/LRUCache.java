package map;

import java.util.LinkedHashMap;
import java.util.Map;

public class LRUCache<K, V> extends LinkedHashMap<K, V> {
	private static final int MAX_ENTRIES = 10;

	public LRUCache(int initialCapacity) {
		super(initialCapacity, 0.85f, true);
	}

	@Override
	protected boolean removeEldestEntry(Map.Entry<K, V> eldest) {
		return size() > MAX_ENTRIES;
	}
}
