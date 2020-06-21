package _429;

import java.util.*;

/*
 * Created by Rebecca Dsouza on 6/7/20
 */
public class NaryTreeLevelOrderTraversal {
    public static void main(String[] args) {
        Solution sol = new Solution();
        sol.levelOrder(new Node(23));
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
    List<List<Integer>> al = new ArrayList<>();
    public List<List<Integer>> levelOrder(Node root) {
        if(root==null) return al;
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        while(!queue.isEmpty()){
            int size = queue.size();
            List<Integer> temp = new ArrayList<>();
            for(int i = 0;i<size;i++){
                Node curr = queue.poll();
                temp.add(curr.val);
                for(Node x:curr.children) queue.add(x);
            }
            al.add(temp);
        }
        return al;
    }
}