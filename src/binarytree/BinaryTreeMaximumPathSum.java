package binarytree;

public class BinaryTreeMaximumPathSum {

    static int maxValue = Integer.MIN_VALUE;

    public static void main(String[] args) {
        BinaryTreeMaximumPathSum solution = new BinaryTreeMaximumPathSum();
        TreeNode root = new TreeNode(-10);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);

        solution.helper(root);
        System.out.println("Maximum path sum: " + maxValue); // Output: 42
    }


    public int helper(TreeNode root){
        if(root == null){
            return 0;
        }

        int leftMax = Math.max(helper(root.left), 0);
        int rightMax = Math.max(helper(root.right), 0);

        int max = leftMax + rightMax + root.val;

        maxValue = Math.max(maxValue, max);

        return Math.max(leftMax, rightMax) + root.val ;
    }
}
