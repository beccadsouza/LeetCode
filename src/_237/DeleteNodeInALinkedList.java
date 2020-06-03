package _237;


/*
 * Created by Rebecca Dsouza on 6/2/20
 */
public class DeleteNodeInALinkedList {
    public static void main(String[] args) {
        Solution sol = new Solution();
        ListNode l = ListNode.makeList(new int[]{4,5,1,9});
        sol.deleteNode(l.next);
        ListNode.displayList(l);
    }
}
class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
    public static ListNode makeList(int[] digits){
        if(digits.length == 0){ return null; }
        ListNode head = new ListNode(digits[0]);
        ListNode ptr = head;
        for(int i = 1; i <digits.length; i++){
            ptr.next = new ListNode(digits[i]);
            ptr = ptr.next;
        }
        return head;
    }

    public static void displayList(ListNode l){
        if(l==null){ return; }
        while(l.next!=null){
            System.out.print(l.val + "->");
            l = l.next;
        }
        System.out.println(l.val);
    }
}
class Solution {
    public void deleteNode(ListNode node) {
        node.val = node.next.val;
        node.next = node.next.next;
    }
}