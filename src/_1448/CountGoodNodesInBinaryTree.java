package _1448;
/*
 * Created by Rebecca Dsouza on 5/16/20
 */
public class CountGoodNodesInBinaryTree {
    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(sol.goodNodes(new TreeNode(1)));
    }
}
class TreeNode{
    int val;
    TreeNode right, left;
    public TreeNode(int val){
        this.val = val;
    }
}
class Solution {
    int count = 0;
    public void function(TreeNode node, int maxVal){
        if(node!=null){
            if(node.val>=maxVal) count++;
            function(node.left, Math.max(maxVal, node.val));
            function(node.right, Math.max(maxVal, node.val));
        }
    }
    public int goodNodes(TreeNode root) {
        function(root, root.val);
        return count;
    }
}