package _449;

/*
* Created by Rebecca Dsouza on 10/10/20
*/

import java.util.*;

public class SerializeAndDeserializeBST {
    public static void main(String[] args){
        TreeNode root = new TreeNode(23);
        Codec ser = new Codec();
        Codec deser = new Codec();
        String tree = ser.serialize(root);
        root = deser.deserialize(tree);
    }
}
class TreeNode{
    TreeNode left, right;
    int val;
    public TreeNode(int val){
        this.val = val;
    }
}
class Codec {
    public String serialize(TreeNode root) {
        if(root!=null){
            String ans = root.val + ",";
            ans += serialize(root.left);
            ans += serialize(root.right);
            return ans;
        }
        else return "";
    }
    public TreeNode helper(int[] vals, int start, int end){
        if(start>end) return null;
        TreeNode root = new TreeNode(vals[start]);
        if(start==end) return root;
        else{
            int part = -1,elem = vals[start];
            for(int i = start+1;i<=end;i++){
                if(vals[i]>elem) {
                    part = i;
                    break;
                }
            }
            if(part==-1){
                root.left = helper(vals,start+1,end);
                root.right = null;
            }
            else{
                root.left = helper(vals,start+1,part-1);
                root.right = helper(vals,part,end);
            }
        }
        return root;
    }
    public TreeNode deserialize(String data) {
        if(data.equals("")) return null;
        int[] vals = Arrays.stream(data.split(",")).mapToInt(Integer::parseInt).toArray();
        return helper(vals,0,vals.length-1);
    }
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// String tree = ser.serialize(root);
// TreeNode ans = deser.deserialize(tree);
// return ans;