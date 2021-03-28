package DataStructures.LinkedList;

public class LinkedList {

	private Node head = null;
	
	
	
	private int getLength() {
		
		if (head == null)
			return 0;
		Node temp = head;
		int cnt = 0;
		while (temp != null) {
			cnt++;
			temp = temp.next;
		}
		System.out.println(cnt);
		return cnt;
	}
	
	public String printList() {
		Node temp = head;
		StringBuilder builder = new StringBuilder();
		while (temp != null) {
			builder.append(temp.data.toString()+" >>> ");
			temp = temp.next;
		}
		
		return builder.toString();
	}
	
	public void insertHead(Object data) {
		
		insertNth(0, data);
	}
	
	public void insertTail(Object data) {
		insertNth(getLength(), data);
	}
	
	public void insertNth(int index, Object data) {
		if (!(0 <= index && index <= getLength())) {
			throw new IndexOutOfBoundsException("Index out of List");
		}
		
				
		if (head == null) {
			Node newList = new Node(data);
			head = newList;
		}
		else if (index == 0) {
			Node newNode = new Node(data);
			newNode.next = head;
			head = newNode;
		}
		else {
			Node temp = head;
			Node newNode = new Node(data);
			for ( int i = 0; i < index-1; i++) {
				temp = temp.next;
			}
			
			if (temp.next != null) {
				newNode.next = temp.next;
				temp.next = newNode;
			}
			else {
				temp.next = newNode;
			}
			
			
		}
	}
	
	public void deleteHead() {
		deleteNth(0);
	}
	
	public void deleteTail() {
		deleteNth(getLength()-1);
	}
	
	public void deleteNth(int index) {
		
		if (!(0 <= index && index <= getLength())) {
			throw new IndexOutOfBoundsException("index out of List");
		}
		
		if (index == 0) {
			head = head.next;
		}
		else {
			Node temp = head;
			
			for ( int i = 0; i < index-1; i++) {
				temp = temp.next;
			}
			
			temp.next = temp.next.next;
		}
	}
	
	public void reversed() {
		
		Node current = head;
		Node prev = null;
		
		while (current != null) {
			
			Node temp = current.next;
			
			current.next = prev;
			
			prev = current;
			
			current = temp;
		}
		head = prev;
	}
	
	
	private static class Node {
		
		private Object data;
		private Node next;
		
		Node(Object data) {
			this.data = data;
			this.next = null;
		}
	}
}
