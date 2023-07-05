import java.lang.Math;

public class BinarySearch {

    // Binary Search Algorithm
    public static int binarySearch(int[] haystack, int needle) {
        int low = 0;
        int high = haystack.length;

        do {
            int mid = (int) Math.floor(low + (double) (high - low) / 2);
            int val = haystack[mid];

            if (val == needle) {
                return mid;
            } else if (val > needle) {
                high = mid;
            } else {
                low = mid + 1;
            }
        } while (low < high);

        return -1;
    }

    public static void main(String[] args) {
        int[] arr = {3, 5, 7, 12, 18, 25, 29, 31, 40, 45, 52, 55, 60 };
        System.out.println(binarySearch(arr, 29)); // mid = 6
    }

}
