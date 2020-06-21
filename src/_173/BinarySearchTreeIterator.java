package _173;

import java.util.*;

/*
 * Created by Rebecca Dsouza on 6/9/20
 */
public class BinarySearchTreeIterator {
    public static void main(String[] args) {
         BSTIterator obj = new BSTIterator(new TreeNode(23));
        int param_1 = obj.next();
        boolean param_2 = obj.hasNext();
        System.out.println(param_1);
        System.out.println(param_2);
    }
}
class TreeNode{
    TreeNode left, right;
    int val;
    public TreeNode(int val){
        this.val = val;
    }
}
class BSTIterator {

    Stack<TreeNode> stack;

    public BSTIterator(TreeNode root) {
        stack = new Stack<>();
        TreeNode node = root;
        while(node!=null){
            stack.push(node);
            node = node.left;
        }
    }

    /** @return the next smallest number */
    public int next() {
        TreeNode node = stack.pop();
        int val = node.val;
        node = node.right;
        while(node!=null){
            stack.push(node);
            node = node.left;
        }
        return val;
    }

    /** @return whether we have a next smallest number */
    public boolean hasNext() {
        return stack.size()!=0;
    }
}

/**
 * Your BSTIterator object will be instantiated and called as such:
 * BSTIterator obj = new BSTIterator(root);
 * int param_1 = obj.next();
 * boolean param_2 = obj.hasNext();
 */
