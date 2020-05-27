package _215;

import java.util.*;

/*
 * Created by Rebecca Dsouza on 4/14/20
 */
public class KthLargestElementInAArray {
    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(sol.findKthLargest(new int[]{3,2,1,5,6,4},2));
        System.out.println(sol.findKthLargest(new int[]{3,2,3,1,2,4,5,5,6},4));
    }
}
class Solution {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> heap = new PriorityQueue<>(Collections.reverseOrder());
        for(int x:nums) heap.add(x);
        for(int i = 1;i<k;i++) heap.poll();
        return heap.poll();
    }
}