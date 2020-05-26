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
    public boolean isLeaf(TreeNode node){
        return node.left==null && node.right==null;
    }
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> al = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        if(root==null) return al;
        stack.add(root);
        boolean goLeft = true;
        while(!stack.isEmpty()){
            if(goLeft && stack.peek().left!=null){
                if(isLeaf(stack.peek().left)){
                    al.add(stack.peek().left.val);
                    goLeft = false;
                }
                else {
                    stack.push(stack.peek().left);
                    continue;
                }
            }
            al.add(stack.peek().val);
            TreeNode curr = stack.pop();
            if(curr.right!=null){
                if(isLeaf(curr.right)){
                    al.add(curr.right.val);
                    goLeft = false;
                }
                else{
                    stack.push(curr.right);
                    goLeft = true;
                }
            }
        }
        return al;
    }
}