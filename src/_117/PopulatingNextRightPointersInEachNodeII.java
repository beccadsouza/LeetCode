package _117;

/*
 * Created by Rebecca Dsouza on 6/5/20
 */
public class PopulatingNextRightPointersInEachNodeII {
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

    // ITERATIVE NON CONSTANT SPACE
    // public Node connect(Node root) {
    //     if(root==null) return root;
    //     Queue<Node> q = new LinkedList<>();
    //     q.add(root);
    //     while(!q.isEmpty()){
    //         int s = q.size();
    //         for(int i = 0; i<s; i++){
    //             Node node = q.poll();
    //             if(node.left!=null) q.add(node.left);
    //             if(node.right!=null) q.add(node.right);
    //             if(i!=s-1){
    //                 node.next = q.peek();
    //             }
    //         }
    //     }
    //     return root;
    // }

    // RECURSIVE CONSTANT SPACE
    public Node connect(Node root){
        if(root!=null){
            if(root.left!=null && root.right!=null) root.left.next = root.right;
            Node nextRoot = root.next;
            while(nextRoot!=null && nextRoot.left==null && nextRoot.right==null) nextRoot = nextRoot.next;
            if(nextRoot!=null){
                Node leftChild = (root.right==null)?root.left:root.right;
                Node rightChild = (nextRoot.left==null)?nextRoot.right:nextRoot.left;
                if(leftChild!=null) leftChild.next = rightChild;
            }
            connect(root.right);
            connect(root.left);
        }
        return root;
    }
}