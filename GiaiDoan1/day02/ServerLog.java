package giaidoan1.day02;

public class ServerLog {
    private final String serverName;
    private double[] temperatures;

    public ServerLog(String serverName, double[] temperatures) {
        if (serverName != null && !serverName.trim().isEmpty()) {
            this.serverName = serverName;
        } else {
            this.serverName = "DEFAULT_SERVER";
        }

        if (temperatures == null || temperatures.length == 0) {
            this.temperatures = new double[0];
            return;
        }

        this.temperatures = new double[temperatures.length];
        for (int i = 0; i < temperatures.length; i++) {
            this.temperatures[i] = temperatures[i];
        }
    }

    public String getServerName() {
        return this.serverName;
    }

    public double[] getTemperatures() {
        double[] newTemperatures = new double[this.temperatures.length];
        for (int i = 0; i < this.temperatures.length; i++) {
            newTemperatures[i] = this.temperatures[i];
        }

        return newTemperatures;
    }

    public double getMaxTemperature() {
        if (this.temperatures == null || this.temperatures.length == 0) {
            return 0.0;
        }

        double maxTemperature = this.temperatures[0];
        for (int i = 1; i < this.temperatures.length; i++) {
            maxTemperature = Math.max(maxTemperature, this.temperatures[i]);
        }

        return maxTemperature;
    }
}
