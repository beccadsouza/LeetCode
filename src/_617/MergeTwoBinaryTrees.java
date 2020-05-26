package _617;
/*
 * Created by Rebecca Dsouza on 5/13/20
 */
public class MergeTwoBinaryTrees {
    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(sol.mergeTrees(new TreeNode(23), new TreeNode(23)));
    }
}
class TreeNode{
    TreeNode left, right;
    int val;
    public TreeNode(int val) {
        this.val = val;
    }
}
class Solution {
    public void function(TreeNode t1, TreeNode t2){
        t1.val += t2.val;
        if(t1.left==null && t2.left!=null) t1.left = t2.left;
        else if(t1.left!=null && t2.left!=null) function(t1.left, t2.left);
        if(t1.right==null && t2.right!=null) t1.right = t2.right;
        else if(t1.right!=null && t2.right!=null) function(t1.right, t2.right);
    }
    public TreeNode mergeTrees(TreeNode t1, TreeNode t2){
        if(t1==null) return t2;
        if(t2==null) return t1;
        function(t1,t2);
        return t1;
    }
}