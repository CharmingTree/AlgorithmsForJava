package Sorts;

import static Sorts.SortUtils.*;

public class MergeSort implements SortAlgorithm {
	
	@Override
	public <T extends Comparable<T>> T[] sort(T[] unsorted) {
		doSort(unsorted, 0, unsorted.length-1);
		return unsorted;
	}
	
	private static <T extends Comparable<T>> void doSort(T[] arr, int left, int right) {
		if (left < right) {
			int mid = left + (right - left) / 2; 
			doSort(arr, left, mid);
			doSort(arr, mid+1, right);
			merge(arr, left, mid, right);
			
		}
	}
	
	private static <T extends Comparable<T>> void merge(T[] arr, int left, int mid, int right) {
		int length = right - left + 1;
		T[] temp = (T[]) new Comparable[length];
		int i = left;
		int j = mid+1;
		int k = 0;
		
		while (i <= mid && j <= right) {
			if (arr[i].compareTo(arr[j]) <= 0) {
				temp[k++] = arr[i++];
			} else {
				temp[k++] = arr[j++];
			}
		}
		
		while ( i <= mid) {
			temp[k++] = arr[i++];
		}
		
		while ( j <= right) {
			temp[k++] = arr[j++];
		}
		
		System.arraycopy(temp, 0, arr, left, length);
 	}
	
	public static void main(String[] args) {
		Integer[] arr = {4, 23, 6, 78, 1, 54, 231, 9, 12};
		MergeSort mergeSort = new MergeSort();
		mergeSort.sort(arr);
		print(arr);
		
		String[] stringArray = {"c", "a", "e", "b", "d"};
		mergeSort.sort(stringArray);
		print(stringArray);
	}

}
