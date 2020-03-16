package _234;

/*
 * Created by Rebecca Dsouza on 3/16/20
 */
public class PalindromeLinkedList {
    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(sol.isPalindrome(ListNode.makeList(new int[]{1,2})));
        System.out.println(sol.isPalindrome(ListNode.makeList(new int[]{1,2,2,1})));
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
    public static ListNode reverse(ListNode curr, ListNode prev){
        if(curr==null) return prev;
        ListNode futr;
        futr = curr.next;
        curr.next = prev;
        return reverse(futr, curr);
    }
    public static int getLength(ListNode ptr){
        int l = 0;
        while(ptr!=null){
            l++;
            ptr = ptr.next;
        }
        return l;
    }

}
class Solution {
    public boolean isPalindrome(ListNode head) {
        int length = ListNode.getLength(head);
        ListNode ptrA = head, ptrB = head;
        for(int i = 0; i<Math.floor(length/2);i++)  ptrB = ptrB.next;
        if(length%2==1) ptrB = ptrB.next;
        ptrB = ListNode.reverse(ptrB, null);
        for(int i = 0; i<Math.floor(length/2);i++){
            if(ptrB.val!=ptrA.val) return false;
            ptrA = ptrA.next;
            ptrB = ptrB.next;
        }
        return true;
    }
}