package _623;

/*
 * Created by Rebecca Dsouza on 6/12/20
 */
public class AddOneRowToTree {
    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(sol.addOneRow(new TreeNode(23),15,1));
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
    int dep, val;
    public void function(TreeNode node, int depth){
        if(node!=null){
            if(depth+1==dep){
                TreeNode dummy1 = new TreeNode(val);
                dummy1.left = node.left;
                TreeNode dummy2 = new TreeNode(val);
                dummy2.right = node.right;
                node.left = dummy1;
                node.right = dummy2;
            }
            else{
                function(node.left, depth+1);
                function(node.right, depth+1);
            }
        }
    }
    public TreeNode addOneRow(TreeNode root, int v, int d) {
        dep = d;
        val = v;
        TreeNode dummy = new TreeNode(0);
        dummy.left = root;
        function(dummy, 0);
        return dummy.left;
    }
}
