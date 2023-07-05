public class BubbleSort {

    public static void swap(int[] arr, int j) {
        int temp = arr[j];
        arr[j] = arr[j+1];
        arr[j+1] = temp;
    }

    // Bubble Sort has a runtime of O(n^2)
    public static void bubbleSort(int[] arr) {
        for (int i = 0; i < arr.length-1; i++) {
            for (int j = 0; j < arr.length-1-i; j++) { // minus i because the right most element will have 'bubbled up' to its correct position during each iteration
                if(arr[j] > arr[j+1]) {
                    swap(arr, j);
                }
            }
        }
    }

    public static void main(String[] args) {
        int[] arr ={ 3, 60, 35, 2, 45, 320, 5 };

        System.out.println();
        System.out.println("Array Before Bubble Sort:");
        for (int n : arr) {
            System.out.print(n + " ");
        }
        System.out.println();

        bubbleSort(arr); //sorting array elements using bubble sort

        System.out.println();
        System.out.println("Array After Bubble Sort:");
        for (int n : arr) {
            System.out.print(n + " ");
        }
        System.out.println();
    }
    
}
