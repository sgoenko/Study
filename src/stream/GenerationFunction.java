package stream;

import java.util.function.Consumer;

public interface GenerationFunction<T> {
	void generate(Consumer<T> consumer);
}
