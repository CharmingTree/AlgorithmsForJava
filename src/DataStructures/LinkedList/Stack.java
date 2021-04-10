package DataStructures.LinkedList;

public class Stack {

	private Node head;
	
	Stack() {
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
				cnt++;
				temp = temp.next;
			}
			return cnt;
		}
	}
	
	public boolean push(Object data) {
		Node newNode = new Node(data);
		if (head == null) {
			head = newNode;
		}
		else {
			newNode.next = head;
			head = newNode;
		}
		return true;
	}
	
	public Object pop() {
		if (head == null) {
			return null;
		}
		else if (this.size() == 1){
			Object resultData = head.data;
			head = null;
			return resultData;
		}
		else {
			Object resultData = head.data;
			head = head.next;
			return resultData;
		}
	}
	
	public Object peek() {
		if (head == null) {
			return null;
		}
		else {
			return head.data;
		}
	}

}
