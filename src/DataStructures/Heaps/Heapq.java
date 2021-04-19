package DataStructures.Heaps;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class Heapq {

	private ArrayList<Integer> h;
	private int heapSize;
	public Heapq() {
		this.h = new ArrayList<>();
		this.heapSize = 0;
	}
	
	public Optional<Integer> getParentIndex(int child) {
		if (child > 0) {
			return Optional.of((child - 1) / 2);
		}
		return null;
	}
	
	public Optional<Integer> getLeftIndex(int parent) {
		int leftChild = parent * 2 + 1;
		if (leftChild < this.heapSize) {
			return Optional.of(leftChild);
		}
		return null;
	}
	
	public Optional<Integer> getRightIndex(int parent) {
		int rightChild = parent * 2 + 2;
		if (rightChild < this.heapSize) {
			return Optional.of(rightChild);
		}
		return null;
	}
	
	public void maxHeapify(Optional<Integer> index) {
		Integer idx = index.get();
		if (idx < this.heapSize) {
			Integer violation = idx;
			Integer leftChildIdx = null;
			Integer rightChildIdx = null;

			if (this.getLeftIndex(violation) != null)
				leftChildIdx = this.getLeftIndex(violation).get();
			if (this.getRightIndex(violation) != null)
				rightChildIdx = this.getRightIndex(violation).get();
			
			if (leftChildIdx != null && this.h.get(leftChildIdx) > this.h.get(violation)) {
				violation = leftChildIdx;
			}
			
			if (rightChildIdx != null && this.h.get(rightChildIdx) > this.h.get(violation)) {
				violation = rightChildIdx;
			}
			
			if (violation != idx) {
				Integer temp = this.h.get(violation);
				this.h.set(violation, this.h.get(idx));
				this.h.set(idx, temp);
				
				this.maxHeapify(Optional.of(violation));
			}
		}
	}
	
	public void buildMaxHeap(List<Integer> collection) {
		this.h = new ArrayList<>(collection);
		//this.h = (ArrayList<Integer>) collection;
		this.heapSize = this.h.size();
		if ( this.heapSize > 1) {
			for (int i = this.heapSize / 2; i >= 0; i--) {
				this.maxHeapify(Optional.of(i));
			}
		}
	}
	
	
	public static void main(String[] args) {
		Heapq hq = new Heapq();
		List<Integer> myArr = Arrays.asList(10,11,4, 5, 3, 9, 7);

		System.out.println(myArr);
		hq.buildMaxHeap(myArr);
		
		System.out.println(hq.h);
		
		
	}
	
}
