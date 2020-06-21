package _179;

import java.util.*;

/*
 * Created by Rebecca Dsouza on 6/14/20
 */
public class LargestNumber {
    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(sol.largestNumber(new int[]{10,2}));
        System.out.println(sol.largestNumber(new int[]{3,30,34,5,9}));
    }
}
class CustomComparator implements Comparator<String>{
    public int compare(String num1, String num2){
        return (num2+num1).compareTo(num1+num2);
    }
}
class Solution {
    public String largestNumber(int[] nums) {
        PriorityQueue<String> pq = new PriorityQueue<>(new CustomComparator());
        StringBuilder sb = new StringBuilder();
        for(int x:nums) pq.add(String.valueOf(x));
        while(!pq.isEmpty()) sb.append(pq.poll());
        return (sb.charAt(0)=='0')?"0":sb.toString();
    }
}