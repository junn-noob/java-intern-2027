package GiaiDoan1.day05;

public class SmartHomeController {
    private Switchable[] devices;

    public SmartHomeController(Switchable[] devices) {
        if (devices != null && devices.length > 0) {
            this.devices = devices.clone();
        } else {
            this.devices = new Switchable[0];
        }
    }

    public void leaveHome() {
        if (this.devices != null) {
            for (Switchable device : devices) {
                if (device != null) {
                    device.turnOff();
                }
            }
        }
    }

    public void arriveHome() {
        if (this.devices != null) {
            for (Switchable device : devices) {
                if (device != null) {
                    device.turnOn();
                }
            }
        }
    }
}
