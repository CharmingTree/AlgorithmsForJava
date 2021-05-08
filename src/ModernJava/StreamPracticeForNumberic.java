package ModernJava;

import java.util.Optional;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class StreamPracticeForNumberic {

	public static void main(String[] args) {
		
		// 피타고라스 
		Stream<int[]>  pythagoreanTriples = IntStream.rangeClosed(1, 100).boxed()
					.flatMap(a -> IntStream.rangeClosed(a, 100)
							.filter(b -> Math.sqrt(a*a + b*b) % 1 == 0)
							.mapToObj(b->
							new int[] {a,b,(int)Math.sqrt(a*a + b*b)})
					);
		
		pythagoreanTriples.forEach(t -> {
			
			for (int a : t) {
				System.out.print(a+", ");
			}
			System.out.println();
		});
		
		
		Optional<String> values = Optional.ofNullable(System.getProperty("java.runtime.version"));
		
		System.out.println(values);
		
	
	}
	

}
