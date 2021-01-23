package DataStructures.Trees;

public class BSTRecursive2 {
	
	private Node root;
	
	BSTRecursive2() {
		root = null;
	}
	
	public static void main(String[] args) {
		BSTRecursive2 tree = new BSTRecursive2();
		tree.add(5);
		tree.add(10);
		tree.add(9);
		
		if (tree.find(4))
			System.out.println("find");
		else
			System.out.println("not found");
		
		print(tree);
		
		tree.remove(5);

		print(tree);
	
	}
	
	public static void print(BSTRecursive2 tree) {
		tree.preorder();
		tree.postorder();
		tree.inorder();
	}
	
	public void preorder() {
		System.out.println("PreOrder travelsal of this tree is :");
		preOrder(root);
		System.out.println();
	}
	
	private void preOrder(Node node) {
		if (node == null)
			return;
		System.out.print(node.data + " ");
		if (node.left != null)
			preOrder(node.left);
		if (node.right != null)
			preOrder(node.right);
	}
	
	public void postorder() {
		System.out.println("PostOrder travelsal of this tree is :");
		postOrder(root);
		System.out.println();
	}
	
	private void postOrder(Node node) {
		if (node == null)
			return;
		if (node.left != null)
			postOrder(node.left);
		if (node.right != null)
			postOrder(node.right);
		System.out.print(node.data +" ");
	}
	
	public void inorder() {
		System.out.println("InOrder travelsal of this tree is :");
		inOrder(root);
		System.out.println();
	}
	
	private void inOrder(Node node) {
		if (node == null)
			return;
		if (node.left != null)
			inOrder(node.left);
		System.out.print(node.data + " ");
		if (node.right != null)
			inOrder(node.right);
	}
	
	public void add(int data) {
		this.root = insert(root, data);
	}
	
	private Node insert(Node node, int data) {
		
		if (node == null) 
			node = new Node(data);
		else if (node.data > data)
			node.left = insert(node.left, data);
		else if (node.data < data)
			node.right = insert(node.right, data);
		return node;
	}
	
	public boolean find(int data) {
		return search(root, data);
	}
	
	private boolean search(Node node, int data) {
		
		if (node == null) 
			return false;
		else if (node.data > data)
			return search(node.left, data);
		else if (node.data < data)
			return search(node.right, data);
		else {
			return true;
		}
	}
	
	public void remove(int data) {
		root = delete(root, data); 
		// 반환 참조자를 root에 저장하지 않으면 실제 로직상 요소를 삭제하는게 아니라 요소를 가르키는 참조자를 없애는것이기 때문에 호출전 root가 계속 참조하고 있다. 반환하여 root 참조자를 갱신해준다면. 삭제된 요소는 아무 참조도 이루어지지 않기 떄문에 가비지컬렉션에 의해서 깨끗히 소거될 
	}
	
	private Node delete(Node node, int data) {
		if (node == null) {
			System.out.println("find not element");
		}
		else if (node.data > data) 
			node.left = delete(node.left, data);
		else if (node.data < data)
			node.right = delete(node.right, data);
		else {
			if (node.left == null && node.right == null) {
				node = null;
			}
			else if (node.left == null) {
				Node temp = node;
				node = null;
				node = temp.right;
			}
			else if (node.right == null) {
				Node temp = node;
				node = null;
				node = temp.left;
			}
			else {
				Node temp = node.right;
				while (temp.left != null)
					temp = temp.left;
				node.data = temp.data;
				node.right = delete(node.right, temp.data);
			}
			
		}
		return node;
	}
	
	
	
	static class Node {
		int data;
		Node left;
		Node right;
		
		Node(int data) {
			this.data = data;
			this.left = null;
			this.right = null;
		}
	}

}
