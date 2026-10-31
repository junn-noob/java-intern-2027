package GiaiDoan1.challenge02;

public interface TollPayable {
    boolean deductFee(double fee);
    double getBalance();
    String getAccountId();
}
