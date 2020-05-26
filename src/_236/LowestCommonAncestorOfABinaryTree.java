package _236;
/*
 * Created by Rebecca Dsouza on 5/23/20
 */
public class LowestCommonAncestorOfABinaryTree {
    public static void main(String[] args) {
        Solution sol = new Solution();
        TreeNode t = new TreeNode(23);
        t.left = new TreeNode(22);
        t.right = new TreeNode(24);
        System.out.println(sol.lowestCommonAncestor(t,t.left,t.right));
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
    TreeNode ans;
    public boolean function(TreeNode node, int p, int q){
        if(node!=null){
            int count = 0;
            if(function(node.left, p, q)) count++;
            if(function(node.right, p, q)) count++;
            if(node.val==p || node.val==q) count++;
            if(count>1) ans = node;
            return count!=0;
        }
        return false;
    }
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        function(root, p.val, q.val);
        return ans;
    }
}