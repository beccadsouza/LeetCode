package _1430;

/*
 * Created by Rebecca Dsouza on 4/30/20
 */
public class CheckIfaStringIsaValidSequencefromRoottoLeavesPathinaBinaryTree {
    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(sol.isValidSequence(new TreeNode(15,null,null),new int[]{15}));
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
    int[] array;
    public boolean function(TreeNode root, int pos){
        if(root.left==null && root.right==null){
            if(root.val==array[pos] && pos==array.length-1) return true;
            else return false;
        }
        else if(pos==array.length-1) return false;
        else{
            if(root.val==array[pos]){
                boolean left = false,right = false;
                if(root.left!=null) left = function(root.left,pos+1);
                if(root.right!=null) right = function(root.right,pos+1);
                return left || right;
            }
            else return false;
        }
    }
    public boolean isValidSequence(TreeNode root, int[] arr) {
        array = arr;
        return function(root, 0);
    }
}