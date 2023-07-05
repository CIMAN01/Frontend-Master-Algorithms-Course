
// Time: O(n) | Stack based tree traversal
class BinaryTree {
    // outer field
    Node root;
    // outer constructor
    BinaryTree() {
        root = null;
    }

    // inner class
    private static class Node {
        // inner fields
        int item;
        Node left, right;
        // inner constructor
        public Node(int item) {
            this.item = item;
            left = right = null;
        }
    }

    void printPreorder(Node node) {
        // base case
        if (node == null) {
            return;
        }

        System.out.print(node.item + " "); // root
        printPreorder(node.left); // left
        printPreorder(node.right); // right
    }

    void printInorder(Node node) {
        // base case
        if (node == null) {
            return;
        }

        printInorder(node.left); // left
        System.out.print(node.item + " "); // root
        printInorder(node.right); // right
    }

    void printPostorder(Node node) {
        // base case
        if (node == null) {
            return;
        }

        printPostorder(node.left); // left
        printPostorder(node.right); // right
        System.out.print(node.item + " "); // root
    }


    public static void main(String[] args) {
        // Create a new tree
        BinaryTree tree = new BinaryTree();
        // Add children
        tree.root = new Node(7);
        tree.root.left = new Node(23);
        tree.root.right = new Node(3);
        tree.root.left.left = new Node(5);
        tree.root.left.right = new Node(4);
        tree.root.right.left = new Node(18);
        tree.root.right.right = new Node(21);
        // Print Pre-Order
        System.out.println();
        System.out.print("Pre-order traversal: ");
        tree.printPreorder(tree.root);
        System.out.println();
        System.out.println("------------------------------------------");
        // Print In-Order
        System.out.print("In-order traversal: ");
        tree.printInorder(tree.root);
        System.out.println();
        System.out.println("------------------------------------------");
        // Print Post-Order
        System.out.print("Post-order traversal: ");
        tree.printPostorder(tree.root);
        System.out.println();
        System.out.println();
    }

}
