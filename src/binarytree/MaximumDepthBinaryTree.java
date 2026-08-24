package binarytree;

public class MaximumDepthBinaryTree {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);

        MaximumDepthBinaryTree solution = new MaximumDepthBinaryTree();
        int depth = solution.maxDepth(root);
        System.out.println("Maximum depth of the binary tree: " + depth); // Output: 3
    }

    public int maxDepth(TreeNode root) {
        if(root == null) return 0;

        return Math.max(maxDepth(root.left), maxDepth(root.right))+1;
    }
}
