package _145;

import java.util.*;

/*
 * Created by Rebecca Dsouza on 6/2/20
 */
public class BinaryTreePostorderTraversal {
    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(sol.postorderTraversal(new TreeNode(23)));
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
    public List<Integer> postorderTraversal(TreeNode root) {
        if(root==null) return al;
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while(stack.size()>0){
            TreeNode curr = stack.pop();
            if(curr.left!=null) stack.push(curr.left);
            al.add(curr.val);
            if(curr.right!=null) stack.push(curr.right);
        }
        Collections.reverse(al);
        return al;
    }

    // Recursive Solution
    // public void function(TreeNode node){
    //     if(node!=null){
    //         function(node.left);
    //         function(node.right);
    //         al.add(node.val);
    //     }
    // }
    // public List<Integer> postorderTraversal(TreeNode root) {
    //     function(root);
    //     return al;
    // }
}