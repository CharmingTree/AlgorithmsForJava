package sort;

import java.util.ArrayList;

public class RadixSort2 extends Sort{
	
	public RadixSort2(int[] arr)
	{
		super(arr);
	}
	
	private int getMaxLength()
	{
		int maxLength = -1;
		
		for ( int i = 0; i < list.length; i++)
		{
			int len = (int)(Math.log10((double)list[i]))+1 ;
			if (len > maxLength)
			{
				maxLength = len;
			}
		}
		
		return maxLength;
	}
	
	private void radixSort()
	{
		int po = 1;
		int index = 0;
		int maxLength = getMaxLength();
		ArrayList<ArrayList<Integer>> bucket = new ArrayList<>();
		
		for (int i = 0; i < 10; i++)
		{
			bucket.add(new ArrayList<Integer>());
		}
		
		for (int i = 0; i < maxLength; i++)
		{
			for (int j = 0; j < list.length; j++)
			{
				int position = (list[j]/po) % 10;
				bucket.get(position).add(list[j]);
			}
			
			for (int j = 0; j < 10; j++)
			{
				while(!bucket.get(j).isEmpty())
				{
					list[index++] = bucket.get(j).get(0);
					bucket.get(j).remove(0);
				}
				
			}
			index = 0;
			po *= 10;
		}
	}
	
	@Override
	public void sort(int[] arr, int start, int end) {
		// TODO Auto-generated method stub
		radixSort();
	}

}
