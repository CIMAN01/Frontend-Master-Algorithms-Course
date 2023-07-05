
// Time: O(h) -> O(log n) to O(n) | Mimicks a Quick Sort
public class BinarySearchTree {
    // field
    Node root;
    // outer constructor
    public BinarySearchTree() {
        root = null;
    }

    // inner class
    private static class Node {
        // inner fields
        int val;
        BinarySearchTree.Node left;
        BinarySearchTree.Node right;
        // inner constructor
        Node(int val) {
            this.val = val;
        }
    }

    // Find (Search)
    public Node find(Node root, int val) {
        // base case
        if (root == null || root.val == val) {
            return root;
        }
        // recursive (search one side or the other, but not both)
        // if the node value is smaller than the value we're looking for, search the right side instead
        if (root.val < val) {
            return find(root.right, val);
        }

        return find(root.left, val); // search the left side otherwise
    }

    // Insert (implementation)
    public Node insert(Node root, int val) {
        // base case for our recursion
        if (root == null) {
            root = new Node(val);

            return root;
        }
        // recursive case:
        // if value being inserted is smaller than the current node, then insert it on the left side;
        // else (if it's bigger), insert it on the right side instead
        if (root.val >= val) {
            root.left = insert(root.left, val);
        } else { // (root.val < val) {
            root.right = insert(root.right, val);
        }

        return root;
    }

    // Insert (used by main method)
    public void insert(int val) {
        root = insert(root, val);
    }

    // Get the minimum value by traversing the left side of the tree (or each subtree)
    public int minValue(Node root) {
        int minVal = root.val;

        while (root.left != null) {
            minVal = root.left.val;
            root = root.left;
        }

        return minVal;
    }

    // Get the maximum value by traversing the right side of the tree (or each subtree)
    public int maxValue(Node root) {
        int maxVal = root.val;

        while (root.right != null) {
            maxVal = root.right.val;
            root = root.right;
        }

        return maxVal;
    }

    // Delete -> choose either the smallest value on the larger side (subtree) or the largest value on the smaller side (subtree)
    // Tip: pick the side with the largest subtree (determined by the height of the tree/subtrees) to shrink the overall height of the tree
    public Node delete(Node root, int val) {
        // base case
        if (root == null) {
            return null;
        }
        // recursive case where there are no children
        if (root.val > val) {
            root.left = delete(root.left, val);
        } else if (root.val < val) {
            root.right = delete(root.right, val);
        } else {
            // recursive case where a node only has one child or no children
            if (root.left == null) {
                return root.right;
            }
            if (root.right == null) {
                return root.left;
            }
            // recursive case where a node has two children: get the in-order successor (smallest in the right subtree)
            root.val = minValue(root.right);
            root.right = delete(root.right, root.val);
            
            // a node with two children: get the inorder successor (largest in the left subtree)
            //root.val = maxValue(root.left);
            //root.left = delete(root.left, root.val);
        }

        return root;
    }


    public static void main(String[] args) {
        // create a new tree
        BinarySearchTree bst = new BinarySearchTree();
        // insert nodes with values to the tree
        bst.insert(50);
        bst.insert(30);
        bst.insert(20);
        bst.insert(40);
        bst.insert(70);
        bst.insert(60);
        bst.insert(80);
        // find and print a node with a specific value
        Node node = bst.find(bst.root, 60);
        System.out.println();
        System.out.println(node.val); // prints 60
        // delete a node with a specific value
        bst.delete(bst.root, 20);
        // find and print a node with a specific value
        node = bst.find(bst.root, 20);
        System.out.println();
        System.out.println(node); // prints null
        System.out.println();
    }

}
