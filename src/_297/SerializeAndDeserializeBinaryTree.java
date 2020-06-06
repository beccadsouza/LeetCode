package _297;

import java.util.*;

/*
 * Created by Rebecca Dsouza on 6/5/20
 */
public class SerializeAndDeserializeBinaryTree {
    public static void main(String[] args) {
        Codec codec = new Codec();
        System.out.println(codec.deserialize(codec.serialize(new TreeNode(23))).val);
    }
}
class TreeNode{
    int val;
    TreeNode left, right;
    public TreeNode(int val){
        this.val = val;
    }
}
// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.deserialize(codec.serialize(root));
class Codec {
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuilder str = new StringBuilder();
        if(root!=null){
            Queue<TreeNode> q = new LinkedList<>();
            q.add(root);
            while(!q.isEmpty()){
                int s = q.size();
                for(int i = 0; i<s; i++){
                    TreeNode node = q.poll();
                    if(node==null) str.append("null,");
                    else{
                        str.append(node.val).append(",");
                        q.add(node.left);
                        q.add(node.right);
                    }
                }
            }
        }
        return str.length()==0?"":str.toString().substring(0, str.length()-1);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        TreeNode root = null;
        if(data.length()!=0){
            String[] nodes = data.split(",");
            root = new TreeNode(Integer.parseInt(nodes[0]));
            Queue<TreeNode> q = new LinkedList<>();
            q.add(root);
            for(int i = 1; i<nodes.length;i++){
                TreeNode node = q.poll();
                if(!nodes[i].equals("null")){
                    //noinspection ConstantConditions
                    node.left = new TreeNode(Integer.parseInt(nodes[i]));
                    q.add(node.left);
                }
                i++;
                if(!nodes[i].equals("null")){
                    //noinspection ConstantConditions
                    node.right = new TreeNode(Integer.parseInt(nodes[i]));
                    q.add(node.right);
                }
            }
        }
        return root;
    }
}