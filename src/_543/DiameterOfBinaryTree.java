package _543;
/*
 * Created by Rebecca Dsouza on 4/11/20
 */
public class DiameterOfBinaryTree {
    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(sol.diameterOfBinaryTree(new TreeNode(23)));
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
    int diameter = 0;
    public int getHeights(TreeNode node){
        if(node==null) return 0;
        else{
            int a = getHeights(node.left), b = getHeights(node.right);
            diameter = Math.max(diameter, a+b);
            return Math.max(a,b) + 1;
        }
    }
    public int diameterOfBinaryTree(TreeNode root) {
        getHeights(root);
        return diameter;
    }
}