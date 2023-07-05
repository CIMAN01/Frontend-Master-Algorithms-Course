import java.util.ArrayList;

// Stack implementation using a LinkedList
public class Stack {
    // inner class
    private class Node {
        // fields
        private int value;
        private Stack.Node next;
        private Stack.Node prev;

        // constructor
        public Node(int value) {
            this.value = value;
        }
    }

    private Stack.Node head, tail;
    private int count;

    // O(1)
    public void push(int item) {
        Stack.Node node = new Stack.Node(item);

        if (isEmpty()) {
            head = tail = node;
        }
        else {
            head.prev = node; // put a new node in front of the head (top of the stack)
            node.next = head; // point that node to the head
            head = node; // make the new node become the head
        }

        count++; // update how many items we have in the stack
    }

    // O(1)
    public int pop() {
        // make sure the stack is not empty (there is no head)
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
            Stack.Node second = head.next; // create new node that head now points to
            head.next = null; // the head no longer points to the second node
            head = second; // make the second node become the new head
        }

        count--; // update how many items we have in the stack

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
        Stack.Node current = head;

        while (current != null) {
            list.add(current.value);
            current = current.next;
        }

        return list.toString();
    }


    public static void main (String[] args) {
        // create a queue
        Stack s = new Stack();

        s.push(10);
        s.push(20);
        s.push(30);

        System.out.println("Front element is: " + s.peek());
        s.pop();

        System.out.println("Front element is: " + s.peek());

        System.out.println("Stack size is " + s.size());

        s.pop();
        //s.pop();

        if (s.isEmpty()) {
            System.out.println("Stack Is Empty");
        }
        else {
            System.out.println("Stack Is Not Empty");
        }
    }
}
