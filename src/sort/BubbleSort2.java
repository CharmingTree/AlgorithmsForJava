package sort;

public class BubbleSort2 extends Sort{


	public BubbleSort2() {}
	public BubbleSort2(int[] arr)
	{
		super(arr);
	}
	private void bubbleSort()
	{
		for(int i = list.length-1; i >= 0; i--)
		{
			for ( int j = 1; j <= i; j++)
			{
				if (list[j-1] > list[j])
				{
					swap(j-1, j);
				}
			}
			
		}
	}
	
	@Override
	public void sort(int[] arr, int start, int end) {
		// TODO Auto-generated method stub
		bubbleSort();
	}
}
