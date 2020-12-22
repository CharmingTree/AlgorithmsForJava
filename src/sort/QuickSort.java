package sort;

public class QuickSort extends Sort{

	public int partition(int[] arr, int start, int end) 
	{
		int left = start;
		int right = end;
		int pivot = end;
		
		while (left < right) 
		{
			while(arr[pivot] > arr[left] && left < right)
			{
				left++;
			}
			while(arr[pivot] <= arr[right] && left < right)
			{
				right--;
			}
			
			if (left < right) 
			{
				int temp = arr[left];
				arr[left] = arr[right];
				arr[right] = temp;
			}
		}
		
		int temp = arr[right];
		arr[right] = arr[pivot];
		arr[pivot] = temp;
		
		return right;
	}
	
	public void quickSort(int[] arr, int start, int end)
	{
		if (start < end)
		{
			int pivot = partition(arr, start, end);
			quickSort(arr, start, pivot-1);
			quickSort(arr, pivot+1, end);
		}
	}

	@Override
	public void sort(int[] arr, int start, int end) {
		// TODO Auto-generated method stub
		System.out.println("QuickSort");
		quickSort(arr, start, end-1);
	}
	
	
	
}
