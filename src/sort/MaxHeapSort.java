package sort;

public class MaxHeapSort extends Sort
{
	private void MaxHeapify(int[] arr, int root)
	{
		if ( root  >= arr.length ) { return; }
		
		int child1 = root * 2 + 1;
		int child2 = root * 2 + 2;
		
		MaxHeapify(arr, child1);
		MaxHeapify(arr, child2);
		
		if ( child2 >= arr.length){
			if (child1 >= arr.length)
			{
				return;
			}
			else
			{
				if (arr[root] < arr[child1])
				{
					int temp = arr[root];
					arr[root] = arr[child1];
					arr[child1] = temp;
				}
				return;
			}
		}
		
		int large = child1;
		
		if (arr[child1] < arr[child2]){
			large = child2;
		}
		
		if ( arr[root] < arr[large]){
			int temp = arr[root];
			arr[root] = arr[large];
			arr[large] = temp;
			heapsort(arr, large, arr.length);
			return;
		}
	}
	
	private void heapsort(int[] arr, int root, int len)
	{
		int child1 = root * 2 + 1;
		int child2 = root * 2 + 2;
		
		if ( child2 >= len )
		{
			if (child1 >= len)
			{
				return;
			}
			else
			{
				if (arr[root] < arr[child1])
				{
					int temp = arr[root];
					arr[root] = arr[child1];
					arr[child1] = temp;
				}
				return;
			}
		}
		
		if (arr[child1] > arr[child2])
		{
			int temp = child1;
			child1 = child2;
			child2 = temp;
		}
		
		if (arr[root] < arr[child2])
		{
			int temp = arr[root];
			arr[root] = arr[child2];
			arr[child2] = temp;
			heapsort(arr, child2, len);
		}
	}
	
	@Override
	public void sort(int[] arr, int start, int end) {
		// TODO Auto-generated method stub
		System.out.println("MaxHeapSort");
		MaxHeapify(arr, 0);
		for (int i = end-1; i >= start; i--)
		{
			int temp = arr[0];
			arr[0] = arr[i];
			arr[i] = temp;
			heapsort(arr, 0, i);
		}
		
	}
}
