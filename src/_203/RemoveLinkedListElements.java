package _203;
/*
* Created by Rebecca Dsouza on 7/20/20
*/

public class RemoveLinkedListElements {
    public static void main(String[] args){
        Solution sol = new Solution();
        ListNode head = sol.removeElements(new ListNode(23, null),23);
    }
}
class ListNode{
    ListNode next;
    int val;
    public ListNode(int val, ListNode next){
        this.val = val;
        this.next = next;
    }
}
class Solution {
    public ListNode removeElements(ListNode head, int val) {
        ListNode dummy = new ListNode(0, head), ptr=dummy;
        while(ptr.next != null)
            if(ptr.next.val==val) ptr.next = ptr.next.next;
            else ptr = ptr.next;
        return dummy.next;
    }
}