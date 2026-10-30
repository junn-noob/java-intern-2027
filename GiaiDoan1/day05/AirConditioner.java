package GiaiDoan1.day05;

public class AirConditioner implements Switchable, Thermostat {
    private int temperature;
    private boolean on;

    public AirConditioner(int temperature, boolean on) {
        if (temperature >= 16 && temperature <= 30) this.temperature = temperature;
        else this.temperature = 24;

        this.on = on;
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

    @Override
    public void setTemperature(int temp) {
        if (temp >= 16 && temp <= 30) this.temperature = temp;
        else System.out.println("Nhiet do phai trong khoang 16 - 30 do C!");
    }

    @Override
    public int getTemperature() {
        return this.temperature;
    }
}
