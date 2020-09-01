package _199;
/*
* Created by Rebecca Dsouza on 7/21/20
*/
import java.util.*;
public class BinaryTreeRightSideView {
    public static void main(String[] args){
        Solution sol = new Solution();
        System.out.println(sol.rightSideView(new TreeNode(23)));
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
    List<Integer> al = new ArrayList<>();
    public List<Integer> rightSideView(TreeNode root) {
        if(root==null) return al;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while(!queue.isEmpty()){
            int size = queue.size();
            for(int i = 0;i<size;i++){
                TreeNode temp = queue.poll();
                if(temp.left!=null) queue.add(temp.left);
                if(temp.right!=null) queue.add(temp.right);
                if(i==size-1) al.add(temp.val);
            }
        }
        return al;
    }
}