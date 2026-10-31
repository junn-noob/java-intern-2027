package GiaiDoan1.challenge02;

public class Ambulance extends BaseVehicle implements EmergencyVehicle {
    public Ambulance(String licensePlate, double registeredWeight) {
        super(licensePlate, registeredWeight);
    }

    @Override
    public double calculateBaseToll() {
        return 0;
    }


    @Override
    public boolean isEmergency() {
        return true;
    }
}
