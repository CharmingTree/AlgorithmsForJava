package EffectiveJava.staticfactory;

// 정적 팩터리 방식의 싱글턴
public class Elvis {
	private static final Elvis INSTANCE = new Elvis();
	private Elvis() {}
	public static Elvis getInstance() { return INSTANCE; }
	
	public void leaveTheBuilding() {
		System.out.println("whoa baby. I'm outta here");
	}
	
	public static void main(String[] args)
	{
		Elvis elvis = Elvis.getInstance();
		elvis.leaveTheBuilding();
	}
}
