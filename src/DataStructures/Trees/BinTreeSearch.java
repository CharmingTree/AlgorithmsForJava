package DataStructures.Trees;

import java.util.ArrayList;

public class BinTreeSearch {
	
	private Node root;
	
	public BinTreeSearch() {
		this.root = null;
	}
	
	public BinTreeSearch(int data) {
		this.root = new Node(data);
	}
	
	private static class Node {
		
		private int data;
		private Node left;
		private Node right;
		private Node parent;
		
		Node(int data) {
			this.data = data;
			this.parent = null;
			this.left = null;
			this.right = null;
		}
		
		Node(int data, Node parent) {
			this.data = data;
			this.parent = parent;
			this.left = null;
			this.right = null;
		}
		
		public String toString() {
			if (this.left == null && this.right == null)
				return Integer.toString(this.data);
			else {
				StringBuilder builder = new StringBuilder();
				builder.append(String.format("{%d : (%d, %d)}", this.data, this.left.data, this.right.data));
				return builder.toString();
			}
				
		}
	}

	public String toString() {
		return this.root.toString();
	}
	
	private void reassignNode(Node node, Node newChild) {
		if (newChild != null) {
			newChild.parent = node.parent;
		}
		if (node.parent != null) {
			if (isRight(node)) {
				node.parent.right = newChild;
			}
			else {
				node.parent.left = newChild;
			}
		}
		else {
			this.root = newChild;
		}
	}
	
	private boolean isRight(Node node) {
		return node == node.parent.right;
	}
	
	public boolean isEmpty() {
		return this.root == null ? true : false;
	}
	
	/* 삽입 */
	private void _insert(int value) {
		Node newNode = new Node(value, null);
		
		/* 처음 삽입은 루트 */
		if (this.isEmpty()) {
			this.root = newNode;
		}
		else {
			Node parent = root;
			while (true) {
				// 현재 부모 값보다 작다면 left
				if (value < parent.data) {
					if (parent.left == null) {
						parent.left = newNode;
						break;
					}
					else {
						parent = parent.left;
					}
				}
				// 현재 부모 값보다 크다면 right
				else {
					if (parent.right == null) {
						parent.right = newNode;
						break;
					}
					else {
						parent = parent.right;
					}
				}
			}
			// 삽입된 부모 지정
			newNode.parent = parent;
		}
	}
	
	public void insert(int ...values) {
		for (int i : values) {
			_insert(i);
		}
	}
	
	public Node search(int value) {
		if ( this.isEmpty()) {
			throw new IndexOutOfBoundsException();
		}
		else {
			Node node = this.root;
			
			while ( node != null && node.data != value) {
				node = node.data < value ? node.left : node.right;
			}
			return node;
		}
	}
	
	public Node getMax() {
		if (!isEmpty()) {
			Node node = this.root;
			while (node.right != null) 
				node = node.right;
			return node;
		}
		else
			return null;
	}
	
	public Node getMax(Node node) {
		Node temp = node;
		if (temp != null) {
			while (temp.right != null)
				temp = temp.right;
			return temp;
		}
		else
			return null;
	}
	
	public Node getMin() {
		if (!isEmpty()) {
			Node node = this.root;
			while ( node.left != null)
				node = node.left;
			return node;
		}
		else
			return null;
	}
	
	public Node getMin(Node node) {
		Node temp = node;
		if (temp != null) {
			while (temp.left != null) {
				temp = temp.left;
			}
			return temp;
		}
		else
			return null;
	}
	
	public void remove(int value) {
		Node node = this.search(value);
		
		if (node != null) {
			if (node.left == null && node.right == null) {
				reassignNode(node, null);
			}
			else if (node.left == null) {
				reassignNode(node, node.right);
			}
			else if (node.right == null) {
				reassignNode(node, node.left);
			}
			else {
				Node temp = getMax(node.left);
				
				remove(temp.data);
				
				node.data = temp.data;
			}
		}
	}
	
	public void preOrder(Node node) {
		if (node != null) {
			System.out.print(node.data+" >>> ");
			preOrder(node.left);
			preOrder(node.right);
		}
	}
	
	public void inOrder(ArrayList<Integer> arr, Node node) {
		if (node != null) {
			inOrder(arr, node.left);
			arr.add(node.data);
			inOrder(arr, node.right);
		}
	}
	
	public void postOrder(ArrayList<Integer> arr, Node node) {
		if (node != null) {
			postOrder(arr, node.left);
			postOrder(arr, node.right);
			arr.add(node.data);
		}
	}
	
	public static void main(String[] args) {

		int[] testlist = {8, 3, 6, 1, 10, 14, 13, 4, 7};
		
		BinTreeSearch t = new BinTreeSearch();
		
		for (int i : testlist) {
			t.insert(i);
		}
		
		ArrayList<Integer> inArr = new ArrayList<>();
		ArrayList<Integer> postArr = new ArrayList<>();
		
		t.inOrder(inArr, t.root);
		t.postOrder(postArr, t.root);
		
		System.out.println(inArr);
		System.out.println(postArr);
		t.preOrder(t.root);
	}
}
