
import java.util.Arrays;


// A heap is a special type of data structure where the root node or parent node is compared with its left and right children and arranged according to the order.
// A min heap is a complete binary tree where the parent node is smaller than or equal to its children.
public class MinHeap {
    private int capacity = 7;
    private int size = 0;
    // create an integer array with root at index i = 0
    private int[] items = new int[capacity];

    // math formula (childIndex - 1) / 2 returns the parent node
    private int getParentIndex(int childIndex) {
        return (childIndex - 1) / 2;
    }

    // math formula (parentIndex * 2) + 1 returns the left child node
    private int getLeftChildIndex(int parentIndex) {
        return (parentIndex * 2) + 1;
    }

    // math formula (parentIndex * 2) + 2 returns the right child node
    private int getRightChildIndex(int parentIndex) {
        return (parentIndex * 2) + 2;
    }

    private boolean hasLeftChild(int index) {
        return getLeftChildIndex(index) < size;
    }

    private boolean hasRightChild(int index) {
        return getRightChildIndex(index) < size;
    }

    private boolean hasParent(int index) {
        return getParentIndex(index) >= 0;
    }

    private int leftChild(int index) {
        return items[getLeftChildIndex(index)];
    }

    private int rightChild(int index) {
        return items[getRightChildIndex(index)];
    }

    private int parent(int index) {
        return items[getParentIndex(index)];
    }

    // swaps the values at two indices
    private void swap(int indexOne, int indexTwo) {
        int temp;
        temp = items[indexOne];
        items[indexOne] = items[indexTwo];
        items[indexTwo] = temp;
    }

    private void ensureExtraCapacity() {
        if (size == capacity) {
            items = Arrays.copyOf(items, capacity * 2);
            capacity *= 2;
        }
    }

    public int peek() {
        if (size == 0) {
            throw new IllegalStateException();
        }

        return items[0];
    }

    // remove method -> extract or remove minimum element from the array | O(log n) operation
    public int poll() {
        if (size == 0) {
            throw new IllegalStateException();
        }
        int item = items[0];
        // take the very last element in the array and move it to the front of the array
        items[0] = items[size - 1];
        size--; // shrink the size of the array
        heapifyDown(); // re-heapify down (bubble down) after removing the root element

        return item;

    }

    // insert method | O(log n) operation
    public void add(int item) {
        ensureExtraCapacity();
        items[size] = item; // add an element to the very last spot in the array
        size++; // increase the size of the array
        heapifyUp(); // heapify up (bubble up) by swapping each element with its parent as necessary
    }

    private void heapifyUp() {
        // start with the very last element added
        int index = size - 1;
        // as long as there is a parent item and items/elements are out of order (parent item being larger than the current item)
        while (hasParent(index) && parent(index) > items[index]) {
            swap(getParentIndex(index), index); // swap value with parent
            index = getParentIndex(index); // walk upwards (bubble up)
        }
    }

    private void heapifyDown() {
        // start with the root element
        int index = 0;
        // as long as there are children (only need to check left because there is no right child without a left child)
        while (hasLeftChild(index)) {
            // make adjustments or re-arrange to the heap
            int smallerChildIndex = getLeftChildIndex(index); // get the smaller child index (choose left child as a start),
            // then check if it's true; if not then choose the right child instead
            if (hasRightChild(index) && rightChild(index) < leftChild(index)) {
                smallerChildIndex = getRightChildIndex(index);
            }
            // check if the current index is smaller than the two children
            if (items[index] < items[smallerChildIndex]) {
                break; // everything is in order and there's no need to continue or do anything else
            } else {
                // otherwise, heap is still out of order
                swap(index, smallerChildIndex); // need to swap value with the smaller child
            }

            index = smallerChildIndex; // move down to the smaller child (bubble down)
        }

    }

    // print the contents of the heap
    public void printHeap() {
        for (int i = 0; i < (getParentIndex(i) / 2); i++) {
            System.out.print("Parent : " + items[i]);
            if (getLeftChildIndex(i) < i) {
                System.out.print(" Left : " + items[getLeftChildIndex(i)]);
            }
            if (getRightChildIndex(i) < i) {
                System.out.print(" Right :" + items[getRightChildIndex(i)]);
            }
            System.out.println();
        }
    }


    public static void main(String[] arg) {
        // create a new min heap
        MinHeap minHeap = new MinHeap();
        // add/insert some nodes/elements
        minHeap.add(3);
        minHeap.add(13);
        minHeap.add(7);
        minHeap.add(16);
        minHeap.add(21);
        minHeap.add(12);
        minHeap.add(9);
        // heap-ify down
        minHeap.heapifyDown();
        // print the resulting heap
        System.out.println();
        System.out.println("The Min Heap is : " + Arrays.toString(minHeap.items)); // [3, 13, 7, 16, 21, 12, 9]
        minHeap.printHeap();
        System.out.println("\nThe Min Value is : " + minHeap.poll()); // 3
        System.out.println("\nThe Min Heap is :" + Arrays.toString(minHeap.items)); // [7, 13, 9, 16, 21, 12, 9]  // after removing the root
        minHeap.printHeap();
        System.out.println();
    }

}