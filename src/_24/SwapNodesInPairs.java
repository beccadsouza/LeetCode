package _24;

import java.util.*;

/*
 * Created by Rebecca Dsouza on 5/9/20
 */
public class SwapNodesInPairs {
    public static void main(String[] args) {
        Solution sol = new Solution();
        ListNode l = ListNode.makeList(new int[]{1,2,3,4});
        ListNode.displayList(sol.swapPairs(l));
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
    public ListNode swapPairs(ListNode head) {
        if(head==null || head.next==null) return head;
        Stack<ListNode> stack = new Stack<>();
        while(true){
            if(head.next==null){
                stack.add(head);
                stack.peek().next = null;
                break;
            }
            stack.add(head.next);
            stack.add(head);
            if(head.next.next==null){
                stack.peek().next = null;
                break;
            }
            head = head.next.next;
        }
        while(stack.size()>1){
            ListNode temp = stack.pop();
            stack.peek().next = temp;
        }
        return stack.peek();
    }
}