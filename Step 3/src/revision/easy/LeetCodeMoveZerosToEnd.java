package revision.easy;

import java.util.Arrays;

public class LeetCodeMoveZerosToEnd {
    public static void main(String[] args) {

        int[] vals = {-58305, -22022, 0, 0, 0, 0, 0, -76070, 42820, 48119, 0, 95708, -91393, 60044, 0, -34562, 0, -88974};
        moveZerosToEnd(vals);
        System.out.println(Arrays.toString(vals));
    }

    // My Solution
    private static void moveZerosToEnd(int[] vals) {
        int k = 0;
        for (int i = 0; i < vals.length; i++) {
            if (vals[k] == 0 && vals[i] != 0) {
                int val = vals[k];
                vals[k] = vals[i];
                vals[i] = val;
                k += 1;
            }
            if (vals[k] != 0) k += 1;
        }
    }
}







