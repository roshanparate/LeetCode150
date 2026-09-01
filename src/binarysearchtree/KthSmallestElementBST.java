package binarysearchtree;

import java.util.ArrayList;
import java.util.List;

public class KthSmallestElementBST {

    public static void main(String[] args) {
        KthSmallestElementBST solution = new KthSmallestElementBST();
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(1);
        root.right = new TreeNode(4);
        root.left.right = new TreeNode(2);

        int k = 2;
        int result = solution.kthSmallest(root, k);
        System.out.println("The " + k + "th smallest element in the BST is: " + result);
    }

    public int kthSmallest(TreeNode root, int k) {
        List<Integer> bstData = new ArrayList<>();
        helper(root, bstData);
        return bstData.get(k-1);
    }

    public void helper(TreeNode root, List<Integer> bstData){
        if(root == null) return;

        helper(root.left, bstData);
        bstData.add(root.val);
        helper(root.right, bstData);
    }
}
