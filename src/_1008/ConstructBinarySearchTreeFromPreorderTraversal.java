package _1008;
/*
 * Created by Rebecca Dsouza on 4/20/20
 */
public class ConstructBinarySearchTreeFromPreorderTraversal {
    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(sol.bstFromPreorder(new int[]{23}).val);
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
    public void function(TreeNode node, int start, int end, int[] preorder){
        if(end<start) return;
        if(start==end){
            if(preorder[start]>node.val) node.right = new TreeNode(preorder[start]);
            else node.left = new TreeNode(preorder[start]);
        }
        else{
            int leftStart=-1, rightStart=-1;
            for(int i = start; i<=end;i++){
                if(preorder[i]>node.val){
                    rightStart = i;
                    break;
                }
            }
            if(rightStart!=start || rightStart==-1){
                leftStart = start;
                node.left = new TreeNode(preorder[leftStart]);
                if(rightStart==-1) function(node.left, leftStart+1, end, preorder);
                else function(node.left, leftStart+1, rightStart-1, preorder);
            }
            if(rightStart!=-1){
                node.right = new TreeNode(preorder[rightStart]);
                function(node.right, rightStart+1, end, preorder);
            }
        }
    }
    public TreeNode bstFromPreorder(int[] preorder) {
        TreeNode root = new TreeNode(preorder[0]);
        if(preorder.length==1) return root;
        function(root, 1, preorder.length-1, preorder);
        return root;
    }
}