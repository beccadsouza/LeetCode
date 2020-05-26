package _669;
/*
 * Created by Rebecca Dsouza on 5/14/20
 */
public class TrimABinarySearchTree {
    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(sol.trimBST(new TreeNode(23),22,24));
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
    public TreeNode trimBST(TreeNode root, int L, int R) {
        if(root==null) return null;
        else if(root.left==null && root.right==null){
            if(L<=root.val && root.val<=R) return root;
            else return null;
        }
        else{
            if(L<=root.val && root.val<=R){
                root.left = trimBST(root.left,L,R);
                root.right = trimBST(root.right,L,R);
                return root;
            }
            else {
                if(L>root.val) return trimBST(root.right,L,R);
                else return trimBST(root.left,L,R);
            }
        }
    }
}
