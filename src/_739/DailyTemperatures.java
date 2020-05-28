package _739;

import java.util.*;

/*
 * Created by Rebecca Dsouza on 4/26/20
 */
public class DailyTemperatures {
    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(Arrays.toString(sol.dailyTemperatures(new int[]{73, 74, 75, 71, 69, 72, 76, 73})));
    }
}
class Solution {
    public int[] dailyTemperatures(int[] T) {
        HashMap<Integer, Integer> hm = new HashMap<>();
        int[] ans = new int[T.length];
        for(int i = T.length-1;i>=0;i--){
            hm.put(T[i],i);
            int temp = Integer.MAX_VALUE;
            for(int j=T[i]+1;j<101;j++)
                temp = Math.min(temp, hm.getOrDefault(j, Integer.MAX_VALUE));
            if(temp==Integer.MAX_VALUE) ans[i] = 0;
            else ans[i] = temp - i;
        }
        return ans;
    }
}