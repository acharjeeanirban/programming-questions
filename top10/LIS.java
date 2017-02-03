class LIS {
	public static void doLIS(int arr[]) {
		int lis[] = new int[arr.length];
		for (int i = 0; i < arr.length; i++) {
			lis[i] = 1;
		}

		for (int i = 1; i < arr.length; i++) {
			for (int j = 0; j < i; j++) {
				if (arr[i] > arr[j] && lis[i] < lis[j] + 1) {
					lis[i] = lis[j] + 1;
				}
			}
		}

		int max = lis[0];
		int index = -1;
		for (int i = 0; i < lis.length; i++) {
			if (lis[i] > max) {
				max = lis[i];
				index = i;
			}
		}
		System.out.println("size of lis : " + max);
		System.out.print(arr[index] + " ");
		int previous = index;
		for (int i = index-1; i >= 0; i--) {
			if (lis[previous] - lis[i] == 1) {
				System.out.print(arr[i] + " ");
				previous = i;
			}
		}
	}

	public static void main(String[] args) {
		int arr[] = {-9, 10, 2, 30, 8, -1, 40, 9, 70};
		doLIS(arr);
	}
}