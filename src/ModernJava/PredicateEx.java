package ModernJava;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

public class PredicateEx {
	
	public static <T> List<T> filter(List<T> lst, Predicate<T> p) {
		List<T> results = new ArrayList<>();
		for (T t : lst) {
			if(p.test(t))
			{
				results.add(t);
			}
		}
		return results;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<String> myList = Arrays.asList(new String[] {"aa", "bb", "cc", ""});
		
		// predicate를 따로 변수로 지정하여 사용도 가능 
		Predicate<String> nonEmptyStringPredicated = (String s) -> !s.isEmpty();
		List<String> nonEmptyStringList = filter(myList, nonEmptyStringPredicated);
		
		System.out.println(nonEmptyStringList);
	}

}

