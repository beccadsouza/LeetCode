package _104;

/*
 * Created by Rebecca Dsouza on 6/4/20
 */
public class MaximumDepthOfBinaryTree {
    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(sol.maxDepth(new TreeNode(23)));
    }
}
class TreeNode{
    int val;
    TreeNode left, right;
    public TreeNode(int val){
        this.val = val;
    }
}
class Solution {
    public int function(TreeNode node){
        if(node!=null){
            if(node.left==null && node.right==null) return 1;
            else return Math.max(function(node.left), function(node.right)) + 1;
        }
        return 0;
    }
    public int maxDepth(TreeNode root) {
        return function(root);
    }
}