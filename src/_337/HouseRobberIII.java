package _337;

/*
 * Created by Rebecca Dsouza on 6/20/20
 */
public class HouseRobberIII {
    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(sol.rob(new TreeNode(23)));
    }
}
class TreeNode{
    TreeNode left, right;
    int val;
    public TreeNode(int val){
        this.val = val;
    }
}
class Pair{
    int genx;
    int geny;
    public Pair(int genx, int geny){
        this.genx = genx;
        this.geny = geny;
    }
}
class Solution {
    public Pair function(TreeNode node){
        if(node.left==null && node.right==null) return new Pair(0, node.val);
        else{
            int z = node.val, x1=0,y1=0,x2=0,y2=0;
            if(node.left!=null){
                Pair left = function(node.left);
                x1 = left.genx;
                y1 = left.geny;
            }
            if(node.right!=null){
                Pair right = function(node.right);
                x2 = right.genx;
                y2 = right.geny;
            }
            int gc = Math.max(x1, y1) + Math.max(x2, y2);
            int c = Math.max(Math.max(Math.max(Math.max(z+x1+x2,x1+x2),y1+y2),x1+y2),y1+x2);
            return new Pair(gc, c);
        }
    }
    public int rob(TreeNode root) {
        if(root==null) return 0;
        Pair ans = function(root);
        return Math.max(ans.genx, ans.geny);
    }
}