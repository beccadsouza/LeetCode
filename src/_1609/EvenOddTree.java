package _1609;
/*
* Created by Rebecca Dsouza on 10/11/20
*/
import java.util.*;
public class EvenOddTree {
    public static void main(String[] args){
        Solution sol = new Solution();
        System.out.println(sol.isEvenOddTree(new TreeNode(23)));
    }
}
class TreeNode {
    TreeNode left, right;
    int val;
    public TreeNode(int val){
        this.val = val;
    }
}
class Solution {
    public boolean isEvenOddTree(TreeNode root) {
        int counter = 0, prev = 0;
        Queue<TreeNode> queue = new LinkedList<>();
        if(root==null) return true;
        queue.add(root);
        while(!queue.isEmpty()){
            int size = queue.size();
            for(int i = 0;i<size;i++){
                TreeNode temp = queue.remove();
                boolean valid = false;
                if(i==0){ // first node in each level
                    if(counter%2==0){ // even levels
                        if(temp.val%2==1){ // odd value
                            valid = true;
                        }
                    }
                    else { // odd level
                        if(temp.val%2==0){ // even value
                            valid = true;
                        }
                    }
                }
                else{ // non-first node in each level
                    if(counter%2==0){ // even levels
                        if(temp.val%2==1 && temp.val>prev){ // odd value & increasing
                            valid = true;
                        }
                    }
                    else { // odd level
                        if(temp.val%2==0 && temp.val<prev){ // even value & decreasing
                            valid = true;
                        }
                    }
                }
                // System.out.println(temp.val + " " + i);
                if(valid){
                    if(temp.left!=null) queue.add(temp.left);
                    if(temp.right!=null) queue.add(temp.right);
                    prev = temp.val;
                }
                else return false;
            }
            counter++;
        }
        return true;
    }
}