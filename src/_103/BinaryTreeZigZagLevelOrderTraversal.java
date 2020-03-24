package _103;
import java.util.*;
/*
 * Created by Rebecca Dsouza on 3/19/20
 */
public class BinaryTreeZigZagLevelOrderTraversal {
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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        List<Integer> tempList = new ArrayList<>();
        TreeNode tempNode;
        Integer size, direction = 0;
        if(root==null) return ans;
        if(root.left==null && root.right==null){
            tempList.add(root.val);
            ans.add(tempList);
            return ans;
        }
        queue.add(root);
        while(queue.size()>0){
            size = queue.size();
            direction = ~direction;
            tempList = new ArrayList<>();
            for(int i = 0; i<size;i++){
                tempNode = queue.remove();
                tempList.add(tempNode.val);
                if(tempNode.left!=null) queue.add(tempNode.left);
                if(tempNode.right!=null)queue.add(tempNode.right);
            }
            if(direction==0) Collections.reverse(tempList);
            ans.add(tempList);
        }
        return ans;
    }
}