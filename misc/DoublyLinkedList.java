class Node {
	String key;
	String value;


	Node next;
	Node previous;


	Node (String key, String value) {
		this.key = key;
		this.value = value;
	}
}

class DoublyLinkedList {
	
	Node head;
	Node tail;

	public void addAtFront(String key , String value) {

		Node node = new Node(key, value);
		if (head == null) {
			head = node;
			tail = node;
			return;
		}

		head.previous = node;
		node.next = head;
		head = node;
	}


	public void addAtLast(String key, String value) {
		Node node = new Node(key, value);

		if (head == null) {
			head = node;
			tail = node;
			return;

		}


		tail.next = node;
		node.previous = tail;
		tail = node;
	}

	public String find(String key) {
		Node current = head;

		while (current != null) {
			if (current.key.equals(key)) {
				return current.value;
			}
			current = current.next;
		}

		return null;
	}


	public void remove(Node node) {
		if (head == node && tail == node) {
			head = null;
			tail = null;
			return;
		}

		if (head == node) {
			head = node.next;
			head.previous = null;
			return;
		}

		if (tail == node) {
			tail = node.previous;
			tail.next = null;
			return;
		}

		node.previous.next = node.next;
		node.next.previous = node.previous;

	}

	public String remove(String key) {

		Node current = head;

		while (current != null) {
			if (current.key.equals(key)) {
				remove(current);
			}
		}

		return current.value;

	}


	public static void main(String[] args) {
		String str = "hello";
		String str1 = "hello";

		System.out.println(str.hashCode());
		System.out.println(str1.hashCode());


		
	}

}