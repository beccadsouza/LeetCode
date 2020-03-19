package _25;

/*
 * Created by Rebecca Dsouza on 3/18/20
 */
public class ReverseNodesInKGroup {
    public static void main(String[] args) {
        Solution sol = new Solution();
        ListNode l1 = ListNode.makeList(new int[]{1,2,3,4,5});
        ListNode.displayList(l1);
        ListNode.displayList(sol.reverseKGroup(l1, 2));
        ListNode l2 = ListNode.makeList(new int[]{1,2,3,4,5});
        ListNode.displayList(sol.reverseKGroup(l2, 3));
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
    public static int getLength(ListNode head){
        int len = 0;
        while(head!=null){
            len++;
            head = head.next;
        }
        return len;
    }
    public static void displayList(ListNode head){
        if(head==null){ return; }
        while(head.next!=null){
            System.out.print(head.val + "->");
            head = head.next;
        }
        System.out.println(head.val);
    }
    public static ListNode reverseBetween(ListNode h, int m, int n){
        ListNode dummy = new ListNode(0);
        dummy.next = h;
        ListNode prev1 = dummy, curr1 = dummy;
        for(int i = 0;i<m;i++){
            prev1 = curr1;
            curr1 = curr1.next;
        }
        ListNode curr2 = curr1, prev2 = prev1, futr;
        for(int i = m; i<n+1;i++){
            futr = curr2.next;
            curr2.next = prev2;
            prev2 = curr2;
            curr2 = futr;
        }
        prev1.next = prev2;
        curr1.next = curr2;
        return dummy.next;
    }
}
class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {
        int len = ListNode.getLength(head);
        for(int i = 1;i<len+1;i+=k){
            if((i+k-1)<(len+1)){
                head = ListNode.reverseBetween(head, i, (i+k-1));
            }
        }
        return head;
    }
}