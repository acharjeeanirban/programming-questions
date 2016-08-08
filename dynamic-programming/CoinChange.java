class CoinChange {

    public static int getCoinChange(int money, int change[], int index) {
        if (money == 0 && index == 0) {
            return 1;
        }
        if (money != 0 && index == 0) {
            return 0;
        }

        if (money < 0) {
            return 0;
        }

        return getCoinChange(money-change[index-1], change, index) + getCoinChange(money, change, index-1);
    }
	public static void main(String args[]) {
	    int change[] = {1,2};
        System.out.println(getCoinChange(4, change, change.length));
    }
}
