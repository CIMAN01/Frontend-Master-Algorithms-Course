import java.util.Arrays;

// Time Complexity ranges from O(n log n) to O(n^2) | Space Complexity ranges from O(log n) to O(n)
public class QuickSort {

    // all the numbers that are smaller than the pivot are placed on the left side of the pivot, and all the numbers that are bigger go on the right side of the pivot
    private static int partition(int[] arr, int start, int end) {
        int pivot = arr[end]; // typically, the last item in the array is chosen as the pivot
        int boundary = start - 1; // boundary will not necessarily start at index 0 so instead of just -1 it has to be start - 1 (beginning index of the partition)
        // iterate over a segment of the array
        for (int i = start; i <= end; i++) {
            // if an item is smaller than the pivot, put it in the left partition
            if(arr[i] <= pivot) {
                boundary++; // increment the boundary first
                // then do a swap
                int temp = arr[i];
                arr[i] = arr[boundary];
                arr[boundary] = temp;
            }
        }

        return boundary; // index of the pivot (boundary) after it's moved to its correct position
    }

    private static void quickSort(int[] arr, int start, int end) {
        // handle a single item or empty array
        if (start >= end) {
            return;
        }

        int boundary = partition(arr, start, end);

        quickSort(arr, start, boundary - 1); // sort left partition
        quickSort(arr, boundary + 1, end); // sort right partition
    }

    public static void sort(int[] arr) {
        quickSort(arr, 0, arr.length - 1);
    }

    public static void main(String[] args) {
        int[] numbers = { 8, 7, 6, 4, 5 };

        System.out.println();
        System.out.print("Input Array: ");
        System.out.println(Arrays.toString(numbers));

        sort(numbers);

        System.out.println();
        System.out.print("Sorted Array: ");
        System.out.println(Arrays.toString(numbers));
    }

}
