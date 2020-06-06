package _116;

/*
 * Created by Rebecca Dsouza on 6/5/20
 */
public class PopulatingNextRightPointersInEachNode {
    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(sol.connect(new Node(23)).val);
    }
}
class Node{
    Node left, right, next;
    int val;
    public Node(int val){
        this.val = val;
    }
}
class Solution {
    public void connectSiblings(Node leftChild, Node rightChild){
        if(leftChild!=null && rightChild!=null){
            leftChild.next = rightChild;
            connectSiblings(leftChild.left, leftChild.right);
            connectSiblings(leftChild.right, rightChild.left);
            connectSiblings(rightChild.left, rightChild.right);
        }
    }
    public Node connect(Node root) {
        if(root==null) return null;
        connectSiblings(root.left, root.right);
        return root;
    }
}