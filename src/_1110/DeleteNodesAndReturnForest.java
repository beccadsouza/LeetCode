package _1110;

import java.util.*;

/*
 * Created by Rebecca Dsouza on 6/9/20
 */
public class DeleteNodesAndReturnForest {
    public static void main(String[] args) {
        Solution sol = new Solution();
        for(TreeNode x:sol.delNodes(new TreeNode(23), new int[]{})) System.out.println(x.val);
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
    List<TreeNode> al = new ArrayList<>();
    Set<Integer> hs = new HashSet<>();
    public void findParent(TreeNode node){
        // if node if not in delete list call checkNode on node with isParent as true
        // else keep calling findParent on its children nodes
        // no need to break any ties
        if(node!=null){
            if(hs.contains(node.val)){
                findParent(node.left);
                findParent(node.right);
            }
            else checkNode(node, true);
        }
    }
    public void checkNode(TreeNode node, boolean isParent){
        if(node!=null){
            // add to list
            if(isParent) al.add(node);
            // check if children need to be deleted
            // if yes call findParent function on children and break ties
            // else call checkNode function on children with isParent as false
            if(node.left!=null){
                if(hs.contains(node.left.val)){
                    findParent(node.left);
                    node.left = null;
                }
                else checkNode(node.left, false);
            }
            if(node.right!=null){
                if(hs.contains(node.right.val)){
                    findParent(node.right);
                    node.right = null;
                }
                else checkNode(node.right, false);
            }
        }
    }
    public List<TreeNode> delNodes(TreeNode root, int[] to_delete) {
        for(int x: to_delete) hs.add(x);
        findParent(root);
        return al;
    }
}