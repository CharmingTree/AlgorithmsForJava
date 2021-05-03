package ModernJava;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Function;

public class FunctionEx {
	
	/*
	 * 제네릭 형식 T를 인수로 받아서 제네릭 형식 R 객체를 반환하는 추상 메서드 apply를 정의 한다. 
	 * */
	
	public static <T, R> List<R> map(List<T> list, Function<T, R> f) {
		List<R> result = new ArrayList<>();
		for (T t : list) {
			result.add(f.apply(t));
		}
		return result;
	}

	public static void main(String[] args) {
		List<Integer> l = map(Arrays.asList("lamda", "in", "action"), (String s) -> s.length());
		
		System.out.println(l);
	}

}
