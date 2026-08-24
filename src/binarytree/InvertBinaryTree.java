package binarytree;

public class InvertBinaryTree {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(4);
        root.left = new TreeNode(2);
        root.right = new TreeNode(7);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(3);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(9);

        InvertBinaryTree solution = new InvertBinaryTree();
        TreeNode invertedRoot = solution.invertTree(root);

        System.out.println("Inverted tree:");
        printTree(invertedRoot);
    }

    private static void printTree(TreeNode invertedRoot) {
        if (invertedRoot == null) {
            return;
        }
        System.out.print(invertedRoot.val + " ");
        printTree(invertedRoot.left);
        printTree(invertedRoot.right);
    }

    public TreeNode invertTree(TreeNode root) {

        if(root == null) return null;

        TreeNode t1 = invertTree(root.left);
        TreeNode t2 = invertTree(root.right);

        root.right = t1;
        root.left = t2;

        return root;

    }
}
