package sort;

public class MergeSort extends Sort {

	private void merge(int[] arr, int west, int middle, int east)
	{
		int i = west;
		int j = middle+1;
		int k = west;
		
		while (i <= middle && j <= east)
		{
			if (arr[i] < arr[j])
			{
				sorted[k] = arr[i++];
			}
			else
			{
				sorted[k] = arr[j++];
			}
			k++;
		}
		if (i > middle)
		{
			for (int t = j; t <= east; t++)
			{
				sorted[k++] = arr[t];
			}
		}
		else
		{
			for (int t = i; t <= middle; t++)
			{
				sorted[k++] = arr[t];
			}
		}
		
		for (int t = west; t <= east; t++)
		{
			arr[t] = sorted[t];
		}
	}
	
	public void mergeSort(int[] arr, int west, int east)
	{
		if (west < east)
		{
			int middle = (west+east) / 2;
			mergeSort(arr, west, middle);
			mergeSort(arr, middle+1, east);
			merge(arr, west, middle, east);
		}
	}

	@Override
	public void sort(int[] arr, int start, int end) {
		// TODO Auto-generated method stub
		System.out.println("MergeSort");
		sorted = new int[arr.length];
		mergeSort(arr, start, end-1);
	}
	
	
}
