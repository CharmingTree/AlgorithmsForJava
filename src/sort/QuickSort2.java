package sort;

public class QuickSort2 extends Sort {

	public QuickSort2(int[] arr)
	{
		super(arr);
	}
	
	private int partition(int start, int end)
	{
		int left = start;
		int right = end;
		int pivot = end;
		
		while (left < right)
		{
			while (list[pivot] > list[left] && left < right)
			{
				left++;
			}
			while (list[pivot] <= list[right] && left < right)
			{
				right--;
			}
			if (left < right)
			{
				swap(left, right);
			}
		}
		
		swap(right, pivot);
		return right;
	}
	
	private void quickSort(int start, int end)
	{
		if ( start < end)
		{
			int pivot = partition(start, end);
			quickSort(start, pivot-1);
			quickSort(pivot+1, end);
		}
	}
	
	@Override
	public void sort(int[] arr, int start, int end) {
		// TODO Auto-generated method stub
		quickSort(start, end-1);
	}
}
