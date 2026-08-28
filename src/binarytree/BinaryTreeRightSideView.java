package binarytree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BinaryTreeRightSideView {

    public static void main(String[] args) {
        BinaryTreeRightSideView rightSideView = new BinaryTreeRightSideView();
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.right = new TreeNode(5);
        root.right.right = new TreeNode(4);

        List<Integer> result = rightSideView.rightSideView(root);
        System.out.println("Right Side View: " + result); // Output: Right Side View: [1, 3, 4]
    }

    public List<Integer> rightSideView(TreeNode root) {

        if(root == null) return new ArrayList<>();

        List<Integer> ans = new ArrayList<>();
        Queue<TreeNode> que = new LinkedList<>();
        que.add(root);

        while(!que.isEmpty()){
            int len = que.size();

            for(int i=0 ; i < len ; i++){
                TreeNode n =  que.poll();

                if(i == len-1){
                    ans.add(n.val);
                }

                if(n.left != null){
                    que.offer(n.left);
                }

                if(n.right != null){
                    que.offer(n.right);
                }
            }
        }
        return ans;
    }
}
