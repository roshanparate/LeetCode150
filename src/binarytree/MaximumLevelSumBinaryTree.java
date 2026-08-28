package binarytree;

import java.util.LinkedList;
import java.util.Queue;

public class MaximumLevelSumBinaryTree {

    public static void main(String[] args) {
        MaximumLevelSumBinaryTree maxLevelSumBinaryTree = new MaximumLevelSumBinaryTree();
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(7);
        root.right = new TreeNode(0);
        root.left.left = new TreeNode(7);
        root.left.right = new TreeNode(-8);

        int result = maxLevelSumBinaryTree.maxLevelSum(root);
        System.out.println("Maximum Level Sum: " + result); // Output: Maximum Level Sum: 2
    }

    public int maxLevelSum(TreeNode root) {
        Queue<TreeNode> que = new LinkedList<>();
        que.add(root);
        int max = Integer.MIN_VALUE;
        int level = 0;
        int finalLev = 0;
        while(!que.isEmpty()){
            int len = que.size();
            int sum = 0;
            ++level;
            while(len > 0){
                TreeNode node = que.poll();
                sum += node.val;
                if(node.left != null){
                    que.add(node.left);
                }
                if(node.right != null){
                    que.add(node.right);
                }
                len--;
            }
            if(sum > max){
                finalLev = level;
                max = sum;
            }
        }

        return finalLev;
    }
}
