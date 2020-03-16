package _141;

/*
 * Created by Rebecca Dsouza on 3/16/20
 */
public class LinkedListCycle {
    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(sol.hasCycle(ListNode.makeList(new int[]{3,2,0,-4}, 1)));
        System.out.println(sol.hasCycle(ListNode.makeList(new int[]{1,2}, 0)));
        System.out.println(sol.hasCycle(ListNode.makeList(new int[]{1}, -1)));
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
    public boolean hasCycle(ListNode head) {
        if(head==null || head.next==null) return false;
        ListNode ptr1 = head, ptr2 = head.next;
        while(ptr1!=ptr2){
            if(ptr2==null || ptr2.next==null) return false;
            ptr1 = ptr1.next;
            ptr2 = ptr2.next.next;
        }
        return true;
    }
}