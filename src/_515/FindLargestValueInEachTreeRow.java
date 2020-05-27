package _515;

import java.util.*;

/*
 * Created by Rebecca Dsouza on 4/17/20
 */
public class FindLargestValueInEachTreeRow {
    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(sol.largestValues(new TreeNode(23)));
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
    public List<Integer> largestValues(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        ArrayList<Integer> tempList = new ArrayList<>();
        TreeNode tempNode;
        Integer size;
        if(root==null) return ans;
        if(root.left==null && root.right==null){
            ans.add(root.val);
            return ans;
        }
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        while(q.size()!=0){
            size = q.size();
            tempList = new ArrayList<>();
            for(int i = 0;i<size;i++){
                tempNode = q.remove();
                tempList.add(tempNode.val);
                if(tempNode.left!=null) q.add(tempNode.left);
                if(tempNode.right!=null) q.add(tempNode.right);
            }
            ans.add(Collections.max(tempList));
        }
        return ans;
    }
}