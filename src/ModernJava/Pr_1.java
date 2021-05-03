package ModernJava;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

import static java.util.stream.Collectors.*;

public class Pr_1 {
	
	public static void prettyPrintApple(List<Apple> inventory, ApplePrint printer) {
		for (Apple apple : inventory) {
			String output = printer.accept(apple);
			System.out.println(output);
		}
	}
	
	public static void appleStreamTest() {
		
		
		List<Apple> inventory = Arrays.asList(
				new Apple("a", 100, Apple.Color.RED),
				new Apple("b", 121, Apple.Color.BLUE),
				new Apple("c", 90, Apple.Color.GREEEN),
				new Apple("d", 200, Apple.Color.RED),
				new Apple("e", 178, Apple.Color.RED),
				new Apple("f", 200, Apple.Color.RED)
				
		);
		
		// 1
		//List<Apple> heavyApples = inventory.stream().filter(a -> a.getWeight() > 150).collect(toList());
		//List<Apple> heavyApples = inventory.stream().filter((Apple a) -> a.getWeight() > 150).collect(toList());
		//System.out.println(heavyApples);
		
		// 2
		prettyPrintApple(inventory, new AppleFancyFormatter());
		prettyPrintApple(inventory, new AppleSimpleFormatter());
	}

	public static void main(String[] args) {
//		List<Dish> menu = Arrays.asList(
//				new Dish("pork", false, 800, Dish.Type.MEAT),
//				new Dish("beef", false, 700, Dish.Type.MEAT),
//				new Dish("chicken", false, 400, Dish.Type.MEAT),
//				new Dish("french fries", true, 530, Dish.Type.OTHER), new Dish("rice", true, 350, Dish.Type.OTHER),
//				new Dish("season fruit", true, 120, Dish.Type.OTHER), new Dish("pizza", true, 550, Dish.Type.OTHER),
//				new Dish("prawns", false, 300, Dish.Type.FISH),
//				new Dish("salmon", false, 450, Dish.Type.FISH)
//		);
		
//		List<String> highName = menu.stream().filter(dish -> dish.getCalories() > 300).map(Dish::getName).collect(toList());
//		List<Dish> highDish = menu.stream().filter(dish->dish.getCalories() > 300).collect(toList());
//		
//		List<String> names = menu.stream()
//				.filter(dish -> {
//					System.out.println("filterings "+dish.getName()+" - ");
//					if (dish.getCalories() > 300) {
//						
//						return true;
//					}
//					else 
//						return false;
//				}).map(dish -> {
//					System.out.println("Mapping "+dish.getName());
//					return dish.getName();
//				}).collect(toList());
		
		
		//System.out.println(highName);
		//System.out.println(highDish);
		//System.out.println(names);
		
		// 1
		appleStreamTest();
		
		
	}

}
