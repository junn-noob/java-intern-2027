package GiaiDoan1.day05;

public class SmartLight implements Switchable, Dimmable {
    private int brightness;
    private boolean on;

    public SmartLight(boolean on, int brightness) {
        this.on = on;
        if (brightness < 0 || brightness > 100) this.brightness = 100;
        else this.brightness = brightness;
    }

    @Override
    public void setBrightness(int level) {
        if (level < 0 || level > 100) System.out.println("Do sang khong duoc am va khong qua 100%!");
        else this.brightness = level;
    }

    @Override
    public int getBrightness() {
        return this.brightness;
    }

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
