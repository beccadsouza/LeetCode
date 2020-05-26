package _1022;
/*
 * Created by Rebecca Dsouza on 5/15/20
 */
public class SumOfRootToLeafBinaryNumbers {
    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(sol.sumRootToLeaf(new TreeNode(1)));
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
    int sum;
    public void function(TreeNode node, int prev){
        if(node.left==null && node.right==null) sum += (prev<<1) + node.val;
        else{
            int curr = (prev<<1) + node.val;
            if(node.left!=null) function(node.left, curr);
            if(node.right!=null) function(node.right, curr);
        }
    }
    public int sumRootToLeaf(TreeNode root) {
        if(root==null) return 0;
        function(root, 0);
        return sum;
    }
}