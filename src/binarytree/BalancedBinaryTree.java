package binarytree;

public class BalancedBinaryTree {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.left.left = new TreeNode(15);
        root.left.right = new TreeNode(7);

        BalancedBinaryTree solution = new BalancedBinaryTree();
        System.out.println("Is the binary tree balanced? " + solution.isBalanced(root)); // Output: false
    }

    public boolean isBalanced(TreeNode root) {
        return getTreeHeight(root) != -1;
    }

    private int getTreeHeight(TreeNode root){
        if(root == null) return 0;

        int leftHt = getTreeHeight(root.left);
        if(leftHt == -1) return -1;
        int rightHt = getTreeHeight(root.right);
        if(rightHt == -1) return -1;

        if(Math.abs(leftHt - rightHt) > 1) return -1;

        return Math.max(leftHt, rightHt) + 1;
    }
}
