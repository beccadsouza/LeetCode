package _430;

import java.util.*;

/*
 * Created by Rebecca Dsouza on 5/12/20
 */
public class FlattenAMultilevelDoublyLinkedList {
    public static void main(String[] args) {
        Solution sol = new Solution();
        Node x = sol.flatten(new Node(23));
    }
}
class Node{
    Node prev,next,child;
    int val;
    public Node(int val){
        this.val = val;
    }
}
class Solution {
    Stack<Node> stack = new Stack<>();
    public void function(Node node){
        if(node!=null){
            stack.push(node);
            if(node.child!=null) function(node.child);
            function(node.next);
        }
    }
    public Node flatten(Node head) {
        if(head==null) return null;
        function(head);
        while(stack.size()>1){
            Node temp = stack.pop();
            temp.child = null;
            temp.prev = stack.peek();
            stack.peek().next = temp;
        }
        stack.peek().prev = null;
        stack.peek().child = null;
        return stack.peek();
    }
}
