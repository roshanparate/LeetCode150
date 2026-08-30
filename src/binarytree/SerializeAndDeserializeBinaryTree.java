package binarytree;

import java.util.LinkedList;
import java.util.Queue;

public class SerializeAndDeserializeBinaryTree {

    public static void main(String[] args) {
        SerializeAndDeserializeBinaryTree codec = new SerializeAndDeserializeBinaryTree();
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.right.left = new TreeNode(4);
        root.right.right = new TreeNode(5);

        String serialized = codec.serialize(root);
        System.out.println("Serialized: " + serialized);

        TreeNode deserializedRoot = codec.deserialize(serialized);
        System.out.println("Deserialized Root Value: " + deserializedRoot.val);
    }


    public String serialize(TreeNode root) {

        if(root == null) return "null";

        StringBuilder sb = new StringBuilder();
        Queue<TreeNode> que = new LinkedList<>();
        que.add(root);

        while(!que.isEmpty()){
            TreeNode node = que.poll();
            if(node == null){
                sb.append("null ");
                continue;
            }
            sb.append(node.val).append(" ");
            que.add(node.left);
            que.add(node.right);
        }

        return sb.toString();

    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if(data.equals("null")) return null;

        String[] nodes = data.split(" ");
        TreeNode root = new TreeNode(Integer.parseInt(nodes[0]));
        Queue<TreeNode>  que = new LinkedList<>();
        que.add(root);

        for(int i = 1; i < nodes.length; i++){
            TreeNode parent = que.poll();

            if(!nodes[i].equals("null")){
                TreeNode leftChild = new TreeNode(Integer.parseInt(nodes[i]));
                parent.left = leftChild;
                que.add(leftChild);
            }
            if(!nodes[++i].equals("null")){
                TreeNode rightChild = new TreeNode(Integer.parseInt(nodes[i]));
                parent.right = rightChild;
                que.add(rightChild);
            }
        }

        return root;
    }
}
