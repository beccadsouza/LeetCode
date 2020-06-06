package _105;

import java.util.*;

/*
 * Created by Rebecca Dsouza on 6/6/20
 */
public class ConstructBinaryTreeFromPreorderAndInorderTraversal {
    public static void main(String[] args) {
        Solution sol = new Solution();
        TreeNode root = sol.buildTree(new int[]{3,9,20,15,7}, new int[]{9,3,15,20,7});
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
    int[] preArr, inoArr;
    Map<Integer, Integer> pre = new TreeMap<>(), ino = new TreeMap<>();
    public TreeNode function(int p1, int p2, int i1, int i2){
        int elem = preArr[p1];
        TreeNode root = new TreeNode(elem);
        int inoPos = ino.get(elem);
        if(p1!=p2){
            int minIndex = p2+1;
            for(int i = inoPos+1; i<=i2; i++) minIndex = Math.min(pre.get(inoArr[i]), minIndex);
            if(inoPos!=i1) root.left = function(p1+1,minIndex-1,i1, inoPos-1);
            if(inoPos!=i2) root.right = function(minIndex, p2, inoPos+1, i2);
        }
        return root;
    }
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if(preorder.length==0) return null;
        preArr = preorder;
        inoArr = inorder;
        for(int i = 0;i<preorder.length;i++) pre.put(preorder[i], i);
        for(int i = 0;i<inorder.length;i++) ino.put(inorder[i], i);
        return function(0, preorder.length-1, 0, inorder.length-1);
    }
}