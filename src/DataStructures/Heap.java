package DataStructures;

public interface Heap {
	
	HeapElement getElement() throws EmptyHeapException;
	
	void insertElement(HeapElement element);
	
	void deleteElement(int elementIndex);
}
