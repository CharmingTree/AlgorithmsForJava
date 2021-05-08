package ModernJava;

import java.util.Arrays;
import java.util.Collection;
import java.util.Comparator;
import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import ModernJava.Domain.Dish;
import ModernJava.Domain.Trader;
import ModernJava.Domain.Transaction;

import static java.util.stream.Collectors.*;

public class StreamPracticeForGroup {

	public static void main(String[] args) {
		Trader raoul = new Trader("Raoul", "Cambridge");
		Trader mario = new Trader("Mario", "Milan");
		Trader alan = new Trader("Alan", "Cambridge");
		Trader brian = new Trader("Brian", "Cambridge");
		
		List<Transaction> transactions = Arrays.asList(
				new Transaction(brian, 2011, 300),
				new Transaction(raoul, 2012, 1000),
				new Transaction(raoul, 2011, 400),
				new Transaction(brian, 2011, 100),
				new Transaction(mario, 2012, 710),
				new Transaction(mario, 2012, 700),
				new Transaction(alan, 2012, 950)
		);
		
		
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
		
		// # 리듀싱과 요약
		
		// 1-1. 요리수 구하기
		long howManyDishs = menu.stream().collect(Collectors.counting());
		
		// 1-2. 불필요한 과정 생략
		howManyDishs = menu.stream().count();
		
		// 2. 최댓값과 최솟값 검색
		Comparator<Dish> dishCaloriesComparator = Comparator.comparingInt(Dish::getCalories);
		Optional<Dish> mostCaloriesDish = menu.stream().collect(maxBy(dishCaloriesComparator));
		mostCaloriesDish = menu.stream().collect(maxBy(Comparator.comparing(Dish::getCalories)));
		System.out.println(mostCaloriesDish);
		
		// 3. 총 칼로리 
		int totalCalories = menu.stream().collect(summingInt(Dish::getCalories));
		System.out.println(totalCalories);
		
		// 4. 평균계산 
		double avgCalories = menu.stream().collect(averagingInt(Dish::getCalories));
		avgCalories = menu.stream().collect(averagingInt(d->d.getCalories()));
		System.out.println(avgCalories);
		
		// 5. 통계 
		IntSummaryStatistics menuStaticstics = menu.stream().collect(summarizingInt(Dish::getCalories));
		System.out.println(menuStaticstics);
	
		// 6. 문자열 연결
		String shortMenu = menu.stream().map(Dish::getName).collect(joining());
		System.out.println(shortMenu);
		// toString()을 overriding 한 객체라면 아래처럼 사용가능 하다고는 하나, java1.8에서는 안되는데? 
		//String shortMenu2 = menu.stream().collect(joining());
		
		// 6-2. 구분자 추가 
		shortMenu = menu.stream().map(Dish::getName).collect(joining(", "));
		System.out.println(shortMenu);
		
		// 7. 범용 리듀싱 요약 연산
		int totalCalories2 = menu.stream().collect(reducing(0, Dish::getCalories, (i,j)-> i + j));
		System.out.println(totalCalories2);
		
		Optional<Dish> mostCalorieDish2 = menu.stream().collect(reducing((d1,d2) -> d1.getCalories() > d2.getCalories() ? d1 : d2));
		System.out.println(mostCalorieDish2);
	}

}
