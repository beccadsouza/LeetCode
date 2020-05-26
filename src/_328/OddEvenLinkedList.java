package _328;
/*
 * Created by Rebecca Dsouza on 5/16/20
 */
public class OddEvenLinkedList {
    public static void main(String[] args) {
        Solution sol = new Solution();
        ListNode.displayList(sol.oddEvenList(ListNode.makeList(new int[]{1,2,3,4,5})));
        ListNode.displayList(sol.oddEvenList(ListNode.makeList(new int[]{2,1,3,5,6,4,7})));
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
    public ListNode oddEvenList(ListNode head) {
        if(head==null || head.next==null || head.next.next==null) return head;
        ListNode odd = head, even = head.next, copy = even;
        while(even.next!=null){
            odd.next = even.next;
            even.next = odd.next.next;
            odd = odd.next;
            if(even.next!=null) even = even.next;
        }
        odd.next = copy;
        return head;
    }
}