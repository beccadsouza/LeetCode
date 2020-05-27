package _938;
/*
 * Created by Rebecca Dsouza on 4/17/20
 */
public class RangeSumOfBST {
    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(sol.rangeSumBST(new TreeNode(23), 22,24));
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
    int sum = 0;
    public void function(TreeNode node, int L, int R){
        if(node!=null){
            if(node.val>=L && node.val<=R) sum += node.val;
            if(node.left!=null && node.val>=L) function(node.left,L,R);
            if(node.right!=null && node.val<=R) function(node.right,L,R);
        }
    }
    public int rangeSumBST(TreeNode root, int L, int R) {
        function(root, L, R);
        return sum;
    }
}

