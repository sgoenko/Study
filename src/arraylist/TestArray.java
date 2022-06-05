package arraylist;

import java.util.ArrayList;

public class TestArray {
	public static void main(String[] args) throws InterruptedException {
		NonBlockingArrayList<Integer> arrayList = new NonBlockingArrayList<>();

		arrayList.add(12);
		arrayList.add(15);
		arrayList.add(17);

		Integer remove = arrayList.remove(3);
	}
}
