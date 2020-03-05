package _1;

import java.util.Arrays;
import java.util.HashMap;

/*
 * Created by Rebecca Dsouza on 3/5/20
 */

public class TwoSum {
    public static void main(String[] args){
        Solution sol = new Solution();
        int[] result = sol.twoSum(new int[]{2,7,11,15}, 9);
        System.out.println(Arrays.toString(result));
    }
}
class Solution{
    public int[] twoSum(int[] nums, int target){
        HashMap<Integer, Integer> hm = new HashMap<>();
        for(int i = 0; i < nums.length; i++){
            if(hm.containsKey(target - nums[i])){
                return new int[]{hm.get(target - nums[i]), i};
            }
            else{
                hm.put(nums[i], i);
            }
        }
        return new int []{0,0};
    }
}