package ModernJava;

import java.util.Arrays;
import java.util.Collection;
import java.util.Comparator;
import java.util.HashMap;
import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;

import ModernJava.Domain.Dish;
import ModernJava.Domain.Dish.Type;
import ModernJava.Domain.Trader;
import ModernJava.Domain.Transaction;

import static java.util.stream.Collectors.*;


public class StreamPracticeForGroup {

	public enum CaloricLevel { DIET, NORMAL, FAT }
	
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
		long howManyDishs = menu.stream().collect(counting());
		
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
		
		
		// 8. 간단 그룹핑 
		Map<Dish.Type, List<Dish>> dishesByType = menu.stream().collect(groupingBy(Dish::getType));
		
		System.out.println(dishesByType);
		System.out.println(dishesByType.getClass());
		
		// 8-2. 여러 조건에 의한 그룹핑
		// 아래 dish.get....자동완성에서 안보여서 불가능한 코드인줄 알았는데. 컴파일 오류없이 잘 동작한다. 뭐지..?
		Map<CaloricLevel, List<Dish>> disheByCaloricLevel = menu.stream().collect(
				groupingBy(dish -> {
			if (dish.getCalories() <= 400) return CaloricLevel.DIET;
			else if (dish.getCalories() <= 700) return CaloricLevel.NORMAL;
			else return CaloricLevel.FAT;
		}));
		
		System.out.println(disheByCaloricLevel);
		
		// 9-1. 필터링후 그룹화의 문제점
		Map<Dish.Type, List<Dish>> caloricDishesByType = menu.stream().filter(dish -> dish.getCalories() > 500).collect(groupingBy(Dish::getType));
		// 500 칼로리 이하인 Fish 종류의 음식은 맵에서 키 자체가 사라져있다. 
		System.out.println(caloricDishesByType);
		
		// 9-2. 위 문제를 해결하기 위한 방법
		// Collector 안으로 필터 프레디케이트를 이동함으로 이 문제를 해결할 수 있다.
		// 이것도 자바 9 부터 지원된다. 
//		Map<Dish.Type, List<Dish>> caloricDishesByType2 = menu.stream()
//				.collect(
//						groupingBy(Dish::getType,
//								filtering(dish -> dish.getCalories() > 500, toList())
//								));
//		
//		System.out.println(caloricDishesByType2);
		
		
		
		// 10. 요리 태그 간편 추출  
		Map<String, List<String>> dishTags = new HashMap<>();
		
		dishTags.put("pork", Arrays.asList("greasy", "salty"));
		dishTags.put("beef", Arrays.asList("salty", "roasted"));
		dishTags.put("chicken", Arrays.asList("fried", "crisp"));
		dishTags.put("french fries", Arrays.asList("greasy", "fried"));
		dishTags.put("rice", Arrays.asList("light", "natural"));
		dishTags.put("season fruit", Arrays.asList("fresh", "natural"));
		dishTags.put("pizza", Arrays.asList("tasty", "salty"));
		dishTags.put("prawns", Arrays.asList("tasty", "roasted"));
		dishTags.put("salmon", Arrays.asList("delicious", "fresh"));
		
		// 자바 8은 지원안함 .
//		Map<Dish.Type, Set<String>> dishNamesByType = menu.stream()
//				.collect(groupingBy(Dish::getType,
//							flatMapping(dish -> dishTags.get( dish.getName() ).stream(),
//								toSet())));
//
//		System.out.println(dishNamesByType);

		// 11. 다수준 그룹화 
		
		Map<Dish.Type, Map<CaloricLevel, List<Dish>>> dishsByTypeCaloricLevelss = menu.stream().collect(
				groupingBy(Dish::getType,
						groupingBy(dish -> {
							if (dish.getCalories() <= 400)
								return CaloricLevel.DIET;
							else if (dish.getCalories() <= 700)
								return CaloricLevel.NORMAL; 
							else
								return CaloricLevel.FAT;
						})
						)
				);
		
		System.out.println(dishsByTypeCaloricLevelss);
		

		
		// 12. 서브 그룹으로 데이터 수집 
		Map<Dish.Type, Long> typesCount = menu.stream().collect(groupingBy(Dish::getType, counting()));
		System.out.println(typesCount);
		
		// 12-2. 음식 종류별 가장 높은 칼로리 
		Map<Dish.Type, Optional<Dish>> mostCaloricByType = menu.stream()
				.collect(groupingBy(Dish::getType,
						maxBy(Comparator.comparingInt(Dish::getCalories))));
		System.out.println(mostCaloricByType);
		
		// 12-3. 컬렉터 결과를 다른 형식에 적용하기 (위는 굳이 Optional로 감쌀 필요가 없다. maxBy반환이 옵셔널이기 때문이라 사용되었는데. 애초에 null이존재 할 수 없는 코드 )
		// Optional로 감싸지않는 방식 사용하기 
		Map<Dish.Type, Dish> mostCaloricByType2 =
				menu.stream()
					.collect(groupingBy(Dish::getType, 
							collectingAndThen(maxBy(Comparator.comparing(Dish::getCalories)), Optional::get)));
		
		System.out.println(mostCaloricByType2);
		
	}
	

}
