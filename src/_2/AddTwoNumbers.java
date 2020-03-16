package _2;

import java.util.ArrayList;

/*
 * Created by Rebecca Dsouza on 3/5/20
 */
public class AddTwoNumbers {
    public static void main(String[] args) {
        Solution sol = new Solution();
        ListNode l1 = ListNode.makeList(new int[]{2, 4, 3});
        ListNode l2 = ListNode.makeList(new int[]{5, 6, 4});
        ListNode.displayList(l1);
        ListNode.displayList(l2);
        ListNode.displayList(sol.addTwoNumbers(l1, l2));
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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ArrayList<Integer> al = new ArrayList<>();
        int carry = 0;
        while(l1!=null || l2!=null){
            int a = 0, b = 0;
            if(l1!=null){
                a = l1.val;
                l1 = l1.next;
            }
            if(l2!=null){
                b = l2.val;
                l2 = l2.next;
            }

            int sum = a + b + carry;
            int unit = sum%10;
            carry = sum/10;
            al.add(unit);
        }
        if(carry!=0){ al.add(carry); }
        ListNode head = new ListNode(0);
        ListNode ptr = head;
        for(int x: al){
            ptr.next = new ListNode(x);
            ptr = ptr.next;
        }
        return head.next;
    }
}
