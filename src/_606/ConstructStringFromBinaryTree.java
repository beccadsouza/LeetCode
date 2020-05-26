package _606;
/*
 * Created by Rebecca Dsouza on 5/15/20
 */
public class ConstructStringFromBinaryTree {
    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(sol.tree2str(new TreeNode(23)));
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
    public String function(TreeNode node){
        if(node.left==null && node.right==null) return String.valueOf(node.val);
        else{
            String ans = String.valueOf(node.val);
            if(node.left==null) ans += "()";
            else ans += "(" + function(node.left) + ")";
            if(node.right!=null) ans += "(" + function(node.right) + ")";
            return ans;
        }
    }
    public String tree2str(TreeNode t) {
        if(t==null) return "";
        return function(t);
    }
}