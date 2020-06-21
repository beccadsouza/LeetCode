package _589;

import java.util.*;

/*
 * Created by Rebecca Dsouza on 6/7/20
 */
public class NaryTreePreorderTraversal {
    public static void main(String[] args) {
        Solution sol = new Solution();
        sol.preorder(new Node(23));
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
}


class Solution {
    List<Integer> al = new ArrayList<>();

    // ITERATIVE
    public List<Integer> preorder(Node root) {
        if(root==null) return al;
        Stack<Node> stack = new Stack<>();
        stack.push(root);
        while(!stack.isEmpty()){
            Node curr = stack.pop();
            al.add(curr.val);
            int c = curr.children.size();
            for(int i =c-1;i>=0;i--) stack.push(curr.children.get(i));
        }
        return al;
    }

    // RECURSIVE
    // public void function(Node node){
    //     if(node!=null){
    //         al.add(node.val);
    //         for(Node x:node.children) function(x);
    //     }
    // }
    // public List<Integer> preorder(Node root) {
    //     function(root);
    //     return al;
    // }
}