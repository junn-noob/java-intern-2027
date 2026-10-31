package GiaiDoan1.challenge02;

public class StandardCar extends BaseVehicle implements TollPayable, RFIDReadable {
    private String accountId;
    private double balance;
    private String tagId;
    private boolean tagActive;

    public StandardCar(String licensePlate, double registeredWeight, String accountId, double balance, String tagId, boolean tagActive) {
        super(licensePlate, registeredWeight);
        this.accountId = accountId;
        this.balance = balance;
        this.tagId = tagId;
        this.tagActive = tagActive;
    }

    @Override
    public double calculateBaseToll() {
        return 35_000;
    }

    @Override
    public String getTagId() {
        return this.tagId;
    }

    @Override
    public boolean isTagActive() {
        return this.tagActive;
    }

    @Override
    public boolean deductFee(double fee) {
        if (fee > 0 && this.balance >= fee) {
            this.balance -= fee;
            return true;
        }

        return false;
    }

    @Override
    public double getBalance() {
        return this.balance;
    }

    @Override
    public String getAccountId() {
        return this.accountId;
    }
}
