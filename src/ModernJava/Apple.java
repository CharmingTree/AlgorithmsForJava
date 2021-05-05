package ModernJava;

interface ApplePrint {
	String accept(Apple a);
}

public class Apple {
	
	private final String name;
	private final int weight;
	private final Color color;
	
	public Apple(String name, int weight, Color color) {
		this.name = name;
		this.weight = weight;
		this.color = color;
	}
	
	public String getName() {
		return name;
	}
	public Integer getWeight() {
		return Integer.valueOf(weight);
	}

	public Color getColor() {
		return color;
	}

	@Override
	public String toString() {
		return "Apple [name=" + name + ", weight=" + weight + ", color=" + color + "]";
	}
	
	public enum Color {
		RED,
		BLUE,
		GREEEN
	}
}

// 동작이 추가 될 때마다 클래스를 구현하는 번잡스러움이 있다 
class AppleFancyFormatter implements ApplePrint {

	@Override
	public String accept(Apple a) {
		String characteristic = a.getWeight() > 150 ? "Heavy" : "light";
		return "A " + characteristic + " " + a.getColor() + " apple";
	}
}

class AppleSimpleFormatter implements ApplePrint {

	@Override
	public String accept(Apple a) {
		return "An apple of " + a.getWeight() + "g";
	}
	
}
