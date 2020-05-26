package _671;
/*
 * Created by Rebecca Dsouza on 5/20/20
 */
public class SecondMinimumNodeInABinaryTree {
    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(sol.findSecondMinimumValue(new TreeNode(23)));
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
    int min1 = -1, min2 = -1;
    public void function(TreeNode node){
        if(node!=null){
            if(node.val<min2){
                if(node.val<min1){
                    min2 = min1;
                    min1 = node.val;
                }
                else if(node.val>min1){
                    min2 = node.val;
                }
            }
            function(node.left);
            function(node.right);
        }
    }
    public int findSecondMinimumValue(TreeNode root) {
        min1 = root.val;
        if(root.left!=null){
            min2 = root.left.val+root.right.val-root.val;
            function(root.left);
            function(root.right);
        }
        return min1==min2?-1:min2;
    }
}