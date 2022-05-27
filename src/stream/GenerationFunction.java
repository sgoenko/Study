package stream;

public interface GenerationFunction<T> {
	void generate(GenerationContextFunction<T> generationContextFunction);
}
