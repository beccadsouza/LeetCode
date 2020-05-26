package _993;

/*
 * Created by Rebecca Dsouza on 5/7/20
 */
public class CousinsInBinaryTree {
    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(sol.isCousins(new TreeNode(23, null, null),23,23));
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
    int p1=-1,p2=-1,d1=-1,d2=-1,n1,n2;
    public void function(TreeNode node, int depth, int parent){
        if(node!=null){
            if(node.val==n1){
                d1 = depth;
                p1 = parent;
            }
            else if(node.val==n2){
                d2 = depth;
                p2 = parent;
            }
            else{
                function(node.left,depth+1,node.val);
                function(node.right,depth+1,node.val);
            }
        }
    }
    public boolean isCousins(TreeNode root, int x, int y) {
        n1 = x;
        n2 = y;
        function(root, 0, -1);
        return (d1==d2 && p1!=p2);
    }
}