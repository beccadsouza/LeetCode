package _144;

import java.util.*;

/*
 * Created by Rebecca Dsouza on 6/2/20
 */
public class BinaryTreePreorderTraversal {
    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(sol.preorderTraversal(new TreeNode(23)));
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
    List<Integer> al = new ArrayList<>();

    // Iterative Solution
    // public List<Integer> preorderTraversal(TreeNode root) {
    //     if(root==null) return al;
    //     Stack<TreeNode> stack = new Stack<>();
    //     stack.push(root);
    //     while(stack.size()>0){
    //         TreeNode curr = stack.pop();
    //         if(curr.right!=null) stack.push(curr.right);
    //         al.add(curr.val);
    //         if(curr.left!=null) stack.push(curr.left);
    //     }
    //     return al;
    // }

    // Recursive Solution
    public void function(TreeNode node){
        if(node!=null){
            al.add(node.val);
            function(node.left);
            function(node.right);
        }
    }
    public List<Integer> preorderTraversal(TreeNode root) {
        function(root);
        return al;
    }
}