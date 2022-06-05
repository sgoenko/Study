package threadlocal;

public class TestThread {

	public static void main(String args[]) {
		RunnableDemo commonInstance = new RunnableDemo();

		commonInstance.threadLocalCounter.set(5);

		Thread t1 = new Thread(commonInstance);
		Thread t2 = new Thread(commonInstance);
		Thread t3 = new Thread(commonInstance);
		Thread t4 = new Thread(commonInstance);

		t1.start();
		t2.start();
		t3.start();
		t4.start();

		// wait for threads to end
		try {
			t1.join();
			t2.join();
			t3.join();
			t4.join();
		} catch (Exception e) {
			System.out.println("Interrupted");
		}
	}
}
