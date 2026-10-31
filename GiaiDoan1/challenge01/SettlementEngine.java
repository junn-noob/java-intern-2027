package GiaiDoan1.challenge01;

public class SettlementEngine {
    private Payable[] accounts;

    public SettlementEngine(Payable[] accounts) {
        if (accounts != null && accounts.length > 0) this.accounts = accounts.clone();
        else this.accounts = new Payable[0];
    }

    public int processBatchPayment(double amount) {
        int success = 0;
        if (this.accounts == null || this.accounts.length <= 0) return success;
        else
            for (Payable account : accounts) {
                if (account != null && account.pay(amount)) {
                    success++;
                }
            }
        return success;
    }
}
