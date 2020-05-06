package _1161;

import java.util.*;

/*
 * Created by Rebecca Dsouza on 5/6/20
 */
public class MaximumLevelSumOfABinaryTree {
    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(sol.maxLevelSum(new TreeNode(23,null,null)));
    }
}
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}
class Solution {
    HashMap<Integer,Long> hm = new HashMap<>();
    long max = Long.MIN_VALUE;
    int ans = 0;
    public void function(TreeNode root, int level){
        if(!hm.containsKey(level)) hm.put(level, 0L);
        hm.put(level, hm.get(level)+root.val);
        if(root.left!=null) function(root.left,level+1);
        if(root.right!=null) function(root.right,level+1);
    }
    public int maxLevelSum(TreeNode root) {
        function(root, 1);
        for(Map.Entry<Integer,Long> x:hm.entrySet()){
            if(x.getValue()>max){
                max = x.getValue();
                ans = x.getKey();
            }
        }
        return ans;
    }
}