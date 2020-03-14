package _338;

import java.util.Arrays;

/*
 * Created by Rebecca Dsouza on 3/9/20
 */
public class CountingBits {
    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(Arrays.toString(sol.countBits(2)));
        System.out.println(Arrays.toString(sol.countBits(5)));
    }
}

class Solution {
    public int[] countBits(int num) {
        if(num==0){
            return new int[]{0};
        }
        int[] ans = new int[num+1];
        ans[0] = 0;
        ans[1] = 1;
        int exp = 0;
        for(int i = 2; i <num+1;i++){
            exp = (int)(Math.log(i)/Math.log(2));
            ans[i] = 1 + ans[i-(int)Math.pow(2, exp)];
        }
        return ans;
    }
}
