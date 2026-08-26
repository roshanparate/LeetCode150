package binarytree;

import java.util.ArrayList;
import java.util.List;

public class PathSumII {

    public static void main(String[] args) {
        PathSumII pathSumII = new PathSumII();
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(4);
        root.right = new TreeNode(8);
        root.left.left = new TreeNode(11);
        root.right.left = new TreeNode(13);
        root.right.right = new TreeNode(4);
        root.left.left.left = new TreeNode(7);
        root.left.left.right = new TreeNode(2);
        root.right.right.left = new TreeNode(5);
        root.right.right.right = new TreeNode(1);

        int targetSum = 22;
        List<List<Integer>> result = pathSumII.pathSum(root, targetSum);
        System.out.println("Path Sum II: " + result); // Output: Path Sum II: [[5, 4, 11, 2], [5, 8, 4, 5]]
    }

    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {

        List<List<Integer>> ans = new ArrayList<>();
        collectPathSum(root, targetSum, 0, ans, new ArrayList<>());

        return ans;
    }

    public void collectPathSum(TreeNode root, int targetSum, int target, List<List<Integer>> ans, List<Integer> list){

        if(root == null) return;

        target = root.val + target;
        list.add(root.val);
        if(root.left == null && root.right == null && target == targetSum){
            ans.add(new ArrayList(list));
        }else{
            collectPathSum(root.left, targetSum, target, ans, list);
            collectPathSum(root.right, targetSum, target, ans, list);
        }

        list.remove(list.size()-1);
    }
}
