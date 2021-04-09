package DataStructures.Graph;

import java.util.LinkedList;

class Queue {
	
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
			return deNode;
		}
		else {
			Node prev = null;
			Node temp = head;
			while (temp.next != null) {
				prev = temp;
				temp = temp.next;
			}
			
			prev.next = null;
			return temp.data;
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

class Graph {
	Node[] nodes;
	
	Graph(int size) {
		nodes = new Node[size];
		for ( int i = 0; i < size; i++) {
			nodes[i] = new Node(i);
		}
	}
	
	class Node{
		int data;
		LinkedList<Node> adjacent;
		boolean marked;
		Node(int data) {
			this.data = data;
			this.marked = false;
			this.adjacent = new LinkedList<>();
		}
	}
	
	void addEdge(int i1, int i2) {
		
	}
}

public class BFS {

	public static void main(String[] args) {
		Queue myQ = new Queue();
		
		myQ.enqueue(new Integer(10));
		myQ.enqueue(new Integer(20));
		myQ.enqueue(new Integer(30));
		myQ.enqueue(new Integer(40));
		myQ.enqueue(new Integer(50));
		myQ.dequene();
		myQ.dequene();
		myQ.dequene();
		myQ.dequene();
		myQ.dequene();
		
		
		System.out.println(myQ.toString());
	}
	
}
