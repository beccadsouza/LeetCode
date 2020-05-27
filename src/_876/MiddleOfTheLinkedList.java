package _876;

/*
 * Created by Rebecca Dsouza on 4/8/20
 */
public class MiddleOfTheLinkedList {
    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(
                sol.middleNode(ListNode.makeList(new int[]{1,2,3,4,5})).val
        );
        System.out.println(
                sol.middleNode(ListNode.makeList(new int[]{1,2,3,4,5,6})).val
        );
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
    public ListNode middleNode(ListNode head) {
        ListNode slow = head, fast = head;
        while(fast!=null && fast.next!=null){
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
}