package _209;

/*
 * Created by Rebecca Dsouza on 3/14/20
 */
public class MinimumSizeSubarraySum {
    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(sol.minSubArrayLen(7, new int[]{2,3,1,2,4,3}));
    }
}
class Solution {
    public int minSubArrayLen(int s, int[] nums) {
        int front = 0, rear = 0, ans = Integer.MAX_VALUE, sum = 0;
        while(rear<nums.length){
            sum += nums[rear];
            if(sum>=s){
                ans = Math.min(ans, rear-front+1);
                sum -= nums[front];
                front +=1;
                while(sum>=s && front<nums.length){
                    ans = Math.min(ans, rear-front+1);
                    sum -= nums[front];
                    front +=1;
                }
            }
            rear += 1;
        }
        if(ans==Integer.MAX_VALUE){
            return 0;
        }
        return ans;
    }
}