import sort.*;

public class Controller {

	public static void main(String[] args) 
	{
		int[] arr = {30, 2, 1, 29, 39, 3, 489, 99, 4, 5, 10, 0, 22, 1, 33, 55};
		
		System.out.println("before");
		for (int i = 0; i < arr.length; i++)
		{
			System.out.print(arr[i]+", ");
			if ( i == arr.length-1) { System.out.println(); }
		}
//		Sort sort = new QuickSort();
		//Sort sort = new MaxHeapSort();
		//Sort sort = new RadixSort();
//		Sort sort = new InsertionSort();
		//Sort sort = new BubbleSort2(arr);
		//Sort sort = new InsertionSort2(arr);
		//Sort sort = new MaxHeapSort2();
		//Sort sort = new MergeSort2(arr);
		//Sort sort = new MaxHeapSort2(arr);
		//Sort sort = new MergeSort2(arr);
		//Sort sort = new QuickSort2(arr);
		//Sort sort = new RadixSort2(arr);
		Sort sort = new MinHeapSort(arr);
		
		sort.sort(null, 0, arr.length);
		System.out.println("after");
		for (int i = 0; i < arr.length; i++)
		{
			System.out.print(arr[i]+", ");
			if ( i == arr.length-1) { System.out.println(); }
		}
		
		sort.verifySorting(arr);
		
	}

}
