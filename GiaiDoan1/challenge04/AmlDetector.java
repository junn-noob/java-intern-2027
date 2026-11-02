package GiaiDoan1.challenge04;

public class AmlDetector {
    public static double[] findFraudulentTriplet(double[] sortedTransactions, double target) {
        if (sortedTransactions == null || sortedTransactions.length < 3) return new double[0];

        for (int i = 1; i < sortedTransactions.length - 1; i++) {
            int l = 0, r = sortedTransactions.length - 1;
            double tempTarget = target - sortedTransactions[i];
            while (l < i && r > i) {
                if (sortedTransactions[l] + sortedTransactions[r] == tempTarget) return new double[] {sortedTransactions[l], sortedTransactions[i], sortedTransactions[r]};
                else if (sortedTransactions[l] + sortedTransactions[r] > tempTarget) r--;
                else l++;
            }
        }

        return new double[0];
    }
}
