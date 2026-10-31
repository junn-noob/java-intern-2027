package GiaiDoan1.challenge02;

public class TollBoothController {
    private BaseVehicle[] waitingQueue;

    public TollBoothController(BaseVehicle[] waitingQueue) {
        if (waitingQueue != null && waitingQueue.length > 0) this.waitingQueue = waitingQueue.clone();
        else this.waitingQueue = new BaseVehicle[0];
    }

    private boolean canPass(BaseVehicle vehicle) {
        if (vehicle == null) return false;

        if (vehicle instanceof EmergencyVehicle) return true;

        if (!(vehicle instanceof RFIDReadable)) return false;
        RFIDReadable rfid = (RFIDReadable) vehicle;
        if (!rfid.isTagActive()) return false;

        if (!(vehicle instanceof TollPayable)) return false;
        TollPayable payable = (TollPayable) vehicle;
        return payable.deductFee(vehicle.calculateBaseToll());
    }

    public int openBarrierForQueue() {
        if (this.waitingQueue == null || waitingQueue.length <= 0) return 0;
        int success = 0;
        for (BaseVehicle vehicle : waitingQueue) {
            if (this.canPass(vehicle)) success++;
        }

        return success;
    }
}
