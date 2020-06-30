package _222;
/*
 * Created by Rebecca Dsouza on 6/30/20
 */
public class CountCompleteTreeNodes {
    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(sol.countNodes(new TreeNode(23)));
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
    int last = 0;
    int height = -1;

    public void calHeight(TreeNode node) {
        if(node!=null){
            height++;
            calHeight(node.left);
        }
    }

    public void calLast(TreeNode node, int level, int id) {
        if(node!=null && last==0){
            if(level==height){
                last = id;
            }
            else{
                calLast(node.right, level+1, 2*id);
                if(last==0) calLast(node.left, level+1, 2*id-1);
            }
        }
    }

    public int countNodes(TreeNode root) {
        if(root==null) return 0;
        if(root.left==null && root.right==null) return 1;
        calHeight(root);
        calLast(root.right, 1, 2);
        calLast(root.left, 1, 1);
        return (int)Math.pow(2, height) - 1 + last;

    }
}