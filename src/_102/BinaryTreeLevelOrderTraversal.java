package _102;
import java.util.*;
/*
 * Created by Rebecca Dsouza on 3/18/20
 */
public class BinaryTreeLevelOrderTraversal {
    public static void main(String[] args) {

    }
}
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}

class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        ArrayList<Integer> tempList = new ArrayList<>();
        TreeNode tempNode;
        int size;

        if(root==null) return ans;

        if(root.left==null && root.right==null){
            tempList.add(root.val);
            ans.add(tempList);
            return ans;
        }

        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);

        while(q.size()!=0){
            size = q.size();
            tempList = new ArrayList<>();
            for(int i = 0;i<size;i++){
                tempNode = q.remove();
                tempList.add(tempNode.val);
                if(tempNode.left!=null) q.add(tempNode.left);
                if(tempNode.right!=null) q.add(tempNode.right);
            }
            ans.add(tempList);
        }
        return ans;
    }
}
