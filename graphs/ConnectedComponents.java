import java.util.*;

class ConnectedComponents {
	public List<Integer> getConnectedComponents(int arr[][]) {
		boolean visited[][] = new boolean[arr.length][arr[0].length];
		List<Integer> list = new ArrayList<Integer>();
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr[0].length; j++) {
				if (arr[i][j] == 1) {
					int size = getSize(arr, visited, i, j);
					if (size != 0) {
						list.add(size);
					}
				}
			}
		}
		return list;
	}

	public int getSize(int arr[][], boolean visited[][], int i, int j) {
		if (i < 0 || j < 0 || i >= arr.length || j >= arr[0].length || arr[i][j] != 1 || visited[i][j]) {
			return 0;
		}

		int size = 1;
		visited[i][j] = true;
		for (int k = -1; k <= 1; k++) {
			for (int l = -1; l <= 1; l++) {
				size += getSize(arr, visited, i+k, j + l);
			}
		}

		return size;
	}

	public static void main(String[] args) {
		int arr[][] = {{1,0,1,0},
					   {1,0,1,0},
						{1,0,0,0},
						{0,0,0,0},
						{1,1,1,1}};

		ConnectedComponents cc = new ConnectedComponents();

		System.out.println(cc.getConnectedComponents(arr));

	}
}