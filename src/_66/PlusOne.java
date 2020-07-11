package _66;

import java.util.*;
/*
* Created by Rebecca Dsouza on 7/6/20
*/
public class PlusOne {
    public static void main(String[] args){
        Solution sol = new Solution();
        System.out.println(Arrays.toString(sol.plusOne(new int[]{1, 2, 3})));
        System.out.println(Arrays.toString(sol.plusOne(new int[]{4, 3, 2, 1})));
    }
}
class Solution {
    public int[] plusOne(int[] digits) {
        List<Integer> al = new ArrayList<>();
        boolean flag = false;
        for(int i=digits.length-1;i>=0;i--){
            int x = digits[i];
            if(!flag){
                if(x==9) al.add(0);
                else{
                    al.add(x+1);
                    flag = true;
                }
            }
            else al.add(x);
        }
        Collections.reverse(al);
        if(al.get(0)==0) al.add(0, 1);
        return al.stream().mapToInt(Integer::valueOf).toArray();
    }
}
