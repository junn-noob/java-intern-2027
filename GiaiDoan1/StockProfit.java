package giaidoan1;

public class StockProfit {
    public static int maxProfit(int[] prices) {
        // Defensive check: mảng rỗng hoặc null thì lợi nhuận bằng 0
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