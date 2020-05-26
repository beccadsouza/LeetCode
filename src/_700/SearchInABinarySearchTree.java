package _700;
/*
 * Created by Rebecca Dsouza on 5/13/20
 */
public class SearchInABinarySearchTree {
    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(sol.searchBST(new TreeNode(23),23));
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
    TreeNode ans;
    public void function(TreeNode node, int value){
        if(node!=null){
            if(node.val==value) ans = node;
            else if(value < node.val) function(node.left, value);
            else function(node.right, value);
        }
    }
    public TreeNode searchBST(TreeNode root, int val) {
        function(root, val);
        return ans;
    }
}