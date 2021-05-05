package ModernJava;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import static java.util.stream.Collectors.*;

public class FlatMapOfStreamEx {

	public static void main(String[] args) {
		
		// 1번째 시도 
		List<String> lst = Arrays.asList("Hello", "World");
		List<String[]> result_1 = lst.stream().map(word -> word.split("")).distinct().collect(toList());
		// 반환 값이 List<String>이 아니라 List<String[]> 이다 
		for (String s : result_1.get(0)) {
			System.out.println(s);
		}
		
		// 2번쨰 시도
		String[] arrayOfWords = {"Goodbye", "World"};
		Stream<String> streamOfWords = Arrays.stream(arrayOfWords);
		// List<Stream<String>>이 만들어진다 의도한 결과 아님 
		List<Stream<String>> result_2 = streamOfWords.map(word->word.split("")).map(Arrays::stream).distinct().collect(toList());
		System.out.println(result_2);
		
		// 3번째 시도 
		List<String> uniqueCharacters = lst.stream().map(word->word.split("")).flatMap(Arrays::stream).distinct().collect(toList());
		System.out.println(uniqueCharacters);
		// 모든 스트림을 하나의 스트림으로 연결 했다. 
		
		// Mapping Quiz #1
		// 숫자 리스트를 받아 제곱근 리스트로 반환 
		List<Integer> numbers = Arrays.asList(1,2,3,4,5);
		//List<Integer> squares = numbers.stream().map(n->(int)Math.pow(n, 2)).collect(toList());
		List<Integer> squares = numbers.stream().map(n->n*n).collect(toList());
		System.out.println(squares);
		
		// Mapping Quiz #2
		//[1,2,3],[3,4] -> [(1,3), (1,4), (2,3), (2,4), (3,3), (3,4)]
		List<Integer> numbers1 = Arrays.asList(1,2,3);
		List<Integer> numbers2 = Arrays.asList(3,4);
		
		List<int[]> resultMap = numbers1.stream().flatMap(i -> numbers2.stream()
				.map(j -> new int[]{i,j})
				).collect(toList());
		// 내부 반복에서 상위 반복자는 i 그 밑에 반복은 j 
		// e.g) for ( i in numbers1 ) {
		// 			for ( j in numbers2 ) { ... }
		// 		}
		
		
	}

}
