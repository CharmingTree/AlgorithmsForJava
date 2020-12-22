package sort;

public class InsertionSort2 extends Sort{

	public InsertionSort2() {
		// TODO Auto-generated constructor stub
	}
	public InsertionSort2(int[] arr)
	{
		super(arr);
	}
	
	private void insertionSort()
	{
		int pos = 0;
		for (int i = 1; i < list.length; i++) {
			pos = i;
			while (pos > 0 && list[pos-1] > list[pos])
			{
				swap(pos-1, pos);
				pos--;
			}
		}
	}
	
	@Override
	public void sort(int[] arr, int start, int end) {
		// TODO Auto-generated method stub
		insertionSort();
	}
}
