package GiaiDoan1.challenge02;

import java.lang.reflect.Array;

public class TrafficController {
    public static void sortLaneByPriority(int[] lane) {
        if (lane == null || lane.length <= 1) return;

        int l = 0, m = 0, r = lane.length - 1;
        while (m <= r) {
            if (lane[m] == 0) {
                int temp = lane[l];
                lane[l] = lane[m];
                lane[m] = temp;
                l++; m++;
            }
            else if (lane[m] == 2) {
                int temp = lane[r];
                lane[r] = lane[m];
                lane[m] = temp;
                r--;
            }
            else m++;
        }
    }

}
