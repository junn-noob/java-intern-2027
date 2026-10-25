package giaidoan1.review01;

public class OrderUtils {
    public static void removeCancelledItems(double[] prices) {
        int k = 0;
        for (int i = 0; i< prices.length; i++) {
            if (prices[i] != 0) {
                prices[k] = prices[i];
                k++;
            }
        }

        for (int i = k; i < prices.length; i++) prices[i] = 0;
    }
}