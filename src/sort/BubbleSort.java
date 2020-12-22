package sort;

public class BubbleSort extends Sort 
{
	private void BubbleSort(int[] arr, int start, int end)
	{
		for(int i = arr.length-1 ; i >= 1; i--)
		{
			for(int j = 1; j <= i; j++)
			{
				if (arr[j-1] > arr[j])
				{
					int temp = arr[j-1];
					arr[j-1] = arr[j]; 
					arr[j] = temp;
				}
			}
		}
	}
	@Override
	public void sort(int[] arr, int start, int end) {
		// TODO Auto-generated method stub
		System.out.println("BubbleSort");
		BubbleSort(arr, start, end);
	}
}
