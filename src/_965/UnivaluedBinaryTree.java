package _965;

import java.util.*;

/*
 * Created by Rebecca Dsouza on 5/15/20
 */
public class UnivaluedBinaryTree {
    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(sol.isUnivalTree(new TreeNode(23)));
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
    HashSet<Integer> hs = new HashSet<>();
    public void function(TreeNode node){
        if(node!=null){
            hs.add(node.val);
            function(node.left);
            function(node.right);
        }
    }
    public boolean isUnivalTree(TreeNode root) {
        function(root);
        return hs.size()==1;
    }
}