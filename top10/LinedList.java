class Node {
	int value;
	Node next;
	Node(int value) {
		this.value = value;
	}
}
class LinedList {
	Node head;
	public void add(int value) {
		Node node = new Node(value);
		if (head == null) {
			head = node;
			return;
		}

		Node current = head;
		while (current.next != null) {
			current = current.next;
		}

		current.next = node;
	}
	public void reverseI() {
		Node current = head;
		Node previous = null;
		Node next = null;
		while (current != null) {
			next = current.next;
			current.next = previous;
			previous = current;
			current = next;
		}

		head = previous;
	}

	public Node reverseR(Node node) {
		if (node == null) {
			return null;
		}

		if (node.next == null) {
			head = node;
			return node;
		}

		Node rest = reverseR(node.next);
		node.next = null;
		rest.next = node;
		return node;
	}

	public void display() {
		Node current = head;
		while (current != null) {
			System.out.print(current.value + " ");
			current = current.next;
		}
		System.out.println();
	}
	public static void main(String[] args) {
		LinedList linkedList = new LinedList();
		linkedList.add(10);
		linkedList.add(20);
		linkedList.add(30);
		linkedList.add(40);
		linkedList.add(50);
		linkedList.display();
		linkedList.reverseR(linkedList.head);
		linkedList.display();
		linkedList.reverseI();
		linkedList.display();

	}
}