package _1080;

/*
 * Created by Rebecca Dsouza on 6/9/20
 */
public class InsufficientNodesInRootToLeafPaths {
    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(sol.sufficientSubset(new TreeNode(23),0).val);
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
    public int function(TreeNode node, int sum, int limit){
        if(node.left==null && node.right==null) return sum+node.val;
        else{
            int temp=sum+node.val, ans = temp, lchild, rchild;
            boolean lpath = false, rpath = false;
            if(node.left!=null){
                lchild = function(node.left, temp, limit);
                if(lchild<limit)node.left = null;
                else{
                    lpath = true;
                    ans = Math.max(temp, lchild);
                }
            }
            if(node.right!=null){
                rchild = function(node.right, temp, limit);
                if(rchild<limit) node.right = null;
                else{
                    rpath = true;
                    ans = Math.max(temp, rchild);
                }
            }
            if(lpath || rpath) return ans;
            else return Integer.MIN_VALUE;
        }
    }
    public TreeNode sufficientSubset(TreeNode root, int limit) {
        if(root==null || function(root, 0, limit)<limit) return null;
        else return root;
    }
}