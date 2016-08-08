class MergeSort {
	int arr[];
	int auxillary[];
	MergeSort(int arr[]) {
		this.arr = arr;
		this.auxillary = new int[arr.length];
	}
	public void doMergeSort(int low, int high) {
		if (low >= high) {
			return;
		}

		int mid = (low + high)/2;
		doMergeSort(low, mid);
		doMergeSort(mid+1, high);
		merge(low, mid, high);
	}

	public void merge(int low, int mid, int high) {
		int lowerLow = low;
		int lowerHigh = mid;
		int upperLow = mid+1;
		int upperHigh = high;

		int k = 0;
		int total = high-low+1;
		while (lowerLow <= lowerHigh && upperLow <= upperHigh) {
			if (arr[lowerLow] < arr[upperLow]) {
				auxillary[k++] = arr[lowerLow++];
			} else {
				auxillary[k++] = arr[upperLow++];
			}
		}

		while (lowerLow <= lowerHigh) {
			auxillary[k++] = arr[lowerLow++];
		}

		while (upperLow <= upperHigh) {
			auxillary[k++] = arr[upperLow++];	
		}

		for (int i = 0; i< total; i++) {
			arr[low+i] = auxillary[i];
		}

	}

	public void display() {
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + " ");
		}
		System.out.println();
	}
	public static void main(String[] args) {
		int arr1[] = {90,67, 89, 34, 91, 200, 707, 1000, 1, 8, 2};
		MergeSort mergeSort = new MergeSort(arr1);
		mergeSort.display();
		mergeSort.doMergeSort(0, arr1.length-1);
		mergeSort.display();
	}
}