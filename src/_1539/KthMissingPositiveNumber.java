package _1539;
/*
* Created by Rebecca Dsouza on 9/1/20
*/
import java.util.*;
public class KthMissingPositiveNumber {
    public static void main(String[] args){
        Solution sol = new Solution();
        System.out.println(sol.findKthPositive(new int[]{2,3,4,7,11},5));
        System.out.println(sol.findKthPositive(new int[]{1,2,3,4},2));
    }
}
class Solution {
    public int findKthPositive(int[] arr, int k) {
        Set<Integer> hs = new HashSet<>();
        for(int x:arr) hs.add(x);
        int number = 0;
        while(k!=0){
            number++;
            if(!hs.contains(number)) k--;
        }
        return number;
    }
}