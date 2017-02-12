class MinJumps {
	public static int getMinJumpsR(int arr[], int low, int high) {
		if (low == high) {
			return 0;
		}

		if (arr[low] == 0) {
			return Integer.MAX_VALUE;
		}

		int min = Integer.MAX_VALUE;
		for (int i = low + 1; i <= high && i <= low + arr[low]; i++) {
			int jumps = getMinJumpsR(arr, i, high);
			if (jumps != Integer.MAX_VALUE && jumps + 1 < min) {
				min = jumps + 1;
			} 
		}

		return min;

	}


	public static int getMinJumpsI(int arr[], int low, int high) {

		if (arr[0] == 0) {
			return Integer.MAX_VALUE;
		}

		int jumps[] = new int[arr.length];

		for (int i = 1; i <= high; i++) {
			jumps[i] = Integer.MAX_VALUE;
			for (int j = 0; j < i; j++) {
				if (i <= j + arr[j] && jumps[j] != Integer.MAX_VALUE) {
					jumps[i] = Math.min(jumps[i], 1 + jumps[j]);
					break;
				}
			}
		}

		return jumps[high];



	}
	public static void main(String[] args) {
		int arr[] = {1, 3, 6, 3, 2, 3, 6, 8, 9, 5};
		System.out.println(getMinJumpsR(arr, 0, arr.length -1));
		System.out.println(getMinJumpsI(arr, 0, arr.length -1));
	}
}