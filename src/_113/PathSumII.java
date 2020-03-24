package _113;
import java.util.*;
/*
 * Created by Rebecca Dsouza on 3/19/20
 */
public class PathSumII {
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
    public void function(TreeNode R, int V, int S, List<String> al, String P){
        if(R.left==null && R.right==null && (V+R.val)==S) al.add(P+ R.val);
        else{
            if(R.left!=null) function(R.left, V+R.val, S, al, P+R.val+",");
            if(R.right!=null)function(R.right,V+R.val, S, al, P+R.val+",");
        }
    }
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> ans = new ArrayList<>();
        List<String> al = new ArrayList<>();
        if(root==null) return ans;
        else{
            function(root, 0, sum, al, "");
            for(String x : al){
                ArrayList<Integer> temp = new ArrayList<>();
                for (String y: x.split(","))temp.add(Integer.parseInt(y));
                ans.add(temp);
            }
            return ans;
        }
    }
}