package GiaiDoan1.day05;

public class SmartPlug implements Switchable {
    private boolean on;

    @Override
    public void turnOn() {
        this.on = true;
    }

    @Override
    public void turnOff() {
        this.on = false;
    }

    @Override
    public boolean isOn() {
        return this.on;
    }
}
