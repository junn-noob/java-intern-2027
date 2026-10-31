package GiaiDoan1.challenge01;

public class TransactionAuditor {
    public static double[] findSuspiciousPair(double[] sortedTransactions, double target) {
        if (sortedTransactions == null || sortedTransactions.length < 2) return new double[0];

        double minDiff = Double.MAX_VALUE;
        double bestLeftVal = 0, bestRightVal = 0;

        int left = 0, right = sortedTransactions.length - 1;
        while (left < right) {
            double currentSum = sortedTransactions[left] + sortedTransactions[right];
            double currentDiff = Math.abs(currentSum - target);

            // Nếu tìm thấy cặp có khoảng cách gần hơn kỷ lục cũ -> Cập nhật kỷ lục
            if (currentDiff < minDiff) {
                minDiff = currentDiff;
                bestLeftVal = sortedTransactions[left];
                bestRightVal = sortedTransactions[right];
            }

            // Nếu đã trúng phóc target (khoảng cách = 0) -> Dừng luôn không cần tìm nữa
            if (currentSum == target) {
                break;
            } else if (currentSum > target) {
                right--;
            } else {
                left++;
            }
        }

        return new double[] { bestLeftVal, bestRightVal };
    }
}
