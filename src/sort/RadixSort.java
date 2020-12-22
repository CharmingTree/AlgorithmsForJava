package sort;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class RadixSort extends Sort
{
	private int maxLength(int[] arr)
	{
		int maxlength = 0;
		
		for (int i=0; i<arr.length; i++)
		{
			int len = (int)(Math.log10((double)arr[i]))+1;
			if (maxlength < len)
			{
				maxlength = len;
			}
		}
		
		return maxlength;
	}
	
	private void radixSort(int[] arr)
	{
		ArrayList<Queue> bucket = new ArrayList<Queue>(); 
		int po = 1;
		int index = 0;
		int maxlength = maxLength(arr);
		
		for (int i = 0; i < 10; i++)
		{
			bucket.add(new LinkedList<Integer>());
		}
		
		for(int i = 0; i < maxlength; i++)
		{
			for (int j = 0; j < arr.length; j++)
			{
				int position = (arr[j]/po) % 10;
				bucket.get(position).offer(arr[j]);
			}
			
			for (int j = 0; j < 10; j++)
			{
				while (!bucket.get(j).isEmpty()){
					arr[index++] = (int)bucket.get(j).poll();
				}
			}
			
			index = 0;
			po *= 10;
		}
		
	}
	
	@Override
	public void sort(int[] arr, int start, int end) 
	{
		System.out.println("RadixSort");
		radixSort(arr);
	}

}
