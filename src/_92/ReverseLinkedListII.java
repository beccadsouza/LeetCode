package _92;

/*
 * Created by Rebecca Dsouza on 3/18/20
 */
public class ReverseLinkedListII {
    public static void main(String[] args) {
        Solution sol = new Solution();
        ListNode l = ListNode.makeList(new int[]{1,2,3,4,5});
        ListNode.displayList(l);
        ListNode.displayList(sol.reverseBetween(l, 2, 4));
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
    /*
    *   ITERATIVE SOLUTION IN ONE PASS
    * */
    public ListNode reverseBetween(ListNode head, int m, int n) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode curr1 = dummy, prev1 = dummy;
        for(int i = 0;i<m;i++){
            prev1 = curr1;
            curr1 = curr1.next;
        }
        ListNode prev2 = prev1, curr2 = curr1, futr;
        for(int i = m;i<n+1;i++){
            futr = curr2.next;
            curr2.next = prev2;
            prev2 = curr2;
            curr2 = futr;
        }
        prev1.next = prev2;
        curr1.next = curr2;
        return dummy.next;
    }
    /*
     *   RECURSIVE SOLUTION IN TWO PASS
     * */
    /*
    public ListNode reverseList(ListNode curr, ListNode prev, int turns){
        if(turns==0) return prev;
        ListNode futr = curr.next;
        curr.next = prev;
        return reverseList(futr,curr, turns-1);
    }
    public ListNode reverseBetween(ListNode head, int m, int n) {
        if(head==null || head.next==null) return head;
        ListNode prev = head, curr, ph1, ph2;
        if(m!=1){
            for(int i = 1;i<m-1;i++) prev = prev.next;
            ph1 = prev;
            curr = prev.next;
            prev = curr;
        }
        else{
            ph1 = prev;
            curr = prev;
        }
        for(int i = m;i<n+1;i++) prev = prev.next;
        ph2 = prev;
        if(m!=1) ph1.next = reverseList(curr, ph2, n-m+1);
        else head = reverseList(curr, ph2, n-m+1);
        return head;
    }
     */
}
