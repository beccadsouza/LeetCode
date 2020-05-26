package _872;
/*
 * Created by Rebecca Dsouza on 5/15/20
 */
public class LeafSimilarTrees {
    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(sol.leafSimilar(new TreeNode(23), new TreeNode(23)));
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
    StringBuilder[] s = new StringBuilder[2];
    public void function(TreeNode node, int id){
        if(node.left==null && node.right==null) {
            s[id].append(node.val).append("|");
        }
        else{
            if(node.left!=null) function(node.left,id);
            if(node.right!=null) function(node.right,id);
        }
    }
    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        if(root1==null || root2==null) return false;
        s[0] = new StringBuilder();
        s[1] = new StringBuilder();
        function(root1, 0);
        function(root2, 1);
        return s[0].toString().equals(s[1].toString());
    }
}