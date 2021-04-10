package DataStructures.Graph;

import java.util.LinkedList;

class Graph2 {
	
	Node[] nodes;
	
	Graph2(int size) {
		nodes = new Node[size];
		for ( int i = 0; i < size; i++) {
			nodes[i] = new Node(i);
		}
	}
	
	class Node {
		private int data;
		private LinkedList<Node> adjacentNode;
		private boolean isVisited;
		
		Node(int data) {
			this.data = data;
			this.adjacentNode = new LinkedList<>();
			this.isVisited = false;
		}
	}
	
	public void addEdge(int l1, int l2) {
		
		if (!nodes[l1].adjacentNode.contains(nodes[l2])) {
			nodes[l1].adjacentNode.add(nodes[l2]);
		}
		if (!nodes[l2].adjacentNode.contains(nodes[l1])) {
			nodes[l2].adjacentNode.add(nodes[l1]);
		}
	}
	
	public void visit(Node n) {
		n.isVisited = true;
		System.out.print(n.data +" ");
	}
	
	public void bfs() {
		bfs(0);
	}
	
	public void bfs(int index) {
		Node root = nodes[index];
		Queue queue = new Queue();
		queue.enqueue(root);
		
		while (!queue.isEmpty()) {
			Node temp = (Node) queue.dequene();
			if (temp.isVisited == false) {
				visit(temp);
			}
			
			for (Node n : temp.adjacentNode) {
				if (!n.isVisited) {
					queue.enqueue(n);
				}
			}
		}
	}
	
	public void dfs() {
		dfs(0);
	}
	
	public void dfs(int index) {
		Node root = nodes[index];
		
		Stack stack = new Stack();
		stack.push(root);
		
		while (!stack.isEmpty()) {
			Node temp = (Node) stack.pop();
			if (temp.isVisited == false) {
				visit(temp);
			}
			
			for (Node n : temp.adjacentNode) {
				if (!n.isVisited) {
					stack.push(n);
				}
			}
		}
		
	}
	
	
	
}
public class GraphTraversal {

	public static void main(String[] args) {
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
	
	Graph2 g = new Graph2(9);
	
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
	
	//System.out.println(g.toString());
	
	//g.dfs();
	g.bfs();
	//g.dfsR();

	}

}
