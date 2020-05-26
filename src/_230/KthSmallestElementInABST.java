package _230;
/*
 * Created by Rebecca Dsouza on 5/20/20
 */
public class KthSmallestElementInABST {
    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(sol.kthSmallest(new TreeNode(23), 1));
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
    int ans = 0, count = 0;
    public void function(TreeNode node, int k) {
        if(count<k){
            if(node.left!=null) function(node.left, k);
            count++;
            if(count==k) ans = node.val;
            if(node.right!=null) function(node.right, k);
        }
    }
    public int kthSmallest(TreeNode root, int k) {
        function(root, k);
        return ans;
    }
}