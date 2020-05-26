package _897;

import java.util.*;

/*
 * Created by Rebecca Dsouza on 5/15/20
 */
public class IncreasingOrderSearchTree {
    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(sol.increasingBST(new TreeNode(23)));
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
    Stack<TreeNode> stack = new Stack<>();
    public void function(TreeNode node){
        if(node.left==null && node.right==null) stack.push(node);
        else{
            if(node.left!=null) function(node.left);
            stack.push(node);
            if(node.right!=null) function(node.right);
        }
    }
    public TreeNode increasingBST(TreeNode root) {
        if(root==null) return root;
        function(root);
        while(stack.size()>1){
            TreeNode temp = stack.pop();
            stack.peek().left = null;
            stack.peek().right = temp;
        }
        return stack.peek();
    }
}