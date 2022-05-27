package stream;

import java.util.Collection;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class MyStream<T> {

	private final GenerationFunction<T> generationFunction;

	private MyStream(GenerationFunction<T> generator) {
		this.generationFunction = generator;
	}

	public void forEach(Consumer<T> consumer) {
		generationFunction.generate(consumer::accept);
	}

	public MyStream<T> union(Collection<T> collection) {
		return new MyStream<>(generatorContext -> {
			generationFunction.generate(generatorContext);
			collection.forEach(generatorContext::emit);
		});
	}

	public MyStream<T> filter(Predicate<T> predicate) {
		return new MyStream<>(generatorContext -> generationFunction.generate(value -> {
			if (predicate.test(value)) {
				generatorContext.emit(value);
			}
		}));
	}

	public <R> MyStream<R> map(Function<T, R> function) {
		return new MyStream<>(generatorContext -> generationFunction.generate(
				value -> generatorContext.emit(function.apply(value))
		));
	}

	public static <T> MyStream<T> of(Collection<T> collection) {
		return new MyStream<>(generatorContext ->
				collection.forEach(generatorContext::emit)
		);
	}
}