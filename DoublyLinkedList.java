
// Implement a doubly linked list using the prepend(), append(),  insertAt(), remove(), removeAt, get(), and getAt() methods
public class DoublyLinkedList {
    // Fields
    private Node head;
    private Node tail;
    private int size;

    // Inner class
    private class Node {
        // Inner Fields
        int item;
        Node prev;
        Node next;

        // Inner Constructor
        public Node(int item) {
            this.item = item;
        }
    }

    // Add to the front of the list
    public void prepend(int item) {
        Node node = new Node(item);

        if (head == null) {
            head = tail = node;
        } else {
            node.next = head;
            head.prev = node;
            head = node;
        }

        size++;
    }

    // Add to specified index of the list
    public void insertAt(int index, int item) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException();
        }
        // decide where to insert the item (front, middle, or back of the list)
        if (index == 0) {
            prepend(item);
        } else if (index == size) {
            append(item);
        } else {
            Node current = head;
            // traverse the list to find the index-based node
            for (int i = 0; i < index ; i++) {
                current = current.next;
            }
            // create a new node
            Node node = new Node(item);
            // create new links (insert the node)
            node.next = current;
            node.prev = current.prev;
            // break old links and point to correct nodes
            current.prev.next = node;  // node.next = current
            current.prev = node;

            size++;
        }
    }

    // Add to the back of the list
    public void append(int item) {
        Node node = new Node(item);

        if (tail == null) {
            head = tail = node;
        } else {
            node.prev = tail;
            tail.next = node;
            tail = node;
        }

        size++;
    }

    // Remove an item from the list
    public void remove(int item) {
        // get the item we want to remove
        Node current = get(item);
        // if we don't find the item, there's nothing to remove
        if (current == null) {
            return;
        }
        // check if the item to be removed is at the start, end, or middle of the list
        if (current == head) {
            // remove the first node and update the head
            head = head.next;

            if (head != null) {
                head.prev = null;
            }
        } else if (current == tail) {
            // remove the last node and update the tail
            tail = tail.prev;

            if (tail != null) {
                tail.next = null;
            }
        } else {
            // here the item being deleted is from somewhere in the "middle" of the list;
            // break the links so that the nodes point to each other correctly
            current.prev.next = current.next;
            current.next.prev = current.prev;
        }

        size--;
    }


    // Remove an item from the list at the specified index
    public void removeAt(int index) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException();
        }
        // check if the item to be removed is at the start, end, or 'middle' of the list
        if (index == 0) {
            // remove the first node and update the head
            head = head.next;

            if (head != null) {
                head.prev = null;
            }
        } else if (index == size) {
            // remove the last node and update the tail
            tail = tail.prev;

            if (tail != null) {
                tail.next = null;
            }
        } else {
            Node current = head;

            for (int i = 0; i < index; i++) {
                current = current.next;
            }
            // remove node by breaking old links
            current.prev.next = current.next;
            current.next.prev = current.prev;
        }

        size--;
    }

    // Get the Node
    public Node get(int item) {
        Node current = head;

        while (current != null && current.item != item) {
            current = current.next;
        }

        return current;
    }

    // Get the Node at the specified index
    public Node getAt(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        }

        Node current = head;

        for (int i = 0; i < index; i++) {
            current = current.next;
        }

        return current;
    }

    // Display the list
    public void display() {
        Node current = head;

        while (current != null) {
            System.out.print(current.item + " ");
            current = current.next;
        }

        System.out.println();
    }


    // Driver
    public static void main(String[] args) {
        DoublyLinkedList list = new DoublyLinkedList();
        // Add nodes using append() method
        list.append(1);
        list.append(2);
        list.append(3);
        // Add nodes using prepend() method
        list.prepend(0);
        list.prepend(-1);

        // Display the nodes in the list
        System.out.println();
        System.out.print("Output: ");
        list.display(); // Output: -1 0 1 2 3

        DoublyLinkedList list2 = new DoublyLinkedList();
        // Add nodes to the list
        list2.append(1);
        list2.append(2);
        list2.append(3);
        list2.prepend(0);
        // Remove a node at index 2
        list2.removeAt(2);
        // Display the updated list
        System.out.println();
        System.out.print("Output: ");
        list2.display(); // Output: 0 1 3

        DoublyLinkedList list3 = new DoublyLinkedList();
        // Add nodes to the list
        list3.append(1);
        list3.append(2);
        list3.append(3);
        list3.append(4);
        System.out.println();
        System.out.print("Output: ");
        list3.display(); // Output: 1 2 3 4
        list3.insertAt(3, 5);
        // Display the list
        System.out.println();
        System.out.print("Output: ");
        list3.display(); // Output: 1 2 5 4
        // Remove an item
        list3.remove(5);
        // Display the updated list
        System.out.println();
        System.out.print("Output: ");
        list3.display(); // Output: 1 2 4
    }

}
