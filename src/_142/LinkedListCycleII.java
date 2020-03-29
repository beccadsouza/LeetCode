package _142;

/*
 * Created by Rebecca Dsouza on 3/24/20
 */
public class LinkedListCycleII {
    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(sol.detectCycle(ListNode.makeList(new int[]{3,2,0,-4}, 1)));
        System.out.println(sol.detectCycle(ListNode.makeList(new int[]{1,2}, 0)));
        System.out.println(sol.detectCycle(ListNode.makeList(new int[]{1}, -1)));
    }
}
class ListNode {
    int val;
    ListNode next;
    ListNode(int x) {
        val = x;
        next = null;
    }
    public static ListNode makeList(int[] values, int pos){
        if(values.length == 0){ return null; }
        ListNode head = new ListNode(values[0]);
        ListNode ptr = head;
        for(int i = 1; i <values.length; i++){
            ptr.next = new ListNode(values[i]);
            ptr = ptr.next;
        }
        if(pos!=-1) {
            ListNode temp = head;
            for (int i = 0; i < values.length; i++) {
                if (i == pos) {
                    ptr.next = temp;
                    break;
                }
                temp = temp.next;
            }
        }
        return head;
    }
}

class Solution {
    public ListNode detectCycle(ListNode head) {
        if(head==null || head.next==null) return null;
        ListNode slow = head, fast = head;
        while(fast!=null && fast.next!=null){
            slow = slow.next;
            fast = fast.next.next;
            if(slow==fast) break;
        }
        if(fast==null || fast.next==null) return null;
        else{
            ListNode ptr = head;
            while(ptr!=slow){
                slow = slow.next;
                ptr = ptr.next;
            }
            return ptr;
        }
    }
}