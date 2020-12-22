package EffectiveJava.singleton;

// 열거 타입 방식의 싱글턴
public enum EnumType {
	INSTANCE;
	
	public void leaveTheBuilding() {
		System.out.println("Wait Honey!");
	}

	public static void main(String[] args)
	{
		EnumType enumType = EnumType.INSTANCE;
		enumType.leaveTheBuilding();
	}
}
