package _560;
/*
 * Created by Rebecca Dsouza on 4/22/20
 */
public class SubarraySumEqualsK {
    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(sol.subarraySum(new int[]{1,1,1},2));
    }
}
class Solution {
    public int subarraySum(int[] nums, int k) {
        int ans = 0;
        for(int i = 0;i<nums.length;i++){
            int temp = nums[i];
            if(temp==k) ans++;
            for(int j=i+1;j<nums.length;j++){
                temp += nums[j];
                if(temp==k) ans++;
            }
        }
        return ans;
    }
}
