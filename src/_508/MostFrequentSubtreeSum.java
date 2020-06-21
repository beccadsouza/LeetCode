package _508;

import java.util.*;

/*
 * Created by Rebecca Dsouza on 6/12/20
 */
public class MostFrequentSubtreeSum {
    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(Arrays.toString(sol.findFrequentTreeSum(new TreeNode(23))));
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
    Map<Integer, Integer> hm = new HashMap<>();
    List<Integer> al = new ArrayList<>();
    public int function(TreeNode node){
        if(node!=null){
            if(node.left==null && node.right==null){
                hm.put(node.val, hm.getOrDefault(node.val, 0)+1);
                return node.val;
            }
            else{
                int sum = node.val + function(node.left) + function(node.right);
                hm.put(sum, hm.getOrDefault(sum, 0)+1);
                return sum;
            }
        }
        return 0;
    }
    public int[] findFrequentTreeSum(TreeNode root) {
        if(root==null) return new int[]{};
        function(root);
        int freq = Collections.max(hm.values());
        for(Map.Entry<Integer, Integer> x: hm.entrySet()) if(x.getValue()==freq) al.add(x.getKey());
        return al.stream().mapToInt(Integer::valueOf).toArray();
    }
}