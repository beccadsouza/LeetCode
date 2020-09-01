package _951;
/*
* Created by Rebecca Dsouza on 8/8/20
*/

public class FlipEquivalentBinaryTrees {
    public static void main(String[] args){
        Solution sol = new Solution();
        System.out.println(sol.flipEquiv(new TreeNode(23),new TreeNode(23)));
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
    public boolean flipEquiv(TreeNode r1, TreeNode r2) {
        if(r1==null || r2==null) return (r1==null && r2==null);
        if(r1.val!=r2.val) return false;
        return (flipEquiv(r1.left,r2.left) && flipEquiv(r1.right,r2.right)) ||
                (flipEquiv(r1.left,r2.right) && flipEquiv(r1.right,r2.left));
    }
}