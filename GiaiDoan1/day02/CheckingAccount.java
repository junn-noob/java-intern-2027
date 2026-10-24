package giaidoan1.day02;

import giaidoan1.day01.BankAccount;

public class CheckingAccount extends BankAccount {
    private final double overdraftLimit;
    private static final double TRANSACTION_FEE = 5_000;

    public CheckingAccount(String accountNumber, String ownerName, double initialBalance, double overdraftLimit) {
        super(accountNumber, ownerName, initialBalance);

        if (overdraftLimit > 0) {
            this.overdraftLimit = overdraftLimit;
        } else {
            this.overdraftLimit = 0.0;
        }
    }

    @Override
    public boolean canWithdraw(double amount) {
        // Điều kiện: tiền rút phải dương và không vượt quá (số dư + hạn mức thấu chi)
        return amount > 0 && (this.getBalance() + this.overdraftLimit >= amount);
    }

    @Override
    public void withdraw(double amount) {
        // Số tiền thật sự trừ khỏi tài khoản = tiền rút + phí 5.000 VNĐ
        double totalDeduction = amount + TRANSACTION_FEE;
        if (canWithdraw(totalDeduction)) {
            super.withdraw(totalDeduction);
        }
    }

    public double getOverdraftLimit() {
        return this.overdraftLimit;
    }
}