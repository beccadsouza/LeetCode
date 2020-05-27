package _1317;

import java.util.*;

/*
 * Created by Rebecca Dsouza on 4/21/20
 */
public class ConvertIntegerToTheSumOfTwoNoZeroIntegers {
    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(Arrays.toString(sol.getNoZeroIntegers(2)));
        System.out.println(Arrays.toString(sol.getNoZeroIntegers(11)));
        System.out.println(Arrays.toString(sol.getNoZeroIntegers(10000)));
        System.out.println(Arrays.toString(sol.getNoZeroIntegers(69)));
        System.out.println(Arrays.toString(sol.getNoZeroIntegers(1010)));
    }
}
class Solution {
    public int[] getNoZeroIntegers(int n) {
        int a=0, b=0;
        String A, B;
        for(int i = 1;i<n;i++){
            a = i; b = n-a;
            A = String.valueOf(a); B = String.valueOf(b);
            if(!A.contains("0") && !B.contains("0")) break;
        }
        return new int[]{a, b};
    }
}