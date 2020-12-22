package sort;

public class MaxHeapSort2 extends Sort{

	public MaxHeapSort2(int[] arr)
	{
		super(arr);
	}
	
	private void MaxHeapify(int root)
	{
		int len = list.length;
		if ( root >= len)
			return;
		
		int child1 = root * 2 + 1;
		int child2 = root * 2 + 2;
		
		MaxHeapify(child1);
		MaxHeapify(child2);
		
		if (child2 >= len)
		{
			if (child1 >= len)
			{
				return;
			}
			else
			{
				if (list[root] < list[child1])
				{
					swap(root, child1);
				}
				return;
			}
		}
		
		int large = child1;
		
		if (list[large] < list[child2])
		{
			large = child2;
		}
		
		if (list[root] < list[large])
		{
			swap(root, large);
			heapSort(large, len);
		}
	}
	
	private void heapSort(int root, int len)
	{
		int child1 = root * 2 + 1;
		int child2 = root * 2 + 2;
		
		if ( child2 >= len)
		{
			if ( child1 >= len)
			{
				return;
			}
			else
			{
				if (list[root] < list[child1])
				{
					swap(root, child1);
				}
				return;
			}
		}
		
		if (list[child1] > list[child2]) {
			int temp = child1;
			child1 = child2;
			child2 = temp;
		}
		
		if (list[root] < list[child2])
		{
			swap(root, child2);
			heapSort(child2, len);
		}
	}
	
	@Override
	public void sort(int[] arr, int start, int end) {
		// TODO Auto-generated method stub
		MaxHeapify(0);
		for(int i = end-1; i >= start; i--)
		{
			swap(0,i);
			heapSort(0, i);
		}
		
	}
}
