package giaidoan1.day01;

public class StockProfit {
    public static int maxProfit(int[] prices) {
        if (prices == null || prices.length == 0) {
            return 0;
        }

        int minPrice = prices[0];
        int bestProfit = 0;

        for (int i = 1; i < prices.length; i++) {
            minPrice = Math.min(minPrice, prices[i]);
            bestProfit = Math.max(bestProfit, prices[i] - minPrice);
        }

        return bestProfit;
    }
}
