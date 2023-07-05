
// A Binary Tree Comparison
public class BinaryTreeComparison {

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

    // Compare two trees to see if they're identical or not
    public static boolean isSameTree(TreeNode a, TreeNode b) {
        // structural check
        if (a == null && b == null) {
            return true;
        }
        // structural check
        if (a == null || b == null) {
            return false;
        }
        // value check
        if (a.val != b.val) {
            return false;
        }

        return isSameTree(a.left, b.left) && isSameTree(a.right, b.right);
    }


    public static void main(String[] args) {
        // create a tree with nodes
        TreeNode root1 = new TreeNode(5);
        root1.left = new TreeNode(3);
        root1.right = new TreeNode(45);
        root1.left.left = new TreeNode(7);
        root1.left.right = new TreeNode(9);
        root1.right.left = new TreeNode(14);
        // create another tree with nodes
        TreeNode root2 = new TreeNode(5);
        root2.left = new TreeNode(3);
        root2.right = new TreeNode(45);
        root2.left.left = new TreeNode(7);
        root2.left.right = new TreeNode(9);
        root2.right.left = new TreeNode(14);
        // compare trees to see if they're structurally equal
        boolean result = isSameTree(root1, root2);
        System.out.println();
        System.out.println("True or false, are the trees identical?");
        System.out.println();
        System.out.print("Answer: ");
        System.out.println(result); // true
    }

}
