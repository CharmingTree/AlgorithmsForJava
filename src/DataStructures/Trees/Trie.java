package DataStructures.Trees;

import java.util.Scanner;

public class Trie {
	
	public class TrieNode {
		TrieNode[] child;
		boolean end;
		
		public TrieNode() {
			this.child = new TrieNode[26];
			this.end = false;
		}
	}
	
	private final TrieNode root;
	
	public Trie() {
		this.root = new TrieNode();
	}
	
	
	// coffee
	public void insert(String word) {
		TrieNode currentNode = root;
		for ( int i = 0; i < word.length(); i++) {
			TrieNode node = currentNode.child[word.charAt(i) - 'a'];
			if (node == null) {
				node = new TrieNode();
				currentNode.child[word.charAt(i) - 'a'] = node;
			}
			currentNode = node;
		}
		currentNode.end = true;
	}
	
	public boolean search(String word) {
		TrieNode currentNode = root;
		for ( int i = 0; i < word.length(); i++) {
			char ch = word.charAt(i);
			TrieNode node = currentNode.child[ch - 'a'];
			if ( node == null) {
				return false;
			}
			currentNode = node;
		}
		return currentNode.end;
	}
	
	public boolean delete(String word) {
		TrieNode currentNode = root;
		for (int i = 0; i < word.length(); i++) {
			char ch = word.charAt(i);
			TrieNode node = currentNode.child[ch - 'a'];
			if (node == null) {
				return false;
			}
			currentNode = node;
		}
		if (currentNode.end == false) {
			currentNode.end = false;
			return true;
		}
		return false;
	}
	
	public static void sop(String print) {
		System.out.println(print);
	}
	
	public static boolean isValid(String word) {
		return word.matches("^[a-z]+$");
	}
	
	public static void printTrie(TrieNode n) {
		StringBuilder sb = new StringBuilder();
		
		for (int i = 0; i < n.child.length; i++) {
			if (n.child[i] != null) {
				char t = (char)('a' + i);
				sb.append(t);
				printTrie(n.child[i]);
			}
		}
		System.out.println(sb.toString());
		
	}
	
	public static void main(String[] args) {
		Trie obj = new Trie();
		String word; 
		
		Scanner scan = new Scanner(System.in);
		
		while (true) {
			sop("1. Insert\n2. Search\n3. Delete\n4. Quit");
			try {
				int t = scan.nextInt();
				
				switch (t) {
					case 1:
						word = scan.next();
						if (isValid(word))	obj.insert(word);
						else	sop("Invalid string: allowed only a-z");
						printTrie(obj.root);
						break;
					case 2:
						word = scan.next();
						boolean resS = false;
						if (isValid(word))	resS = obj.search(word);
						else	sop("Invalid string: allowed only a-z");
						if (resS)	sop("word found");
						else	sop("word not found");
						break;
					case 3:
						word = scan.next();
						boolean resD = false;
						if (isValid(word)) resD = obj.delete(word);
						else	sop("Invalid String: allowed only a-z");
						if (resD) {
							sop("word got deleted successfully");
						}
						else {
							sop("word not found");
						}
						break;
					case 4:
						sop("Quit successfully");
						System.exit(1);
						break;
					default:
						sop("Input int from 1=4");
						break;
				}
			}
			catch(Exception e) {
				String badInput = scan.next();
				sop("This is bad input : " + badInput);
			}
		}
	}
}
