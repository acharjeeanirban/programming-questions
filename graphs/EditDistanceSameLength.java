import java.util.*;

class EditDistanceSameLength {


	public List<String> getPath(String source, String destination, Set<String> dictionary) {

		Set<String> visited = new HashSet<String>();
		LinkedList<String> queue = new LinkedList<String>();
		Map<String, String> map = new HashMap<String, String>();
		List<String> path = new ArrayList<String>();

		visited.add(source);
		queue.offer(source);

		while (!queue.isEmpty()) {
			String node = queue.poll();

			System.out.println(node);

			for (String str : getAdjList(node, dictionary)) {
				if (visited.add(str)) {
					queue.add(str);
					map.put(str, node);

					if (str.equals(destination)) {

						path.add(str);
						while (map.get(str) != null) {
							path.add(0, map.get(str));
							str = map.get(str);
						}
					} 
				}

			}
		}

		return path;

	}

	private Set<String> getAdjList(String node, Set<String> dictionary) {
		Set<String> set = new HashSet<String>();
		char arr[] = node.toCharArray();
		for (int i = 0; i < arr.length; i++) {
			for (char c = 'a'; c <= 'z'; c++) {
				if (arr[i] != c) {
					char temp[] = node.toCharArray();
					temp[i] = c;
					if (dictionary.contains(new String(temp))) {
						set.add(new String(temp));	
					}
					
				}
			}
		}

		return set;
	}

	public static void main(String[] args) {
		EditDistanceSameLength editDistanceSameLength = new EditDistanceSameLength();
		Set<String> dictionary = new HashSet<String>();
		dictionary.add("head");
		dictionary.add("heal");
		dictionary.add("teal");
		dictionary.add("tell");
		dictionary.add("tall");
		dictionary.add("tail");
		System.out.println(editDistanceSameLength.getPath("head", "tail", dictionary));
	}
}