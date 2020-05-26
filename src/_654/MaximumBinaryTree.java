package _654;

import java.util.*;

/*
 * Created by Rebecca Dsouza on 5/21/20
 */
public class MaximumBinaryTree {
    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(sol.constructMaximumBinaryTree(new int[]{23}).val);
    }
}
class TreeNode{
    TreeNode left, right;
    int val;
    public TreeNode(int val){
        this.val = val;
    }
}
class Solution {
    Map<Integer, Integer> hm = new HashMap<>();
    List<Integer> al = new ArrayList<>();
    public TreeNode function(int start, int end){
        if(start==end) return null;
        int r = Collections.max(al.subList(start, end));
        int pos = hm.get(r);
        TreeNode root = new TreeNode(r);
        root.left = function(start, pos);
        root.right = function(pos+1,end);
        return root;
    }
    public TreeNode constructMaximumBinaryTree(int[] nums) {
        for(int i = 0;i<nums.length;i++){
            al.add(nums[i]);
            hm.put(nums[i],i);
        }
        return function(0,al.size());
    }
}