package binarytree;

//class Triplet{
//    TreeNode parent;
//    TreeNode current;
//    int level;
//
//    public Triplet(TreeNode parent, TreeNode current, int level){
//        this.parent = parent;
//        this.current = current;
//        this.level = level;
//    }
//}

public class CousinsInBinaryTree {

    private TreeNode firstParent, secondParent;
    private int firstLevel, secondLevel;

    public static void main(String[] args) {
        CousinsInBinaryTree cousinsInBinaryTree = new CousinsInBinaryTree();
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.right = new TreeNode(4);
        root.right.right = new TreeNode(5);

        boolean result = cousinsInBinaryTree.isCousins(root, 4, 5);
        System.out.println("Are nodes 4 and 5 cousins? " + result); // Output: Are nodes 4 and 5 cousins? true
    }

    public boolean isCousins(TreeNode root, int x, int y) {
        preOrder(root, 1, null, x, y);
        return (firstParent!=secondParent && firstLevel==secondLevel);
    }

    public void preOrder(TreeNode node, int level, TreeNode parent, int x, int y) {
        if (node != null) {
            if (node.val == x) {
                firstParent = parent;
                firstLevel = level;
            }
            if (node.val == y) {
                secondParent = parent;
                secondLevel = level;
            }

            if (node.left != null) {
                preOrder(node.left, level + 1, node, x, y);
            }
            if (node.right != null) {
                preOrder(node.right, level + 1, node, x, y);
            }
        }
    }

//    public boolean isCousins(TreeNode root, int x, int y) {
//
//        if(root == null) return false;
//
//        Queue<Triplet> que = new LinkedList<>();
//        que.add(new Triplet(null, root, 1));
//
//        int level = 1;
//
//        while(!que.isEmpty()){
//            int len = que.size();
//
//            int xNodelevel = -1;
//            int yNodelevel = -1;
//
//            while(len > 0){
//                Triplet trip = que.poll();
//                level +=1;
//
//                if(trip.current.val == x){
//                    xNodelevel = trip.level;
//                }
//
//                if(trip.current.val == y){
//                    yNodelevel = trip.level;
//                }
//
//                if(trip.current.left != null){
//                    que.add(new Triplet(trip.current, trip.current.left, level));
//                }
//
//                if(trip.current.right != null){
//                    que.add(new Triplet(trip.current, trip.current.right, level));
//                }
//                len--;
//            }
//
//            if(xNodelevel != -1 && yNodelevel != -1 && xNodelevel != yNodelevel){
//                return true;
//            }
//        }
//        return false;
//    }
}
