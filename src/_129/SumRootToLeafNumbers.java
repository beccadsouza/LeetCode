package _129;

/*
 * Created by Rebecca Dsouza on 3/19/20
 */
public class SumRootToLeafNumbers {
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
    public int function(TreeNode root, Integer number){
        if(root.left==null && root.right==null) return 10*number + root.val;
        else{
            int left = 0, right = 0;
            if(root.left!=null) left = function(root.left, 10*number + root.val);
            if(root.right!=null) right = function(root.right, 10*number + root.val);
            return left + right;
        }
    }
    public int sumNumbers(TreeNode root) {
        if(root == null) return 0;
        else return function(root, 0);
    }
}