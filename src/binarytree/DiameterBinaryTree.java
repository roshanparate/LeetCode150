package binarytree;

public class DiameterBinaryTree {
    int diameter = 0;

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);

        DiameterBinaryTree solution = new DiameterBinaryTree();
        int diameter = solution.diameterOfBinaryTree(root);
        System.out.println("Diameter of the binary tree: " + diameter); // Output: 3
    }

    public int diameterOfBinaryTree(TreeNode root) {
        diameter(root);
        return diameter;
    }


    public int diameter(TreeNode root) {

        if(root == null){
            return 0;
        }

        int leftMax = diameter(root.left);
        int rightMax = diameter(root.right);

        diameter = Math.max(diameter, leftMax+rightMax);

        return Math.max(leftMax, rightMax)+1;

    }
}
