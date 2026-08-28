package binarytree;

public class SumOfLeftLeaves {

    private static int leftSum;
    public static void main(String[] args) {
        SumOfLeftLeaves solution = new SumOfLeftLeaves();
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);

        solution.sumOfLeftLeaves(root);
        System.out.println("Sum of left leaves: " + leftSum); // Output: 24
    }

    public void sumOfLeftLeaves(TreeNode root) {
        leftSum = 0;
        getLeftSum(root, false);
    }

    public void getLeftSum(TreeNode root, boolean isLeft){

        if(root != null){
            if(root.left == null && root.right == null && isLeft){
                leftSum += root.val;
            }

            getLeftSum(root.left, true);
            getLeftSum(root.right, false);
        }
    }
}
