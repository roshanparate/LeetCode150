package binarysearchtree;

public class ValidateBinarySearchTree {

    public static void main(String[] args) {
        ValidateBinarySearchTree solution = new ValidateBinarySearchTree();
        TreeNode root = new TreeNode(2);
        root.left = new TreeNode(1);
        root.right = new TreeNode(3);

        boolean isValid = solution.isValidBST(root);
        System.out.println("Is the tree a valid BST? " + isValid);
    }

    // Start the validation with no lower/upper limit, then constrain each subtree
    // as we move deeper. Every node must stay within the allowed range:
    // left subtree values < current value, right subtree values > current value.
    public boolean isValidBST(TreeNode root) {
        return helper(root, null, null);
    }

    // low = minimum allowed value (exclusive), high = maximum allowed value (exclusive)
    // If a node violates its allowed range, the subtree is not a valid BST.
    private boolean helper(TreeNode root, Integer low, Integer high){
        if(root == null) return true;

        // Left subtree must contain values smaller than current node,
        // and current node cannot be less than or equal to the lower bound.
        if(low != null && root.val <= low) return false;

        // Right subtree must contain values greater than current node,
        // and current node cannot be greater than or equal to the upper bound.
        if(high != null && high <= root.val) return false;

        // Recurse into left and right children while tightening the valid range.
        return helper(root.left, low, root.val) && helper(root.right, root.val, high);
    }
}
