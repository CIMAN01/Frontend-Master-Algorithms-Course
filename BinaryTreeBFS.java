
import java.util.LinkedList;
import java.util.Queue;

// Time: O(n) | Queue based tree traversal
public class BinaryTreeBFS {

    // inner class
    private static class TreeNode {
        // inner fields
        int val;
        TreeNode left;
        TreeNode right;
        // inner constructor
        TreeNode(int val) {
            this.val = val;
        }
    }

    // Breadth-First Search
    public void bfs(TreeNode root) {
        // base case
        if (root == null) {
            return;
        }
        // create a new queue backed by linked list
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root); // enqueue the root node
        // remove each item (node) from the queue (dequeue) as long as the queue is not empty
        while (!queue.isEmpty()) {
            // dequeue the first node
            TreeNode node = queue.poll();
            System.out.print(node.val + " ");
            // enqueue it's children
            if (node.left != null) {
                queue.offer(node.left); // enqueue the left child node if it's not null
            }
            if (node.right != null) {
                queue.offer(node.right); // enqueue the right child node if it's not null
            }
        }
    }


    public static void main(String[] args) {
        // create a new root node
        TreeNode root = new TreeNode(7);
        // populate the root node with children
        root = new TreeNode(7);
        root.left = new TreeNode(23);
        root.right = new TreeNode(8);
        root.left.left = new TreeNode(5);
        root.left.right = new TreeNode(4);
        root.right.left = new TreeNode(21);
        root.right.right = new TreeNode(15);
        // create a new binary tree
        BinaryTreeBFS tree = new BinaryTreeBFS();
        // do breath first search on the tree based on the root node
        System.out.println();
        System.out.print("Breadth-first traversal of binary tree: ");
        tree.bfs(root);
        System.out.println();
    }

}
