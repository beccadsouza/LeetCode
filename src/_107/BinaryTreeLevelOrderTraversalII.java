package _107;

import java.util.*;
/*
 * Created by Rebecca Dsouza on 7/2/20
 */
public class BinaryTreeLevelOrderTraversalII {
    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(sol.levelOrderBottom(new TreeNode(23)));
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
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        Queue<TreeNode> qu = new LinkedList<>();
        List<List<Integer>> al = new ArrayList<>();
        if(root==null) return al;
        qu.add(root);
        while(!qu.isEmpty()){
            List<Integer> temp = new ArrayList<>();
            int size = qu.size();
            for(int i = 0;i<size;i++){
                TreeNode node = qu.poll();
                temp.add(node.val);
                if(node.left!=null) qu.add(node.left);
                if(node.right!=null) qu.add(node.right);
            }
            al.add(0, temp);
        }
        return al;
    }
}