package DataStructures;

public class HeapElement {

	private final double key;
	private final Object additionalInfo;
	
	public HeapElement(double key, Object info)
	{
		this.key = key;
		this.additionalInfo = info;
	}
	
	public HeapElement(int key, Object info)
	{
		this.key = key;
		this.additionalInfo = info;
	}
	
	public HeapElement(Integer key, Object info)
	{
		this.key = key;
		this.additionalInfo = info;
	}

	public double getKey() {
		return key;
	}

	public Object getAdditionalInfo() {
		return additionalInfo;
	}
	
	
	
}
