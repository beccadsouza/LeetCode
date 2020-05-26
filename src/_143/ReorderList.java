package _143;

import java.util.*;

/*
 * Created by Rebecca Dsouza on 5/9/20
 */
public class ReorderList {
    public static void main(String[] args) {
        Solution sol = new Solution();
        ListNode l1 = ListNode.makeList(new int[]{1,2,3,4});
        sol.reorderList(l1);
        ListNode.displayList(l1);
        ListNode l2 = ListNode.makeList(new int[]{1,2,3,4,5});
        sol.reorderList(l2);
        ListNode.displayList(l2);
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
    public int getLength(ListNode node){
        int length = 0;
        while(node!=null){
            length++;
            node = node.next;
        }
        return length;
    }
    public void reorderList(ListNode head) {
        int length = getLength(head), ignore = length/2;
        if(length<3) return;

        Stack<ListNode> stack = new Stack<>();
        ListNode ptr = head, curr = head, futr;;

        for(int i = 0;i<length;i++){
            if(i>=ignore) stack.push(ptr);
            ptr = ptr.next;
        }

        for(int i = 0;i<ignore;i++){
            futr = curr.next;
            ptr = stack.pop();
            curr.next = ptr;
            ptr.next = futr;
            if(stack.size()==1){
                if(stack.peek()==futr){
                    futr.next = null;
                    break;
                }
                else{
                    futr.next = stack.peek();
                    futr.next.next = null;
                    break;
                }
            }
            curr = futr;
        }
    }
}