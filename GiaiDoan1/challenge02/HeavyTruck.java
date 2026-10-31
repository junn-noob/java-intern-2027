package GiaiDoan1.challenge02;

public class HeavyTruck extends BaseVehicle implements TollPayable, RFIDReadable {
    private String tagId;
    private boolean tagActive;
    private String accountId;
    private double balance;
    private double actualWeight;

    public HeavyTruck(String licensePlate, double registeredWeight, String tagId, boolean tagActive, String accountId, double balance, double actualWeight) {
        super(licensePlate, registeredWeight);
        this.tagId = tagId;
        this.tagActive = tagActive;
        this.accountId = accountId;
        this.balance = balance;
        this.actualWeight = actualWeight;
    }


    @Override
    public double calculateBaseToll() {
        double baseFee = (this.actualWeight <= 5.0) ? 50_000 : 50_000 + (this.actualWeight - 5.0) * 5_000;
        if (this.actualWeight > this.getRegisteredWeight()) {
            baseFee *= 2; // Phạt thêm 100% phí gốc
        }
        return baseFee;
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
