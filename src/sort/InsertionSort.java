package sort;

public class InsertionSort extends Sort
{
	private void insertionSort(int[] arr, int start, int end)
	{
		int pos = 0;
		for ( int i = start+1; i < arr.length; i++) {
			pos = i;
			while (pos > start && arr[pos-1] > arr[pos])
			{
				int temp = arr[pos-1];
				arr[pos-1] = arr[pos];
				arr[pos] = temp;
				pos--;
			}
		}
	}
	
	@Override
	public void sort(int[] arr, int start, int end) {
		// TODO Auto-generated method stub
		System.out.println("InsertionSort");
		insertionSort(arr, start, end);
	}
}
