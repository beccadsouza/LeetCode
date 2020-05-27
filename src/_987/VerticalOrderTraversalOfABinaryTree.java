package _987;

import java.util.*;

/*
 * Created by Rebecca Dsouza on 4/4/20
 */
public class VerticalOrderTraversalOfABinaryTree {
    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(sol.verticalTraversal(new TreeNode(23)));
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
    public void assignCoordinates(HashMap<String, ArrayList<Integer>> hm, TreeNode root, int X, int Y){
        if(root==null) return;
        else{
            if(root.left!=null){
                if(hm.containsKey((X-1)+","+(Y-1))) hm.get((X-1)+","+(Y-1)).add(root.left.val);
                else{
                    ArrayList<Integer> temp = new ArrayList<>();
                    temp.add(root.left.val);
                    hm.put((X-1)+","+(Y-1),temp);
                }
                assignCoordinates(hm, root.left, X-1,Y-1);
            }
            if(root.right!=null){
                if(hm.containsKey((X+1)+","+(Y-1))) hm.get((X+1)+","+(Y-1)).add(root.right.val);
                else{
                    ArrayList<Integer> temp = new ArrayList<>();
                    temp.add(root.right.val);
                    hm.put((X+1)+","+(Y-1),temp);
                }
                assignCoordinates(hm, root.right, X+1,Y-1);
            }
        }
    }
    class CoordinateComparator implements Comparator<String>{
        public int compare(String s1, String s2){
            int[] c1 = Arrays.stream(s1.split(",")).mapToInt(Integer::parseInt).toArray();
            int[] c2 = Arrays.stream(s2.split(",")).mapToInt(Integer::parseInt).toArray();
            if(c1[0]==c2[0]){
                if(c1[1]>c2[1]) return -1;
                else return 1;
            }
            else{
                if(c1[0]>c2[0]) return 1;
                else return -1;
            }
        }
    }
    public void getOrder( List<List<Integer>> al, HashMap<String, ArrayList<Integer>> hm){
        PriorityQueue<String> pq = new PriorityQueue<>(new CoordinateComparator());
        for(String x:hm.keySet()) {
            pq.add(x);
            Collections.sort(hm.get(x));
        }
        List<Integer> temp = new ArrayList<>();
        HashSet<String> hs = new HashSet<>();
        hs.add(pq.peek().split(",")[0]);
        while(pq.size()>0){
            if(hs.contains(pq.peek().split(",")[0])) temp.addAll(hm.get(pq.poll()));
            else{
                hs.add(pq.peek().split(",")[0]);
                al.add(temp);
                temp = new ArrayList<>();
                temp.addAll(hm.get(pq.poll()));
            }
        }
        al.add(temp);
    }
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        HashMap<String, ArrayList<Integer>> hm = new HashMap<>();
        ArrayList<Integer> temp = new ArrayList<>();
        temp.add(root.val);
        hm.put("0,0",temp);
        assignCoordinates(hm, root, 0, 0);
        getOrder(ans, hm);
        return ans;
    }
}