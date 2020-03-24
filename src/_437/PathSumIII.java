package _437;

/*
 * Created by Rebecca Dsouza on 3/20/20
 */
public class PathSumIII {
    public static void main(String[] args) {

    }
}
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) {
        val = x;
    }
}
class Solution {
    int numberPaths = 0;
    public void function(TreeNode root,int currentSum, int sum){
        if(root!=null){
            if((currentSum+root.val)==sum){
                numberPaths++;
            }
            function(root.left, currentSum+root.val,sum);
            function(root.right, currentSum+root.val,sum);
        }
    }
    public int pathSum(TreeNode root, int sum) {
        if(root!=null){
            function(root, 0, sum);
            pathSum(root.left, sum);
            pathSum(root.right, sum);
        }
        return numberPaths;
    }
}