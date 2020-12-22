package sort;

public class MergeSort2 extends Sort{
	
	public MergeSort2(int[] arr)
	{
		super(arr);
	}
	
	private void merge(int west, int middle, int east)
	{
		int i = west;
		int j = middle+1;
		int k = west;
		
		while (i <= middle && j <= east)
		{
			if (list[i] < list[j])
			{
				sorted[k] = list[i];
				i++;
			}
			else
			{
				sorted[k] = list[j];
				j++;
			}
			k++;
		}
		
		if (i > middle)
		{
			for (int t = j; j <= east; j++)
			{
				sorted[k] = list[t];
				k++;
			}
		}
		else
		{
			for (int t = i; i <= middle; i++)
			{
				sorted[k] = list[t];
				k++;
			}
		}
		
		for (int t = west; t <= east; t++)
		{
			list[t] = sorted[t];
		}
	}
	
	private void mergeSort(int start, int end)
	{
		if (start < end)
		{
			int middle = (start+end) / 2;
			mergeSort(start, middle);
			mergeSort(middle+1, end);
			merge(start, middle, end);
		}
	}
	
	@Override
	public void sort(int[] arr, int start, int end) {
		// TODO Auto-generated method stub
		mergeSort(start, end-1);
	}

}
