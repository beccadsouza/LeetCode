package _1315;
/*
 * Created by Rebecca Dsouza on 5/13/20
 */
public class SumOfNodesWithEvenValuedGrandparent {
    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(sol.sumEvenGrandparent(new TreeNode(23)));
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
    int ans = 0;
    public void function(TreeNode node, int grandparent, int parent){
        if(node!=null){
            if(grandparent%2==0) ans += node.val;
            function(node.left, parent, node.val);
            function(node.right,parent, node.val);
        }
    }
    public int sumEvenGrandparent(TreeNode root) {
        function(root, 1, 1);
        return ans;
    }
}