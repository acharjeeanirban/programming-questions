class Kadane {
	public static int getKadane(int arr[]) {
		int maxTillNow = 0;
		int sumtillNow = 0;
		int leastNeg = arr[0];
		boolean allNeg = true;
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] < 0) {
				if (arr[i] > leastNeg) {
					leastNeg = arr[i];
				}
			} else {
				allNeg = false;
				break;
			}
		}

		if (allNeg) {
			return leastNeg;
		}

		for (int i = 0; i < arr.length; i++) {
			maxTillNow += arr[i];
			if (maxTillNow < 0) {
				maxTillNow = 0;
			} else if (maxTillNow > sumtillNow) {
				sumtillNow = maxTillNow;
			}
		}

		return sumtillNow;
	}
	
	public static void main(String[] args) {
		//int arr[] = {-2,-3,-5,1,2,312,-100,2,3,5};
		int arr[] = {-2,-3,-5,-1,-2,-312,-100,-2,-3,-5};
		System.out.println(getKadane(arr));
	}
}