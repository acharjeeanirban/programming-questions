import java.util.*;

class TreeNode {
	int value;
	TreeNode left;
	TreeNode right;
	TreeNode(int value) {
		this.value = value;
	}

	public String toString() {
		return Integer.toString(value);
	}
}

class Tree {

	TreeNode root;

	public void insert(int value) {
		TreeNode node = new TreeNode(value);
		if (root == null) {
			root = node;
			return;
		}

		boolean isLeftChild = false;
		TreeNode parent = root;
		TreeNode current = root;
		while (current != null) {
			parent = current;
			if (value < current.value) {
				isLeftChild = true;
				current = current.left;
			} else {
				isLeftChild = false;
				current = current.right;
			}
		}

		if (isLeftChild) {
			parent.left = node;
		} else {
			parent.right = node;
		}

	}

	public void inorder(TreeNode node) {
		if (node != null) {
			inorder(node.left);
			System.out.print(node.value + " ");
			inorder(node.right);
		}
	}

	public int getHeight(TreeNode node) {
		if (node == null) {
			return 0;
		}

		return 1+Math.max(getHeight(node.left), getHeight(node.right));
	}

	public boolean isBalanced(TreeNode node) {
		if (node == null) {
			return true;
		}

		int leftHeight = getHeight(node.left);
		int rightHeight = getHeight(node.right);
		if (Math.abs(leftHeight-rightHeight) <= 1 && isBalanced(node.left) && isBalanced(node.right)) {
			return true;
		} else {
			return false;
		}
	}

	public void printLevelOrder() {
		TreeNode current = root;
		ArrayList<ArrayList<TreeNode>> list = new ArrayList<ArrayList<TreeNode>>();
		ArrayList<TreeNode> first = new ArrayList<TreeNode>();
		first.add(current);
		list.add(first);
		int level = 0;
		while (true) {
			ArrayList<TreeNode> inner = new ArrayList<TreeNode>();
			for (TreeNode node : list.get(level)) {
				if (node.left != null) {
					inner.add(node.left);
				}

				if (node.right != null) {
					inner.add(node.right);
				}
			}

			if (inner.isEmpty()) {
				break;
			} else {
				list.add(++level, inner);
			}
		}

		System.out.println(list);
	}

	public static void main(String[] args) {
		Tree tree = new Tree();
		tree.insert(100);
		tree.insert(150);
		tree.insert(200);
		tree.insert(50);
		tree.insert(80);
		tree.insert(85);
		tree.insert(95);
		tree.inorder(tree.root);
		System.out.println();
		tree.printLevelOrder();
		if (tree.isBalanced(tree.root)) {
			System.out.println("Balanced");
		} else {
			System.out.println("Not Balanced");
		}

	}
}