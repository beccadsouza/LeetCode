package _94;

import java.util.*;

/*
 * Created by Rebecca Dsouza on 5/8/20
 */
public class BinaryTreeInorderIterativeTraversal {
    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(sol.inorderTraversal(new TreeNode(23)));
    }
}
class TreeNode{
    TreeNode left,right;
    int val;
    public TreeNode(int val){
        this.val = val;
    }
}
class Solution {
    List<Integer> al = new ArrayList<>();

    // Iterative Solution
    public List<Integer> inorderTraversal(TreeNode root) {
        if(root==null) return al;
        Stack<TreeNode> stack = new Stack<>();
        stack.add(root);
        while(stack.size()>0){
            while(stack.peek().left!=null) stack.push(stack.peek().left);
            while(stack.size()>0){
                TreeNode curr = stack.pop();
                al.add(curr.val);
                if(curr.right!=null){
                    stack.push(curr.right);
                    break;
                }
            }
        }
        return al;
    }

    // Recursive Solution
    // public void function(TreeNode node){
    //     if(node!=null){
    //         function(node.left);
    //         al.add(node.val);
    //         function(node.right);
    //     }
    // }
    // public List<Integer> inorderTraversal(TreeNode root) {
    //     function(root);
    //     return al;
    // }
}