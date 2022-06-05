package stack;

import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class LockStack <T> {
	private final ReadWriteLock lock = new ReentrantReadWriteLock();
	private Node<T> head = null;

	LockStack<T> push(T value) {
		lock.writeLock().lock();
		try {
			head = new Node<>(value, head);
		} finally {
			lock.writeLock().unlock();
		}
		return this;
	}

	T pop() {
		lock.readLock().lock();
		try {
			Node<T> current = head;
			if (current != null) {
				head = head.next;
				return current.value;
			}
			return null;
		} finally {
			lock.readLock().unlock();
		}
	}

	private static class Node<E> {
		private final E value;
		private final Node<E> next;

		private Node(E value, Node<E> next) {
			this.value = value;
			this.next = next;
		}
	}
}