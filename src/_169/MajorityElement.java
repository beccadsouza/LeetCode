package _169;

/*
 * Created by Rebecca Dsouza on 5/6/20
 */
public class MajorityElement {
    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(sol.majorityElement(new int[]{3,2,3}));
        System.out.println(sol.majorityElement(new int[]{2,2,1,1,1,2,2}));
    }
}
class Solution {
    public int majorityElement(int[] nums) {
        int value=nums[0],count=0;
        for(int x:nums){
            if(x==value) count++;
            else{
                if(count==1){
                    value = x;
                    count = 1;
                }
                else count--;
            }
        }
        return value;
    }
}