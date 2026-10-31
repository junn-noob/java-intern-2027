package GiaiDoan1.day05;

public class Main {
    public static void main(String[] args) {
        System.out.println("==================================================");
        System.out.println("   TEST 1: INTERFACE SEGREGATION PRINCIPLE (ISP)  ");
        System.out.println("==================================================");
        SmartLight light = new SmartLight(false, 80);
        AirConditioner ac = new AirConditioner(26, false);
        SmartPlug plug = new SmartPlug();

        // Kiểm tra năng lực riêng biệt (Role Interfaces)
        light.setBrightness(50);
        System.out.println("SmartLight brightness: " + light.getBrightness() + "% (Kỳ vọng: 50) -> " 
            + (light.getBrightness() == 50 ? "✅ PASS" : "❌ FAIL"));

        ac.setTemperature(20);
        System.out.println("AirConditioner temperature: " + ac.getTemperature() + "C (Kỳ vọng: 20) -> " 
            + (ac.getTemperature() == 20 ? "✅ PASS" : "❌ FAIL"));

        // SmartPlug không bị ép phải có setBrightness hay setTemperature! (Chuẩn ISP)
        System.out.println("SmartPlug chi implements Switchable: ✅ Chuan ISP!");

        System.out.println("\n==================================================");
        System.out.println("   TEST 2: DEPENDENCY INVERSION PRINCIPLE (DIP)   ");
        System.out.println("==================================================");
        // SmartHomeController chi phu thuoc vao Switchable[], khong biet den tung loai cu the
        Switchable[] livingRoomDevices = { light, ac, plug };
        SmartHomeController controller = new SmartHomeController(livingRoomDevices);

        System.out.println("-> Kich hoat: arriveHome()...");
        controller.arriveHome();
        boolean allOn = light.isOn() && ac.isOn() && plug.isOn();
        System.out.println("Tat ca thiet bi deu BAT: " + (allOn ? "✅ PASS" : "❌ FAIL"));

        System.out.println("-> Kich hoat: leaveHome()...");
        controller.leaveHome();
        boolean allOff = !light.isOn() && !ac.isOn() && !plug.isOn();
        System.out.println("Tat ca thiet bi deu TAT: " + (allOff ? "✅ PASS" : "❌ FAIL"));

        System.out.println("\n==================================================");
        System.out.println("   TEST 3: DEFENSIVE CODING & NULL SAFETY         ");
        System.out.println("==================================================");
        // Test truyen null vao controller
        SmartHomeController safeController = new SmartHomeController(null);
        safeController.leaveHome(); // Khong duoc phep vang Exception!
        System.out.println("Truyen null vao SmartHomeController: ✅ AN TOAN TUYET DOI");

        // Test mang chua phan tu null
        Switchable[] arrayWithNull = { light, null, plug };
        SmartHomeController nullElementController = new SmartHomeController(arrayWithNull);
        nullElementController.arriveHome(); // Khong duoc phep crash khi gap phan tu null
        System.out.println("Mang chua phan tu null: ✅ AN TOAN TUYET DOI");

        System.out.println("\n==================================================");
        System.out.println("   TEST 4: LEETCODE #11 - CONTAINER WITH MOST WATER");
        System.out.println("==================================================");
        int[] height1 = { 1, 8, 6, 2, 5, 4, 8, 3, 7 };
        int res1 = ContainerWithMostWater.maxArea(height1);
        System.out.println("Test 1: [1,8,6,2,5,4,8,3,7] -> " + res1 + " (Ky vong: 49) " 
            + (res1 == 49 ? "✅ PASS" : "❌ FAIL"));

        int[] height2 = { 1, 1 };
        int res2 = ContainerWithMostWater.maxArea(height2);
        System.out.println("Test 2: [1,1]               -> " + res2 + " (Ky vong: 1)  " 
            + (res2 == 1 ? "✅ PASS" : "❌ FAIL"));

        int[] height3 = { 4, 3, 2, 1, 4 };
        int res3 = ContainerWithMostWater.maxArea(height3);
        System.out.println("Test 3: [4,3,2,1,4]         -> " + res3 + " (Ky vong: 16) " 
            + (res3 == 16 ? "✅ PASS" : "❌ FAIL"));

        int[] heightNull = null;
        int resNull = ContainerWithMostWater.maxArea(heightNull);
        System.out.println("Test 4: null                -> " + resNull + " (Ky vong: 0)  " 
            + (resNull == 0 ? "✅ PASS" : "❌ FAIL"));

        System.out.println("\n==================================================");
        System.out.println("🎉 HOAN THANH KIEM THU DAY 5!");
        System.out.println("==================================================");
    }
}

