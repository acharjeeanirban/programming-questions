class HashMap {
	DoublyLinkedList arr[];
	int size;

	public HashMap(int size) {
		arr = new DoublyLinkedList[size];
		this.size = size
	}


	public void put(String key, String value) {
		int position = hashcode(key);
		if (arr[position] == null) {
			arr[position] = new DoublyLinkedList();
			arr[position].addAtLast(key, value);
		} else {
			arr[position].addAtLast(key, value);
		}
	}

	public String get(String key) {
		int position = hashcode(key);

		if (arr[position] == null) {
			return null;
		}

		DoublyLinkedList dll = arr[position];
		return dll.find(key);
		
	}


	public String delete(String key) {
		int position = hashcode(key);

		if (arr[position] == null) {
			return null;
		}

		DoublyLinkedList dll = arr[position];
		dll.remove(key);

	}


	public int hashcode(String key) {
		return (key.length()%size);
	}


	public static void main(String[] args) {
		HashMap map = new HashMap(10);
		map.put("abc", "1");
		map.put("abd", "2");
		map.put("efy", "3");
		map.put("efgh", "4")
	}
}