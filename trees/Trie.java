import java.util.*;

class TrieNode {
	char value;
	Map<Character, TrieNode> children = new HashMap<Character, TrieNode>();
	boolean isWord;

	TrieNode (char value, boolean isWord) {
		this.value = value;
		this.isWord = isWord;
	}

}

class Trie {
	TrieNode root;

	public void insert(String input) {
		if (root == null) {
			TrieNode node = new TrieNode('*', false);
			root = node;
		}
		boolean isWord = false;
		char arr[] = input.toCharArray();
		TrieNode current = root;
		for (int i = 0; i < arr.length; i++) {
			char c = arr[i];

			isWord = (i == arr.length -1);


			if (current.children.get(c) == null) {
				TrieNode newNode = new TrieNode(c, isWord);
				current.children.put(c, newNode);
			}

			current = current.children.get(c);
		}

		current.isWord = true;
	}

	public boolean find(String input) {
		TrieNode current = root;
		char arr[] = input.toCharArray();
		boolean found = false;

		for (int i = 0; i < arr.length; i++) {
			char c = arr[i];
			if (current.children.get(c) == null) {
				return false;
				
			} 
			current = current.children.get(c);
			
		}

		if (current.isWord) {
			return true;
		} 

		return false;

	}

	public static void main(String[] args) {
		Trie trie = new Trie();

		trie.insert("boy");
		
		trie.insert("books");

		trie.insert("book");

		if (trie.find("boo")) {
			System.out.println("found");
		} else {
			System.out.println("not found");
		}
	}

}