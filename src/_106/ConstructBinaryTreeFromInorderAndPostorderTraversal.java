package _106;

import java.util.*;

/*
 * Created by Rebecca Dsouza on 6/6/20
 */
public class ConstructBinaryTreeFromInorderAndPostorderTraversal {
    public static void main(String[] args) {
        Solution sol = new Solution();
        TreeNode root = sol.buildTree(new int[]{9,3,15,20,7}, new int[]{9,15,7,20,3});
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
    int index = 0;
    Map<Integer, Integer> ino = new HashMap<>();
    public int[] reverse(int [] arr){
        int n = arr.length;
        for(int i = 0;i<n/2;i++){
            int temp = arr[i];
            arr[i] = arr[n-i-1];
            arr[n-i-1] = temp;
        }
        return arr;
    }
    public TreeNode function(int[] postorder, int l, int r){
        TreeNode root = new TreeNode(postorder[index]);
        int curr = ino.get(postorder[index]);
        index++;
        root.right = (curr+1>r)?null:function(postorder, curr+1, r);
        root.left  = (l>curr-1)?null:function(postorder, l, curr-1);
        return root;
    }
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        if(inorder.length==0) return null;
        for(int i = 0;i<inorder.length;i++) ino.put(inorder[i], i);
        return function(reverse(postorder), 0, inorder.length-1);
    }
}