package _100;
/*
* Created by Rebecca Dsouza on 7/13/20
*/

public class SameTree {
    public static void main(String[] args){
        Solution sol = new Solution();
        System.out.println(sol.isSameTree(new TreeNode(23),new TreeNode(23)));
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
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if(p==null && q==null) return true;
        if(p==null || q==null) return false;
        if(p.val!=q.val) return false;
        else return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }
}