package stream;

import java.util.Arrays;

public class Runner {
	public static void main(String[] args) {
		MyStream.of(Arrays.asList("foo", "bar")).forEach(System.out::println);

		MyStream.of(Arrays.asList("шла", "саша", "по", "шоссе"))
				.union(Arrays.asList("и", "сосала", "сушку"))
				.filter(s -> s.length() > 4)
				.map(s -> s + ", length=" + s.length())
				.forEach(System.out::println);
	}
}
