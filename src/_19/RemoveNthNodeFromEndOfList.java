package _19;

/*
 * Created by Rebecca Dsouza on 5/11/20
 */
public class RemoveNthNodeFromEndOfList {
    public static void main(String[] args) {
        Solution sol = new Solution();
        ListNode l = ListNode.makeList(new int[]{1,2,3,4,5});
        l = sol.removeNthFromEnd(l,2);
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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode ptr1,ptr2,prevHead = new ListNode(0);
        prevHead.next = head;
        ptr1 = prevHead;
        ptr2 = prevHead;
        for(int i = 0;i<n+1;i++){
            ptr1 = ptr1.next;
        }
        while(ptr1!=null){
            ptr1 = ptr1.next;
            ptr2 = ptr2.next;
        }
        ptr2.next = ptr2.next.next;
        return prevHead.next;
    }
}