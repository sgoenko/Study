package sort.merge;

import java.util.Random;

public class MergeSort {
	public static void main(String[] args) {
		Random random = new Random();
		int[] numbers = new int[10];

		for (int i = 0; i < numbers.length; i++) {
			numbers[i] = random.nextInt(10_000);
		}

		System.out.println("Before");
		printArray(numbers);

		mergeSort(numbers);

		System.out.println("\nAfter");
		printArray(numbers);
	}

	private static void mergeSort(int[] inputArray) {
		if (inputArray.length < 2) {
			return;
		}

		int halfLength = inputArray.length / 2;
		int[] leftPart = new int[halfLength];
		int[] rightPart = new int[inputArray.length - halfLength];

		System.arraycopy(inputArray, 0, leftPart, 0, halfLength);
		System.arraycopy(inputArray, halfLength, rightPart, 0, inputArray.length - halfLength);

		mergeSort(leftPart);
		mergeSort(rightPart);

		merge(inputArray, leftPart, rightPart);
	}

	private static void merge(int[] inputArray, int[] leftPart, int[] rightPart) {
		int i = 0, j = 0, k = 0;

		while (i < leftPart.length && j < rightPart.length) {
			if (leftPart[i] <= rightPart[j]) {
				inputArray[k++] = leftPart[i++];
			} else {
				inputArray[k++] = rightPart[j++];
			}
		}

		while (i < leftPart.length) {
			inputArray[k++] = leftPart[i++];
		}

		while (j < rightPart.length) {
			inputArray[k++] = rightPart[j++];
		}
	}

	private static void printArray(int[] numbers) {
		for (int number : numbers) {
			System.out.println(number);
		}
	}
}
