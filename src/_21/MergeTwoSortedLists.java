package _21;
/*
 * Created by Rebecca Dsouza on 5/12/20
 */
public class MergeTwoSortedLists {
    public static void main(String[] args) {
        Solution sol = new Solution();
        ListNode.displayList(sol.mergeTwoLists(ListNode.makeList(new int[]{1,2,4}),ListNode.makeList(new int[]{1,3,4})));
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
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if(l1==null || l2==null) return l1==null?l2:l1;
        ListNode head = (l1.val<=l2.val)?l1:l2;
        ListNode ptr1 = l1, ptr2 = l2, temp;
        while(ptr1!=null && ptr2!=null){
            if(ptr1.val<=ptr2.val){
                temp = ptr1.next;
                if(ptr1.next==null || ptr1.next.val>ptr2.val) ptr1.next = ptr2;
                ptr1 = temp;
            }
            else {
                temp = ptr2.next;
                if(ptr2.next==null || ptr2.next.val>=ptr1.val) ptr2.next = ptr1;
                ptr2 = temp;
            }
        }
        return head;
    }
}

/*
cases -
both empty
one empty
unequal length
equal length
*/