package _559;
import java.util.*;
/*
 * Created by Rebecca Dsouza on 5/13/20
 */
public class MaximumDepthOfNaryTree {
    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(sol.maxDepth(new Node(23)));
    }
}
class Node {
    public int val;
    public List<Node> children;
    public Node() {}
    public Node(int _val) {
        val = _val;
    }
    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
}
class Solution {
    int ans = 0;
    public void function(Node root, int h){
        if(root.children.size()==0) ans = Math.max(ans, h);
        else for(Node x:root.children) function(x,h+1);
    }
    public int maxDepth(Node root) {
        if(root==null) return 0;
        function(root,1);
        return ans;
    }
}