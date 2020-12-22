package DataStructures;

import java.util.ArrayList;
import java.util.List;

public class MaxHeap implements Heap{
	
	
	private final List<HeapElement> maxHeap;
	
	public MaxHeap(List<HeapElement> listElements) {
		maxHeap = new ArrayList<>();
		
		for (HeapElement heapElement : listElements) {
			if (heapElement != null) {
				insertElement(heapElement);
			}
			else {
				System.out.println("Null Element");
			}
		}
		
		if (maxHeap.size() == 0 ) {
			System.out.println("No Element ");
		}
	}
	
	public HeapElement getElement(int elementIndex) {
		if ((elementIndex <= 0) || (elementIndex > maxHeap.size()))
			throw new IndexOutOfBoundsException();
		return maxHeap.get(elementIndex);
	}
	
	private double getElementKey(int elementIndex) {
		return maxHeap.get(elementIndex-1).getKey();
	}
	
	private void swap(int index1, int index2) {
		HeapElement temporaryElement = maxHeap.get(index1-1);
		maxHeap.set(index1-1, maxHeap.get(index2-1));
		maxHeap.set(index2-1, temporaryElement);
	}
	
	private void toggleUp(int elementIndex) {
		double key = maxHeap.get(elementIndex-1).getKey();
		while (getElementKey((int)Math.floor(elementIndex/2.0)) < key) {
			swap(elementIndex, (int)Math.floor(elementIndex/2.0));
			elementIndex = (int) Math.floor(elementIndex/2.0);
		}
	}
	
	private void toggleDown(int elementIndex) {
		double key = maxHeap.get(elementIndex-1).getKey();
		boolean wrongOrder = 
				(key < getElementKey(elementIndex * 2)) 
		     || (key < getElementKey(Math.min(elementIndex * 2, maxHeap.size())));
		
		while ((2 * elementIndex < maxHeap.size()) && wrongOrder)
		{
			if((2 * elementIndex < maxHeap.size())
		    && (getElementKey(elementIndex * 2 + 1) > getElementKey(elementIndex * 2))) {
				swap(elementIndex, 2 * elementIndex + 1);
				elementIndex = 2 * elementIndex + 1;
			}
			else
			{
				swap(elementIndex, 2 * elementIndex);
				elementIndex = 2 * elementIndex;
			}
			
			wrongOrder = (key < getElementKey(elementIndex * 2)) || (key < getElementKey(Math.min(elementIndex * 2, maxHeap.size())));
		}
	}
	
	private HeapElement extractMax() {
		HeapElement result = maxHeap.get(0);
		deleteElement(0);
		return result;
	}
	
	
	
	@Override
	public HeapElement getElement() throws EmptyHeapException {
		// TODO Auto-generated method stub
		try {
			return extractMax();
		} catch (Exception e) {
			throw new EmptyHeapException("Heap is empty. Error retrieving element");
		}
	}
	
	@Override
	public void deleteElement(int elementIndex) {
		if (maxHeap.isEmpty()) {
			try {
				throw new EmptyHeapException("Attempt to delete an element from an empty heap");
			} catch (EmptyHeapException e) {
				e.printStackTrace();
			}
			
			if ((elementIndex > maxHeap.size()) || (elementIndex <= 0)) {
				throw new IndexOutOfBoundsException("Index out of heap range");
			}
			
			maxHeap.set(elementIndex-1, getElement(maxHeap.size()));
			maxHeap.remove(maxHeap.size());
			
			if (getElementKey(elementIndex) > getElementKey((int)Math.floor(elementIndex / 2.0))) {
				toggleUp(elementIndex);
			}
			
			else if (((2* elementIndex <= maxHeap.size()) && (getElementKey(elementIndex) < getElementKey(elementIndex * 2)))
				|| ((2 * elementIndex < maxHeap.size())
				&& (getElementKey(elementIndex) < getElementKey(elementIndex * 2))))
			{
				toggleDown(elementIndex);
			}
		}
	}
	
	@Override
	public void insertElement(HeapElement element) {
		maxHeap.add(element);
		toggleUp(maxHeap.size());
	}
	

}
