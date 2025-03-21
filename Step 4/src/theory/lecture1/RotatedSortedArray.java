package theory.lecture1;

import java.util.ArrayList;
import java.util.Arrays;

public class RotatedSortedArray {
    public static void main(String[] args) {

        ArrayList<Integer> vals = new ArrayList<>(Arrays.asList(12, 15, 18, 2, 4));
        int[] values = {6, 10, 1, 3, 5};
        int len = vals.size(), k = 3;

        System.out.print(search(vals, len, k));
        System.out.print("\n" + searchInARotatedSortedArrayII(values, k));
    }

    private static int search(ArrayList<Integer> vals, int len, int k) {
        int low = 0, high = len - 1;

        while (low <= high) {
            int centre = (low + high) / 2;
            if (vals.get(centre) == k) return centre;

            if (vals.get(low) <= vals.get(centre)) {
                if (vals.get(low) <= k && k <= vals.get(centre)) {
                    high = centre - 1;
                } else {
                    low = centre + 1;
                }
            } else {
                if (vals.get(centre) <= k && k <= vals.get(high)) {
                    low = centre + 1;
                } else {
                    high = centre - 1;
                }
            }
        }
        return -1;
    }

    public static boolean searchInARotatedSortedArrayII(int[] vals, int k) {
        int low = 0, high = vals.length - 1;

        while (low <= high) {
            int centre = (low + high) / 2;
            if (vals[centre] == k) return true;

            if (vals[low] == vals[centre] && vals[high] == vals[centre]) {
                high -= 1;
                low += 1;
                continue;
            }
            if (vals[low] <= vals[centre]) {
                if (vals[low] <= k && k <= vals[centre]) {
                    high = centre - 1;
                } else {
                    low = centre + 1;
                }
            } else {
                if (vals[centre] <= k && k <= vals[high]) {
                    low = centre + 1;
                } else {
                    high = centre - 1;
                }
            }
        }
        return false;
    }

    public static int findMin(int[] vals) {
        int low = 0, high = vals.length - 1, result = Integer.MAX_VALUE;
        int index = -1;

        while (low <= high) {
            int centre = (low + high) / 2;

            if (vals[low] <= vals[high]) {
                if (result > vals[low]) {
                    index = low;
                    result = vals[low];
                }
                break;
            }

            if (vals[low] <= vals[centre]) {
                if (result > vals[low]) {
                    index = low;
                    result = vals[low];
                }
                low = centre + 1;
            } else {
                if (result > vals[centre]) {
                    index = centre;
                    result = vals[centre];
                }
                high = centre - 1;
            }
        }
        return index;
    }
}