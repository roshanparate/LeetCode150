package binarytree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BinaryTreeLevelOrderTraversal {

    public static void main(String[] args) {
        BinaryTreeLevelOrderTraversal levelOrderTraversal = new BinaryTreeLevelOrderTraversal();
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);

        List<List<Integer>> result = levelOrderTraversal.levelOrder(root);
        System.out.println("Level Order Traversal: " + result); // Output: Level Order Traversal: [[3], [9, 20], [15, 7]]
    }

    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        Queue<TreeNode> que = new LinkedList<>();

        if(root == null) return ans;
        que.add(root);

        while(!que.isEmpty()){

            List<Integer> temp = new ArrayList<>();
            int len = que.size();

            for(int i = 0; i < len; i++){
                TreeNode  node = que.poll();
                temp.add(node.val);

                if(node.left != null){
                    que.add(node.left);
                }

                if(node.right != null){
                    que.add(node.right);
                }
            }
            ans.add(temp);
        }
        return ans;
    }
}
