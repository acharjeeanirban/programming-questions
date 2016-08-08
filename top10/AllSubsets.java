import java.util.*;
class AllSubsets {
	public static ArrayList<ArrayList<Integer>> getAllSubsets(ArrayList<Integer> list) {
		ArrayList<ArrayList<Integer>> finalList = new ArrayList<ArrayList<Integer>>();
		if (list.isEmpty()) {
			finalList.add(new ArrayList<Integer>());
			return finalList;
		}

		ArrayList<Integer> clonedList = (ArrayList<Integer>)list.clone();
		int first = clonedList.remove(0);
		ArrayList<ArrayList<Integer>> smallerSet = getAllSubsets(clonedList);
		ArrayList<ArrayList<Integer>> biggerSet = getAllSubsets(clonedList);
		finalList.addAll(smallerSet);
		for (ArrayList<Integer> lst : biggerSet) {
			lst.add(first);
		}
		finalList.addAll(biggerSet);
		return finalList;

	}
	public static void main(String[] args) {
		ArrayList<Integer> list = new ArrayList<Integer>();
		list.add(1);
		list.add(2);
		list.add(3);
		System.out.println(getAllSubsets(list));
	}
}