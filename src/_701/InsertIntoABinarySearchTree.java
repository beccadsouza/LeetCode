package _701;
/*
 * Created by Rebecca Dsouza on 5/13/20
 */
public class InsertIntoABinarySearchTree {
    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(sol.insertIntoBST(new TreeNode(23),15));
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
    public void function(TreeNode root, int val){
        if(root.val > val){
            if(root.left==null) root.left = new TreeNode(val);
            else function(root.left, val);
        }
        else if(root.val < val){
            if(root.right==null) root.right = new TreeNode(val);
            else function(root.right, val);
        }
    }
    public TreeNode insertIntoBST(TreeNode root, int val) {
        if(root==null) return new TreeNode(val);
        function(root,val);
        return root;
    }
}