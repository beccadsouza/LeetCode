package _1339;

/*
* Created by Rebecca Dsouza on 7/6/20
*/

public class MaximumProductOfSplittedBinaryTree {
    public static void main(String[] args){
        TreeNode node = new TreeNode(23);
        node.left = new TreeNode(15);
        Solution sol = new Solution();
        System.out.println(sol.maxProduct(node));
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
    long max = Long.MIN_VALUE, mod = 1000000007L, sum = 0L;

    public void calSum(TreeNode node) {
        if(node!=null){
            sum += node.val;
            calSum(node.left);
            calSum(node.right);
        }
    }

    public long calMax(TreeNode node) {
        if(node==null) return 0;
        else{
            long temp = calMax(node.left) + node.val + calMax(node.right);
            max = Math.max(max, (sum-temp)*temp);
            return temp;
        }
    }

    public int maxProduct(TreeNode root) {
        calSum(root);
        calMax(root);
        return (int)(max%mod);
    }
}