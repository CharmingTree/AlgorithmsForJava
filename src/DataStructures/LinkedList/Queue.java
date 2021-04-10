package DataStructures.LinkedList;

public class Queue {

	
	// enqueue, dequeue
	// peek, 
	// isEmpty
	private Node head;
	
	Queue() {
		this.head = null;
	}
	
	private static class Node {
		private Object data;
		private Node next;
		
		Node (Object data) {
			this.data = data;
			this.next = null;
		}
	}
	
	public String toString() {
		if (head == null) 
			return "";
		StringBuilder sb = new StringBuilder();
		
		Node temp = head;
		while (temp != null) {
			sb.append(temp.data);
			sb.append(", ");
			temp = temp.next;
		}
		return sb.toString();
	}
	
	public boolean isEmpty() {
		if (this.head == null)
			return true;
		else
			return false;
	}
	
	public int size() {
		if (head == null) {
			return 0;
		}
		else {
			int cnt = 0;
			Node temp = head;
			while (temp != null) {
				cnt ++;
				temp = temp.next;
			}
			return cnt;
 		}
	}
	
	public boolean enqueue(Object data) {
		boolean resultYN = false;
		Node newNode = new Node(data);
		if (head == null) {
			head = newNode;
			resultYN = true;
		}
		else if (this.size() == 1) {
			head.next = newNode;
			resultYN = true;
		}
		else {
			Node temp = head;
			while (temp.next != null) {
				temp = temp.next;
			}
			temp.next = newNode;
			resultYN = true;
		}
		return resultYN;
	}
	
	public Object dequene() {
		if (head == null) {
			return null;
		}
		else if (this.size() == 1) {
			Node deNode = head;
			head = null;
			return deNode.data;
		}
		else {
			Node resultData = head;
			head = head.next;
			return resultData.data;
		}
	}
	
	public Object peek() {
		if (head == null) {
			return null;
		}
		else {
			Node temp = head;
			while (temp.next != null) {
				temp = temp.next;
			}
			
			return temp.data;
		}     
	}

}
