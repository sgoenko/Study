package stack;

public class TestStack {
	public static void main(String[] args) throws InterruptedException {
		NonBlockingStack<Integer> nonBlockingStack = new NonBlockingStack<>();

		Thread threadA = new Thread( () -> {
			for (int i = 1; i <= 10; i++) {
				nonBlockingStack.push(i);
			}
		});

		Thread threadB = new Thread( () -> {
			for (int i = 11; i <= 20; i++) {
				nonBlockingStack.push(i);
			}
		});

		threadA.start();
		threadB.start();

//		threadA.join();
		threadB.join();

		Integer pop;
		while ((pop = nonBlockingStack.pop()) != null) {
			System.out.println(pop);
		}
	}

}
