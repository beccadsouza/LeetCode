package _988;
/*
* Created by Rebecca Dsouza on 7/25/20
*/

public class SmallestStringStartingFromLeaf {
    public static void main(String[] args){
        Solution sol = new Solution();
        System.out.println(sol.smallestFromLeaf(new TreeNode(23)));
    }
}
class TreeNode{
    TreeNode left, right;
    int val;
    public TreeNode(int val){
        this.val = val;
    }
}
class Solution {
    String ans;
    public void function(TreeNode node,StringBuilder sb){
        sb.insert(0,(char)('a'+node.val));
        if(node.left==null && node.right==null){
            String temp = sb.toString();
            if(ans==null || temp.compareTo(ans)<0) ans = temp;
        }
        else{
            if(node.left!=null) function(node.left,sb);
            if(node.right!=null) function(node.right,sb);
        }
        sb.deleteCharAt(0);
    }
    public String smallestFromLeaf(TreeNode root) {
        if(root==null) return "";
        function(root,new StringBuilder());
        return ans;
    }
}