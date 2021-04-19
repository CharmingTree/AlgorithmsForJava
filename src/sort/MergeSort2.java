package sort;

public class MergeSort2 extends Sort{
	
	
	public void merge(int[] arr, int left, int middle, int right) {
		
		int i = left;
		int j = middle+1;
		int k = left;
		
		while (i <= middle && j <= right ) {
			if (arr[i] < arr[j]) {
				sorted[k] = arr[i++];
			}
			else {
				sorted[k] = arr[j++];
			}
			k++;
		}
		
		if (i > middle) {
			for (int t = j; t <= right; t++) {
				sorted[k++] = arr[t];
			}
		}
		else {
			for (int t = i; t <= middle; t++) {
				sorted[k++] = arr[t];
			}
		}
		
		for (int t = left; t <= right; t++) {
			arr[t] = sorted[t];
		}
	}
	
	public void mergeSort(int[] arr, int start, int end) {
		if (start < end) {
			int middle = (start+end) / 2;
			mergeSort(arr, start, middle);
			mergeSort(arr, middle+1, end);
			merge(arr, start, middle, end);
		}
	}
	
	@Override
	public void sort(int[] arr, int start, int end) {
		System.out.println("MergeSort");
		sorted = new int[arr.length];
		mergeSort(arr, start, end-1);
		
	}

}
