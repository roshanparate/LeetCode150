package binarytree;

public class CountGoodNodesInBinaryTree {
    private static int goodCount;

    public static void main(String[] args) {
        CountGoodNodesInBinaryTree solution = new CountGoodNodesInBinaryTree();
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(1);
        root.right = new TreeNode(4);
        root.left.left = new TreeNode(3);
        root.right.left = new TreeNode(1);
        root.right.right = new TreeNode(5);

        solution.goodNodes(root);
        System.out.println("Number of good nodes: " + goodCount); // Output: 4
    }

    public void goodNodes(TreeNode root) {
        if(root== null) return;

        int goodCount = 0;

        getGoodCount(root, root.val);
    }

    public void getGoodCount(TreeNode root, int max){
        if(root == null){
            return;
        }
        int newMax = max;
        if(max <= root.val){
            newMax = root.val;
            goodCount++;
        }

        getGoodCount(root.left, newMax);
        getGoodCount(root.right, newMax);

    }
}
