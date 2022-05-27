package stream;

public interface GenerationContextFunction<T> {
	void emit(T value);
}
