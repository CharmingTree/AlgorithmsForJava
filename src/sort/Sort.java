package sort;

public abstract class Sort 
{
	int[] list;
	int[] sorted;
	
	public Sort() {}
	public Sort(int[] plist) 
	{
		this.list = plist;
		
		this.sorted = new int[(list.length)];
	}
	
	abstract public void sort(int[] arr, int start, int end);
	
	public void swap(int a, int b)
	{
		int temp = list[a];
		list[a] = list[b];
		list[b] = temp;
	}
	
	public void verifySorting(int[] arr)
	{
		for (int i = 1; i < arr.length; i++)
		{
			if (arr[i-1] > arr[i])
			{
				System.out.println("fail");
				break;
			}
			if( i == arr.length-1 )
			{
				System.out.println("success");
			}
		}
	}
}
