package GiaiDoan1.challenge01;

public interface Payable {
    boolean pay(double amount);
    double getBalance();
    String getAccountId();
}
