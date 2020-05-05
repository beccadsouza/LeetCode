package _662;

import java.util.*;

/*
 * Created by Rebecca Dsouza on 5/5/20
 */
public class MaximumWidthOfBinaryTree {
    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(sol.widthOfBinaryTree(new TreeNode(23, null, null)));
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
    public int widthOfBinaryTree(TreeNode root) {
        if(root==null) return 0;
        if(root.left==null && root.right==null) return 1;

        Deque<TreeNode> dq = new LinkedList<>();
        dq.addLast(root);
        TreeNode temp;
        int ans=0,size;

        while(!dq.isEmpty()){
            size = dq.size();
            for(int i = 0;i<size;i++){
                temp = dq.removeFirst();
                if(temp!=null){
                    dq.addLast(temp.left);
                    dq.addLast(temp.right);
                }
                else{
                    dq.addLast(null);
                    dq.addLast(null);
                }
            }
            while(dq.peekFirst()==null && !dq.isEmpty()) dq.removeFirst();
            while(dq.peekLast()==null && !dq.isEmpty()) dq.removeLast();
            ans = Math.max(size, ans);
        }

        return ans;
    }
}