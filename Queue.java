import java.util.ArrayList;

// Queue implementation using a LinkedList
class Queue {

    // inner class
    private class Node {
        // fields
        private int value;
        private Node next;

        // constructor
        public Node(int value) {
            this.value = value;
        }
    }

    private Node head, tail;
    private int count;

    // O(1)
    public void enqueue(int item) {
        Node node = new Node(item);

        if (isEmpty()) {
            head = tail = node;
        }
        else {
            tail.next = node;
            tail = node;
        }

        count++; // update how many items we have in the queue
    }

    // O(1)
    public int dequeue() {
        // make sure the queue is not empty (there is no head)
        if (isEmpty()) {
            throw new IllegalStateException();
        }

        int value;

        if (head == tail) {
            value = head.value;
            head = tail = null;
        }
        else {
            value = head.value; // store the value
            Node second = head.next; // create new node that head now points to
            head.next = null; // the head no longer points to the second node
            head = second; // make the second node become the new head
        }

        count--; // update how many items we have in the queue

        return value;
    }

    // O(1)
    public int peek() {
        if (isEmpty()) {
            throw new IllegalStateException();
        }

        return head.value;
    }

    // O(1)
    public int size() {
        return count;
    }

    // O(1)
    public boolean isEmpty() {
        return head == null;
    }

    // O(n)
    public String toString() {
        ArrayList<Integer> list = new ArrayList<>();
        Node current = head;

        while (current != null) {
            list.add(current.value);
            current = current.next;
        }

        return list.toString();
    }


    public static void main (String[] args) {
        // create a queue
        Queue q = new Queue();

        q.enqueue(10);
        q.enqueue(20);
        q.enqueue(30);

        System.out.println("Front element is: " + q.peek());
        q.dequeue();

        System.out.println("Front element is: " + q.peek());

        System.out.println("Queue size is " + q.size());

        q.dequeue();
        //q.dequeue();

        if (q.isEmpty()) {
            System.out.println("Queue Is Empty");
        }
        else {
            System.out.println("Queue Is Not Empty");
        }
    }

}