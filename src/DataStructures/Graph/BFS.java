package DataStructures.Graph;

import java.util.LinkedList;

class Stack {
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
//		else {
//			Node prev = null;
//			Node temp = head;
//			while (temp.next != null) {
//				prev = temp;
//				temp = temp.next;
//			}
//			
//			prev.next = null;
//			return temp.data;
//		}
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
		
		public String toString(){
			StringBuilder sb = new StringBuilder();
			sb.append(Integer.toString(this.data));
			sb.append(", ");
			sb.append(marked);
			sb.append(", ");
			sb.append(adjacent.toString());
			
			return sb.toString();
		}
	}
	
	public String toString(){
		StringBuilder sb = new StringBuilder();
		for (Node n : nodes) {
			sb.append(n.toString());
			sb.append("\n");
		}
		
		return sb.toString();
	}
	
	void addEdge(int i1, int i2) {
		Node n1 = nodes[i1];
		Node n2 = nodes[i2];
		
		if (!n1.adjacent.contains(n2)) {
			n1.adjacent.add(n2);
		}
		if (!n2.adjacent.contains(n1)) {
			n2.adjacent.add(n1);
		}
	}
	
	void dfs() {
		dfs(0);
	}
	
	void dfs(int index) {
		Node root = nodes[index];
		Stack stack = new Stack();
		stack.push(root);
		root.marked = true;
		
		while (!stack.isEmpty()) {
			Node r = (Node) stack.pop();
			for ( Node n : r.adjacent) {
				if (n.marked == false ) {
					n.marked = true;
					stack.push(n);
				}
			}
			visit(r);
		}
	}
	void bfs() {
		bfs(0);
	}
	
	void bfs(int index) {
		Node root = nodes[index];
		Queue queue = new Queue();
		queue.enqueue(root);
		root.marked = true;
		while ( !queue.isEmpty()) {
			//System.out.println(queue.toString());
			Node r = (Node) queue.dequene();
			for (Node n : r.adjacent) {
				if (n.marked == false) {
					n.marked = true;
					queue.enqueue(n);
				}
			}
			visit(r);
		}
	}
	
	void dfsR(Node r) {
		if (r == null)
			return;
		r.marked = true;
		visit(r);
		for (Node n : r.adjacent) {
			if (n.marked == false) {
				dfsR(n);
			}
		}
	}
	
	void dfsR(int index) {
		Node r = nodes[index];
		dfsR(r);
	}
	
	void dfsR() {
		dfsR(0);
	}
	
	void visit(Node n) {
		System.out.print(n.data + " ");
	}
}

public class BFS {

	public static void main(String[] args) {
		
		Stack myS = new Stack();
		
		myS.push(new Integer(10));
		myS.push(new Integer(20));
		myS.push(new Integer(30));
		myS.push(new Integer(40));
		myS.push(new Integer(50));
		System.out.println(myS.peek());
		myS.pop();
		myS.pop();
		myS.pop();
		myS.pop();
		myS.pop();
		
		System.out.println(myS.toString());
		
		Queue myQ = new Queue();
		
		myQ.enqueue(new Integer(10));
		myQ.enqueue(new Integer(20));
		myQ.enqueue(new Integer(30));
		myQ.enqueue(new Integer(40));
		myQ.enqueue(new Integer(50));
		myQ.dequene();
		myQ.dequene();

		
		System.out.println(myQ.toString());
		/* ============================
		    0
		   /
		  1 -- 3    7
		  |  / | \ /
		  | /  |  5
		  2 -- 4   \
		            6 - 8
		 bfs  0 1 2 3 4 5 6 7 8 
		 dfs  0 1 3 5 7 6 8 4 2
		 dfsR 0 1 2 4 3 5 6 8 7 
		 ==============================*/
		
		Graph g = new Graph(9);
		
		g.addEdge(0, 1);
		g.addEdge(1, 2);
		g.addEdge(1, 3);
		g.addEdge(2, 4);
		g.addEdge(2, 3);
		g.addEdge(3, 4);
		g.addEdge(3, 5);
		g.addEdge(5, 6);
		g.addEdge(5, 7);
		g.addEdge(6, 8);
		
		System.out.println(g.toString());
		
		//g.dfs();
		g.bfs();
		//g.dfsR();
	}
	
}
