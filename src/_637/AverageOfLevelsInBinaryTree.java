package _637;

import java.util.*;
/*
 * Created by Rebecca Dsouza on 5/15/20
 */
public class AverageOfLevelsInBinaryTree {
    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(sol.averageOfLevels(new TreeNode(23)));
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
    public List<Double> averageOfLevels(TreeNode root) {
        List<Double> al = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        if(root==null) return al;
        queue.add(root);
        while(!queue.isEmpty()){
            int size = queue.size();
            double sum = 0;
            for(int i = 0;i<size;i++){
                TreeNode temp = queue.poll();
                sum += temp.val;
                if(temp.left!=null) queue.add(temp.left);
                if(temp.right!=null) queue.add(temp.right);
            }
            al.add(sum/size);
        }
        return al;
    }
}