package _206;

/*
 * Created by Rebecca Dsouza on 3/16/20
 */
public class ReverseLinkedList {
    public static void main(String[] args) {
        Solution sol = new Solution();
        ListNode l = ListNode.makeList(new int[]{1,2,3,4,5});
        ListNode.displayList(l);
        ListNode.displayList(sol.reverseList(l));
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
    public ListNode reverseListHelper(ListNode curr, ListNode prev){
        if(curr==null) return prev;
        ListNode futr;
        futr = curr.next;
        curr.next = prev;
        return reverseListHelper(futr, curr);
    }
    public ListNode reverseList(ListNode head) {
        return reverseListHelper(head, null);
    }

    /*
    * ITERATIVE SOLUTION
    *
    * public ListNode reverseList(ListNode head) {
    *   if(head==null || head.next==null) return head;
    *   ListNode prev = null,curr = head,futr = head.next;
    *   while(futr!=null){
    *       curr.next = prev;
    *       prev = curr;
    *       curr = futr;
    *       futr = curr.next;
    *   }
    *   curr.next = prev;
    *   return curr;
    * }
    * */

}