import java.util.HashMap;
import java.util.Map;

/*
To implement an LRU cache in Java, we can use a combination of a HashMap and a doubly linked list.
The HashMap will store the key-value pairs of the cache, while the doubly linked list will keep track of the order of the elements in the cache.
The least recently used element will be at the tail of the list, and the most recently used element will be at the head of the list.
 */

// Least Recently Used Cache -> Time: O(1) for all operations | Space: O(capacity)
class LRUCache {

    // inner class
    private class Node {
        // fields
        private int key, value;
        private Node next, prev;

        // constructor
        public Node(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    // outer fields
    private int capacity;
    private Node head, tail;
    private Map<Integer, Node> cache = new HashMap<>();

    // initialize a <capacity> size data structure with two empty nodes pointing to each other (head and tail)
    public LRUCache(int capacity) {
        this.capacity = capacity;
        head = new Node(-1, -1);
        tail = new Node(-1, -1);
        head.next = tail;
        tail.prev = head;
    }

    // Prepend -> move the current node to head | O(1)
    public void prepend(Node node) {
        // handle null node
        if (node == null) {
            return;
        }
        // if head is null
        if (head == null) {
            head = tail = node;
        }
        // move node to be the new head
        node.next = head;
        node.prev = null;
        head.prev = node;
        head = node;
    }


    // Detach -> remove the current node | O(1)
    private void detach(Node node) {
        // break links to the left of the current node
        if (node.prev != null) {
            node.prev.next = node.next;
        } else {
            head = node.next; // if the node being detached ends up being the head
        }
        // break links to the right of the current node
        if (node.next != null) {
            node.next.prev = node.prev;
        } else {
            tail = node.prev; // if the node being detached ends up being the tail
        }
    }

    // Get -> when getting the node, delete it and move it to head because it is recently used | O(1)
    public int get(int key) {
        // check the cache for existence of key
        if (cache.containsKey(key)) {
            // if found, update the value and move it to the front of the list
            Node node = cache.get(key);
            detach(node); // detach current node
            prepend(node); // move current node to front of the list (head)

            return node.value; // return the value found
        }

        return -1; // or -1 if a value does not exist
    }



    // Update or put -> puts a new node if it doesn't already exist. Regardless, this node is prepended because it is recently used. If capacity is exceeded, remove the tail because it is the least used | O(1)
    public void update(int key, int value) {
        // check the cache for existence of a key
        if (cache.containsKey(key)) {
            // move node to the front of the list and update the value:
            Node node = cache.get(key); // get node from map using the key
            node.value = value; // update the value
            detach(node); // detach the node
            prepend(node); // move the node to front of the list (head)
        } else { // if key does not exist, need to insert a new node and update the cache:
            // check capacity and evict if over capacity
            if (cache.size() == capacity) {
                cache.remove(tail.key); // remove the key
                detach(tail); // detach the tail
            }
            Node node = new Node(key, value); // create a new node
            prepend(cache.get(key)); // move the node to front of the list (head)
            cache.put(key, node); // update hash-map
        }
    }


    // TEST
    public static void main(String[] args) {
        // create a new cache
        LRUCache cache = new LRUCache(2);
        // use update and get operations and print results to the console:
        cache.update(1, 1);
        System.out.println(cache.get(1)); // returns 1
        cache.update(3, 3);               // evicts key 2
        System.out.println(cache.get(2)); // returns -1 (not found)
        cache.update(4, 4);               // evicts key 1
        System.out.println(cache.get(1)); // returns -1 (not found)
        System.out.println(cache.get(3)); // returns 3
        System.out.println(cache.get(4)); // returns 4
    }

}
