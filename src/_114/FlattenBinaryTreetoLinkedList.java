package _114;
import java.util.*;

/*
 * Created by Rebecca Dsouza on 5/12/20
 */
public class FlattenBinaryTreetoLinkedList {
    public static void main(String[] args) {
        Solution sol = new Solution();
        sol.flatten(new TreeNode(23));
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
    Stack<TreeNode> stack = new Stack<>();
    public void function(TreeNode root){
        if(root==null) return;
        else{
            stack.push(root);
            function(root.left);
            function(root.right);
        }
    }
    public void flatten(TreeNode root) {
        function(root);
        while(stack.size()>1){
            TreeNode temp = stack.pop();
            stack.peek().left = null;
            stack.peek().right = temp;
        }
    }
}