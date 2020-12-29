package sort;

public class MinHeapSort extends Sort
{
	
	public MinHeapSort(int[] arr)
	{
		super(arr);
	}
	
	private void MinHeapify(int root)
	{
		int len = list.length;
		if (root >= len)
		{
			return;
		}
		
		int child1 = root * 2 + 1;
		int child2 = root * 2 + 2;
		
		MinHeapify(child1);
		MinHeapify(child2);
		
		if (child2 >= len)
		{
			if (child1 >= len)
			{
				return;
			}
			else
			{
				if (list[root] > list[child1])
				{
					swap(root, child1);
				}
				return;
			}
		}
		
		int small = child1;
		
		if (list[child2] < list[small])
		{
			small = child2;
		}
		
		if (list[root] > list[small])
		{
			swap(root, small);
			heapSort(small, len);
			return;
		}
	}
	
	private void heapSort(int root, int len)
	{
		int child1 = root * 2 + 1;
		int child2 = root * 2 + 2;
		
		if (child2 >= len)
		{
			if (child1 >= len)
			{
				return;
			}
			else
			{
				if (list[root] > list[child1])
				{
					swap(root, child1);
				}
				return;
			}
		}
		
		if (list[child1] < list[child2])
		{
			int temp = child1;
			child1 = child2;
			child2 = temp;
		}
		
		if (list[root] > list[child2])
		{
			swap(root, child2);
			heapSort(child2, len);
		}
		return;
	}
	
	private void minHeapSort(int start, int end)
	{
		MinHeapify(0);
		for (int i = end-1; i >= 0; i--)
		{
			swap(0,i);
			heapSort(0, i);
		}
	}
	
	@Override
	public void sort(int[] arr, int start, int end)  {
		// TODO Auto-generated method stub
		minHeapSort(start, end);
	}
}
