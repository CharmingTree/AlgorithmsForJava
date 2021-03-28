package DataStructures;

import DataStructures.LinkedList.LinkedList;

public class MainTest {

	public static void main(String[] args) {
		
		LinkedList myList = new LinkedList();
		
		myList.insertHead(10);
		myList.insertNth(0,20);
		myList.insertNth(0,30);
		myList.insertNth(0,40);
		myList.insertNth(1,99);
		myList.insertNth(1,88);
		myList.insertTail("last");
		
		System.out.println(myList.printList());
		
		myList.deleteNth(2);
		
		System.out.println(myList.printList());
		
		myList.reversed();
		
		System.out.println(myList.printList());
		

	}

}
