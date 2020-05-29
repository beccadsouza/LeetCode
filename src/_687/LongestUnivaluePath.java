package _687;
/*
 * Created by Rebecca Dsouza on 4/30/20
 */
public class LongestUnivaluePath {
    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(sol.longestUnivaluePath(new TreeNode(23)));
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
    public int function(TreeNode node){
        if(node.left==null && node.right==null) return 0;
        else{
            int p1=0,p2=0,temp;
            if(node.left!=null){
                if(node.val==node.left.val) p1 = function(node.left)+1;
                else{
                    temp = function(node.left);
                    ans = Math.max(ans,temp);
                }
            }
            if(node.right!=null){
                if(node.val==node.right.val) p2 = function(node.right)+1;
                else{
                    temp = function(node.right);
                    ans = Math.max(ans, temp);
                }
            }
            ans = Math.max(ans, p1+p2);
            return Math.max(p1,p2);
        }
    }
    public int longestUnivaluePath(TreeNode root) {
        if(root==null) return ans;
        function(root);
        return ans;
    }
}