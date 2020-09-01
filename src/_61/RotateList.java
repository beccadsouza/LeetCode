package _61;
/*
* Created by Rebecca Dsouza on 7/21/20
*/

public class RotateList {
    public static void main(String[] args){
        Solution sol = new Solution();
        ListNode head = sol.rotateRight(new ListNode(23),1);
    }
}
class ListNode{
    ListNode next;
    int val;
    public ListNode(int val){
        this.val = val;
    }
    public ListNode(int val, ListNode next){
        this.val = val;
        this.next = next;
    }
}
class Solution {
    public int findLength(ListNode head){
        int length = 0;
        while(head!=null) {
            head = head.next;
            length++;
        }
        return length;
    }
    public ListNode rotateRight(ListNode head, int k) {
        if(head==null || head.next==null) return head;
        int length = findLength(head);
        int K = k%length;
        if(K==0) return head;
        ListNode dummy = new ListNode(-1,head);
        for(int i = 0; i<(length-K);i++) dummy = dummy.next;
        ListNode newHead = dummy.next;
        dummy.next = null;
        dummy = newHead;
        while(dummy.next!=null) dummy = dummy.next;
        dummy.next = head;
        return newHead;
    }
}