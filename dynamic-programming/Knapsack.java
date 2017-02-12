import java.util.*;

class Knapsack {

	public static int getMaxValueR(int weights[], int values[], int n, int totalWeight) {


		if (totalWeight <= 0) {
			return 0;
		}

		if (n <= 0) {
			return 0;
		}

		if (weights[n-1] > totalWeight) {
			return getMaxValueR(weights, values, n-1, totalWeight);
		}

		return Math.max(values[n-1] + getMaxValueR(weights, values, n-1, totalWeight - weights[n-1]), getMaxValueR(weights, values, n-1, totalWeight));
		
	}

	public static Map<String, Integer> map = new HashMap<String, Integer>();

	public static int getMaxValueRSmart(int weights[], int values[], int n, int totalWeight) {
		if (totalWeight <= 0) {
			return 0;
		}

		if (n <= 0) {
			return 0;
		}

		String key = totalWeight + "totWeight:n" + n;

		if (map.containsKey(key)) {
			return map.get(key);
		}

		if (weights[n-1] > totalWeight) {
			int val = getMaxValueR(weights, values, n-1, totalWeight);
			map.put(key, val);
			return val;
		}

		int value = Math.max(values[n-1] + getMaxValueR(weights, values, n-1, totalWeight - weights[n-1]), getMaxValueR(weights, values, n-1, totalWeight));

		map.put(key, value);
		return value;
	}


	public static int getMaxValueI(int weights[], int values[], int n, int totalWeight) {

		int arr[][] = new int[n+1][totalWeight+1];

		for (int i = 0; i <= n; i++) {
			for (int j = 0; j <= totalWeight; j++) {
				if (i == 0 || j == 0) {
					arr[i][j] = 0;
				} else if (weights[i-1] > j) {
					arr[i][j] = arr[i-1][j-1];
				} else {
					arr[i][j] = Math.max((values[i-1] + arr[i-1][j - weights[i-1]]), arr[i-1][j-1]);
				}
			}
		}




		return arr[n][totalWeight];
	}

	public static void main(String[] args) {
		int val[] = {60, 100, 120};
		int wt[] = {10, 20, 30};
		int  W = 50;
		System.out.println(getMaxValueR(wt, val, val.length, W));
		System.out.println(getMaxValueRSmart(wt, val, val.length, W));
		System.out.println(getMaxValueI(wt, val, val.length, W));
	}
}