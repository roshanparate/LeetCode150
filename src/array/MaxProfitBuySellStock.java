package array;

public class MaxProfitBuySellStock {
    public static void main(String[] args) {
        int[] arr = new int[]{7,1,5,3,6,4};
        System.out.println(maxProfit(arr));
    }
    public static int maxProfit(int[] prices) {

        if(prices.length <=1 ) return 0;

        int maxPro = Integer.MIN_VALUE;
        int min = prices[0];
        for(int i = 1; i< prices.length; i++){

            min = Math.min(min, prices[i]);

            int profit =  prices[i] - min;
            maxPro = Math.max(maxPro, profit);

        }
        return maxPro;

    }
}
