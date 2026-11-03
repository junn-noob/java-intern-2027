package GiaiDoan1.challenge04;

public class TransferService {
    public boolean transfer(BaseAccount sourceAccount, BaseAccount targetAccount, double amount) {
        if (sourceAccount == null || targetAccount == null || sourceAccount == targetAccount) return false;

        if (!sourceAccount.canTransfer(amount)) return false;

        return sourceAccount.transfer(amount) && targetAccount.deposit(amount);
    }
}
