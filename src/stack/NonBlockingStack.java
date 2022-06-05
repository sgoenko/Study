package stack;

import java.util.concurrent.atomic.AtomicReference;

public class NonBlockingStack<T> {
	private final AtomicReference<Element> head = new AtomicReference<>(null);

	T peek() {
		return head.get().value;
	}

	void push(final T value) {
		final Element current = new Element();
		current.value = value;
		Element recent;
		do {
			recent = head.get();
			current.previous = recent;
		} while (!head.compareAndSet(recent, current));
	}

	T pop() {
		Element result;
		Element previous;
		do {
			result = head.get();
			if (result == null) {
				return null;
			}
			previous = result.previous;
		} while (!head.compareAndSet(result, previous));
		return result.value;
	}

	private class Element {
		private T value;
		private Element previous;
	}
}
