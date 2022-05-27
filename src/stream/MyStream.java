package stream;

import java.util.Collection;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class MyStream<T> {

	private final GenerationFunction<T> generationFunction;
	private boolean isTerminated = false;

	private MyStream(GenerationFunction<T> generationFunction) {
		this.generationFunction = generationFunction;
	}

	public void forEach(Consumer<T> consumer) {
		isTerminated = true;
		generationFunction.generate(consumer);
	}

	public MyStream<T> union(Collection<T> collection) {
		return new MyStream<>(consumer -> {
			generationFunction.generate(consumer);
			collection.forEach(consumer);
		});
	}

	public MyStream<T> filter(Predicate<T> predicate) {
		return new MyStream<>(consumer -> generationFunction.generate(value -> {
			if (predicate.test(value)) {
				consumer.accept(value);
			}
		}));
	}

	public <R> MyStream<R> map(Function<T, R> function) {
		return new MyStream<>(generationContextFunction -> generationFunction.generate(
				value -> generationContextFunction.accept(function.apply(value))
		));
	}

	public static <T> MyStream<T> of(Collection<T> collection) {
		return new MyStream<>(collection::forEach);
	}
}