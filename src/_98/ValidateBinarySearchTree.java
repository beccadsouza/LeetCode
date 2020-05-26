package _98;

import java.util.*;

/*
 * Created by Rebecca Dsouza on 5/8/20
 */
public class ValidateBinarySearchTree {
    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(sol.isValidBST(new TreeNode(23)));
    }
}
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) {
        val = x;
    }
}
class MinMax{
    int min,max;
    public MinMax(int min,int max){
        this.min = min;
        this.max = max;
    }
}

class Solution {
    boolean ans = true;
    public MinMax func(TreeNode node){
        ArrayList<Integer> al = new ArrayList<>();
        MinMax temp, reply;
        if(node.left!=null){
            temp = func(node.left);
            if(temp.max>=node.val) ans = false;
            al.add(temp.min);
            al.add(temp.max);
        }
        if(node.right!=null){
            temp = func(node.right);
            if(temp.min<=node.val) ans = false;
            al.add(temp.min);
            al.add(temp.max);
        }
        al.add(node.val);
        reply = new MinMax(Collections.min(al),Collections.max(al));
        return reply;
    }
    public boolean isValidBST(TreeNode root) {
        if(root!=null) func(root);
        return ans;
    }
}