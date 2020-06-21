package _590;

import java.util.*;

/*
 * Created by Rebecca Dsouza on 6/7/20
 */
public class NaryTreePostorderTraversal {
    public static void main(String[] args) {
        Solution sol = new Solution();
        sol.postorder(new Node(23));
    }
}

// Definition for a Node.
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
};

class Solution {
    List<Integer> al = new ArrayList<>();

    // ITERATIVE
    // public List<Integer> postorder(Node root) {
    //     if(root==null) return al;
    //     Stack<Node> stack = new Stack<>();
    //     stack.push(root);
    //     while(!stack.isEmpty()){
    //         Node curr = stack.pop();
    //         al.add(curr.val);
    //         for(Node x:curr.children) stack.push(x);
    //     }
    //     Collections.reverse(al);
    //     return al;
    // }

    // RECURSIVE
    public void function(Node node){
        if(node!=null){
            for(Node x:node.children) function(x);
            al.add(node.val);
        }
    }
    public List<Integer> postorder(Node root) {
        function(root);
        return al;
    }
}