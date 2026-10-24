package giaidoan1.day02;

public class Main {
    public static void main(String[] args) {
        System.out.println("==================================================");
        System.out.println("            TEST DAY 02: SERVER LOG               ");
        System.out.println("==================================================");

        double[] originalTemps = { 24.5, 26.0, 28.5 };
        ServerLog log = new ServerLog("Server-Hanoi-01", originalTemps);
        System.out.println("Server: " + log.getServerName());
        System.out.println("Nhiệt độ cao nhất ban đầu: " + log.getMaxTemperature() + " °C");

        System.out.println("\n[ATTACK 1] Hacker sửa mảng ban đầu: originalTemps[0] = 999.0");
        originalTemps[0] = 999.0;
        System.out.println("-> Nhiệt độ cao nhất trong ServerLog: " + log.getMaxTemperature() + " °C");
        if (log.getMaxTemperature() == 999.0) {
            System.out.println("❌ BỊ HACK CỬA VÀO!");
        } else {
            System.out.println("✅ THÀNH CÔNG! Cửa vào được bảo vệ!");
        }

        System.out.println("\n[ATTACK 2] Hacker sửa qua getTemperatures()");
        double[] stolenTemps = log.getTemperatures();
        stolenTemps[1] = 888.0;
        System.out.println("-> Nhiệt độ cao nhất trong ServerLog: " + log.getMaxTemperature() + " °C");
        if (log.getMaxTemperature() == 888.0) {
            System.out.println("❌ BỊ HACK CỬA RA!");
        } else {
            System.out.println("✅ THÀNH CÔNG! Cửa ra được bảo vệ!");
        }

        System.out.println("\n[EDGE CASE] Kiểm thử mảng null:");
        ServerLog emptyLog = new ServerLog(null, null);
        System.out.println("Tên mặc định: " + emptyLog.getServerName());
        System.out.println("Nhiệt độ mảng null: " + emptyLog.getMaxTemperature() + " °C");
    }
}
