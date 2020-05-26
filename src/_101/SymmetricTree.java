package _101;
/*
 * Created by Rebecca Dsouza on 5/13/20
 */
public class SymmetricTree {
    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(sol.isSymmetric(new TreeNode(23)));
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
    StringBuilder left = new StringBuilder(),right = new StringBuilder();
    public void lFunction(TreeNode node){
        if(node==null) left.append("*");
        else{
            left.append(node.val);
            lFunction(node.left);
            lFunction(node.right);
        }
    }
    public void rFunction(TreeNode node){
        if(node==null) right.append("*");
        else{
            right.append(node.val);
            rFunction(node.right);
            rFunction(node.left);
        }
    }
    public boolean isSymmetric(TreeNode root) {
        lFunction(root);
        rFunction(root);
        return left.toString().equals(right.toString());
    }
}