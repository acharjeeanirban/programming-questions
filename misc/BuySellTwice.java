class BuySellTwice {
	public static int getMaxProfit(int arr[]) {
		int maxprofit = 0;
		for (int i = 0; i < arr.length; i++) {

			int a = arr[i];

			int buyLow = Integer.MAX_VALUE;
			int sellLow = Integer.MAX_VALUE;

			//System.out.println(buyLow);

			for (int j = 0; j <= i; j++) {
				if (arr[j] < buyLow) {
					buyLow = arr[j];
				} else {
					sellLow = arr[j];
				}
			}

			int buyHigh = Integer.MAX_VALUE;
			int sellHigh = Integer.MAX_VALUE;
			
			for (int k = i+1; k < arr.length; k++) {
				if (arr[k] < buyHigh) {
					buyHigh = arr[k];
				} else {
					sellHigh = arr[k];
				}
			}

			int lowProfit = 0;
			if (buyLow != Integer.MAX_VALUE && sellLow != Integer.MAX_VALUE) {
				lowProfit = sellLow - buyLow;
			}


			int highProfit = 0;
			if (buyHigh != Integer.MAX_VALUE && sellHigh != Integer.MAX_VALUE) {
				highProfit = sellHigh - buyHigh;
			}

			if (maxprofit < (lowProfit + highProfit)) {
				maxprofit = lowProfit + highProfit;
			}

			System.out.println(maxprofit);


		}


		return maxprofit;
	}
	public static void main(String[] args) {
		int price[] = {90, 80, 70, 60, 50};

		System.out.println(" ---- "  + getMaxProfit(price));


	}
}