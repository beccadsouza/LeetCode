package _112;

/*
 * Created by Rebecca Dsouza on 3/19/20
 */
public class PathSum {
    public static void main(String[] args) {

    }
}
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}
class Solution {
    public boolean function(TreeNode root, int number, int sum){
        if(root.left==null && root.right==null) return (number + root.val)==sum;
        else{
            boolean left = false, right = false;
            if(root.left!=null)  left = function(root.left, number + root.val, sum);
            if(root.right!=null) right = function(root.right, number + root.val, sum);
            return left || right;
        }
    }
    public boolean hasPathSum(TreeNode root, int sum) {
        if(root==null) return false;
        else return function(root, 0, sum);
    }
}
