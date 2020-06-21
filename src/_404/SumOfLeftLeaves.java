package _404;
/*
 * Created by Rebecca Dsouza on 6/12/20
 */
public class SumOfLeftLeaves {
    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(sol.sumOfLeftLeaves(new TreeNode(23)));
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
    int ans = 0;
    public void function(TreeNode node, int branch){
        if(node!=null){
            if(node.left==null && node.right==null && branch==0) ans += node.val;
            else{
                function(node.left, 0);
                function(node.right, 1);
            }
        }
    }
    public int sumOfLeftLeaves(TreeNode root) {
        function(root, 1);
        return ans;
    }
}