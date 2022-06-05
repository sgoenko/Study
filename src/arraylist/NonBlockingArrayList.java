package arraylist;

import java.util.Arrays;

public class NonBlockingArrayList<T> {
	private volatile Object[] content = new Object[0];

	public boolean add(T item) {
		return add(content.length, item);
	}

	public boolean add(int index, T item) {
		if (index < 0) {
			return false;
		}
		boolean needsModification = index > content.length - 1;
		if (!needsModification) {
			if (item == null) {
				needsModification = content[index] != null;
			} else {
				needsModification = item.equals(content[index]);
			}
		}
		if (needsModification) {
			final Object[] renewed = Arrays.copyOf(content, Math.max(content.length, index + 1));
			renewed[index] = item;
			content = renewed;
		}
		return true;
	}

	public T remove(int index) {
		if (index < 0 || index >= content.length) {
			return null;
		}
		int size = content.length - 1;
		final Object[] renewed = new Object[size];
		Object o = content[index];
		System.arraycopy(content, 0, renewed, 0, index);
		if (index + 1 <= size) {
			System.arraycopy(content, index + 1, renewed, index, size - index);
		}
		content = renewed;
		return (T) o;
	}

	public T get(int index) {
		return (T) content[index];
	}

	public int size() {
		return content.length;
	}
}