package binarytree;

import java.util.HashMap;
import java.util.Map;

public class ConstructBinaryTreeFromPreorderAndInorderTraversal {

    private Map<Integer, Integer> inorderMap;
    private int preorderIndex;

    public static void main(String[] args) {
        ConstructBinaryTreeFromPreorderAndInorderTraversal treeBuilder = new ConstructBinaryTreeFromPreorderAndInorderTraversal();
        int[] preorder = {3, 9, 20, 15, 7};
        int[] inorder = {9, 3, 15, 20, 7};
        TreeNode root = treeBuilder.buildTree(preorder, inorder);
        System.out.println("Constructed Binary Tree from Preorder and Inorder Traversal.");
    }

    public TreeNode buildTree(int[] preorder, int[] inorder) {

        if(preorder == null || preorder.length == 0) return null;

        preorderIndex = 0;

        inorderMap = new HashMap<>();
        for(int i = 0; i < inorder.length; i++){
            inorderMap.put(inorder[i], i);
        }

        return buildTree(preorder, inorder, 0, inorder.length-1);
    }

    public TreeNode buildTree(int[] preorder, int[] inorder, int inorderStart, int inorderEnd){
        if(inorderStart > inorderEnd){
            return null;
        }

        int rootValue = preorder[preorderIndex];
        TreeNode root = new TreeNode(rootValue);

        int rootIndex = inorderMap.get(rootValue);

        preorderIndex++;

        root.left = buildTree(preorder, inorder, inorderStart, rootIndex-1);
        root.right = buildTree(preorder, inorder, rootIndex+1, inorderEnd);

        return root;
    }
}
