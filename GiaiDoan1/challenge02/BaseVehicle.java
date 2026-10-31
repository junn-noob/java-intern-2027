package GiaiDoan1.challenge02;

public abstract class BaseVehicle {
    private String licensePlate;
    private double registeredWeight;

    public BaseVehicle(String licensePlate, double registeredWeight) {
        if (licensePlate != null) this.licensePlate = licensePlate;
        else this.licensePlate = "UNKNOWN";

        if (registeredWeight > 0) this.registeredWeight = registeredWeight;
        else this.registeredWeight = 1.5;
    }

    public String getLicensePlate() {
        return licensePlate;
    }

    public double getRegisteredWeight() {
        return registeredWeight;
    }

    public abstract double calculateBaseToll();
}
