package ModernJava;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

interface ApplePredicate {
	public boolean test(Apple apple);
}

interface Predicate<T> {
	boolean test(T t);
}

class AppleHeavyWeightPredicate implements ApplePredicate {
	public boolean test(Apple apple) {
		return apple.getWeight() > 150;
	}
}

class AppleGreenColorPredicate implements ApplePredicate {
	public boolean test(Apple apple) {
		return Apple.Color.GREEEN.equals(apple.getColor());
	}
}

public class behaviorPrameterization {
	
	public static List<Apple> filterApples(List<Apple> inventory, ApplePredicate p) {
		List<Apple> result = new ArrayList<>();
		for (Apple apple : inventory) {
			if (p.test(apple))
				result.add(apple);
		}
		return result;
	}
	
	public static <T> List<T> filter(List<T> list, Predicate<T> p) {
		List<T> result = new ArrayList<>();
		for (T e : list) {
			if (p.test(e)) {
				result.add(e);
			}
		}
		
		return result;
	} 
	
	// 람다 표현식은 구현 클래스가 하나만 존재 해야 한다. 
	// 즉, 함수형 인터페이스라고 하며, 오직 하나의 추상 메소드만 지정 한다.
	interface LamdaTest {
		public void test(String msg);
	}
	
	interface LamdaTest2 {
		public void test(String a, String b);
	}
	
	public static void lamdaTestFunc(LamdaTest t) {
		t.test("hello");
	}
	
	public static void lamdaTestFunc2(LamdaTest2 t) {
		t.test("hello", "lamda");
	}

	public static void main(String[] args) {
		List<Apple> inventory = Arrays.asList(new Apple("a", 80, Apple.Color.GREEEN),
											  new Apple("b", 155, Apple.Color.GREEEN),
											  new Apple("b", 155, Apple.Color.BLUE),
											  new Apple("c", 120, Apple.Color.RED));
		
		
		
		List<Apple> heavyApples = filterApples(inventory, new AppleHeavyWeightPredicate());
		System.out.println(heavyApples);
		
		List<Apple> greenApples = filterApples(inventory, new AppleGreenColorPredicate());
		System.out.println(greenApples);
		
		
		// * filterApples 메소드로 새로운 동작을 전달하려면 ApplePredicate 인터페이스를 구현하는 여러 클래스를 정의하고 인스턴스화 해야하는 번잡함을 가지고 있다. 
		// 익명 클래스 사용 
		List<Apple> redApples = filterApples(inventory, new ApplePredicate() {
			public boolean test(Apple apple) {
				return Apple.Color.RED.equals(apple.getColor());
			}
		});
		System.out.println(redApples);
		
		// 익명 클래스도 쓸데없는 껍데기가 너무 많다 .
		// 람다 표현식 사용
		List<Apple> result = filterApples(inventory, (Apple apple) -> Apple.Color.RED.equals(apple.getColor()));
		System.out.println(result);
		
		// 리스트형식으로 추상화 유연성과 간결화를 동시에
		List<Apple> result2 = filter(inventory,  apple -> Apple.Color.BLUE.equals(apple.getColor()));
		System.out.println(result2);
		
		// java.util.Comparator
		
		inventory.sort((a1, a2)->a1.getWeight().compareTo(a2.getWeight()));
		System.out.println(inventory);
		
		lamdaTestFunc((a)->{System.out.println(a);});
		lamdaTestFunc((a)->System.out.println(a));
		lamdaTestFunc(a->{System.out.println(a);});
		lamdaTestFunc2((a,b)->{});
		
	}

}
