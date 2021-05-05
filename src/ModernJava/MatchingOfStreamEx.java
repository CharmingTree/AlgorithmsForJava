package ModernJava;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class MatchingOfStreamEx {

	public static void main(String[] args) {

		List<Dish> menu = Arrays.asList(
			new Dish("pork", false, 800, Dish.Type.MEAT),
			new Dish("beef", false, 700, Dish.Type.MEAT),
			new Dish("chicken", false, 400, Dish.Type.MEAT),
			new Dish("french fries", true, 530, Dish.Type.OTHER), 
			new Dish("rice", true, 350, Dish.Type.OTHER),
			new Dish("season fruit", true, 120, Dish.Type.OTHER), 
			new Dish("pizza", true, 550, Dish.Type.OTHER),
			new Dish("prawns", false, 300, Dish.Type.FISH),
			new Dish("salmon", false, 450, Dish.Type.FISH)
		);
		
		// 특정 속성이 데이터 집합에 존재하는지 여부를 검색하는 스트림 API는 
		// allMatch, anyMatch, noneMatch, findFirst, findAny (최종연산) 을 제공한다.
		// |------ return boolean ------] [-매칭되는 요소 반환 -|
		//								  [정확히는 Optional 객체를 반환]
		
		if (menu.stream().anyMatch(Dish::isVegetarian))
			System.out.println("exist!");
		
		Optional<Dish> dish = menu.stream().filter(Dish::isVegetarian).findAny();
		
		System.out.println(dish);
		
		// Quiz#1 map 과 reduce 메서드를 이용하여 스트림의 요리 계수를 계산하시오 
		Optional<Integer> dishSize = menu.stream().map(s->1).reduce(Integer::sum);
		
		System.out.println(dishSize);
	}

}
