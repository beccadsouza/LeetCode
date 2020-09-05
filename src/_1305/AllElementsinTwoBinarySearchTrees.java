package _1305;
/*
* Created by Rebecca Dsouza on 9/5/20
*/
import java.util.*;
public class AllElementsinTwoBinarySearchTrees {
    public static void main(String[] args){
        Solution sol = new Solution();
        System.out.println(sol.getAllElements(new TreeNode(23),new TreeNode(15)));
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
    List<Integer> al = new ArrayList<>();
    int pointer = 0;
    public void addElement(int elem){
        if(al.size()!=0){
            while(pointer<al.size() && al.get(pointer)<elem) pointer++;
            if(pointer==al.size()) al.add(elem);
            else al.add(pointer,elem);
        }
        else al.add(elem);
    }
    public void inorder(TreeNode root, boolean first){
        if(root!=null){
            inorder(root.left, first);
            if(first) al.add(root.val);
            else addElement(root.val);
            inorder(root.right, first);
        }
    }
    public List<Integer> getAllElements(TreeNode root1, TreeNode root2) {
        inorder(root1, true);
        inorder(root2, false);
        return al;
    }
}