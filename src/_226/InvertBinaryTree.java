package _226;

/*
 * Created by Rebecca Dsouza on 6/1/20
 */
public class InvertBinaryTree {
    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(sol.invertTree(new TreeNode(23)).val);
    }
}

class TreeNode {
     int val;
     TreeNode left;
     TreeNode right;
     TreeNode(int val) { this.val = val; }
 }

class Solution {
    public void function(TreeNode root){
        if(root!=null){
            TreeNode left = root.left;
            TreeNode right = root.right;
            root.right = left;
            root.left = right;
            function(left);
            function(right);
        }
    }
    public TreeNode invertTree(TreeNode root) {
        function(root);
        return root;
    }
}