package _124;

/*
 * Created by Rebecca Dsouza on 4/29/20
 */
public class BinaryTreeMaximumPathSum {
    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(sol.maxPathSum(new TreeNode(23)));
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
    int ans = Integer.MIN_VALUE;
    public int function(TreeNode root){
        if(root.left==null && root.right==null){
            ans = Math.max(ans, root.val);
            return root.val;
        }
        else{
            int p1 = root.val, p2 = 0, p3 = 0, returnValue;
            if(root.left!=null){
                p2 = function(root.left);
                if(p2<0) p2 = 0;
            }
            if(root.right!=null){
                p3 = function(root.right);
                if(p3<0) p3 = 0;
            }
            returnValue = Math.max(p1+p2,p1+p3);
            ans = Math.max(Math.max(returnValue,p1+p2+p3),ans);
            return returnValue;
        }
    }
    public int maxPathSum(TreeNode root) {
        function(root);
        return ans;
    }
}