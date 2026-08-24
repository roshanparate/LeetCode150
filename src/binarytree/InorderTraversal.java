package binarytree;

import java.util.ArrayList;
import java.util.List;

public class InorderTraversal {

    public static void main(String[] args) {
        InorderTraversal inorderTraversal = new InorderTraversal();
        TreeNode root = new TreeNode(1);
        root.right = new TreeNode(2);
        root.right.left = new TreeNode(3);

        List<Integer> result = inorderTraversal.inorderTraversal(root);
        System.out.println("Inorder Traversal: " + result); // Output: Inorder Traversal: [1, 3, 2]
    }

    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> nList = new ArrayList<>();
        inOrder(root, nList);
        return nList;
    }

    public void inOrder(TreeNode root, List<Integer> nList){
        if(root == null) return;

        inOrder(root.left, nList);
        nList.add(root.val);
        inOrder(root.right, nList);
    }
}
