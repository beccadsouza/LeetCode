package _283;
/*
 * Created by Rebecca Dsouza on 4/4/20
 */
public class MoveZeroes {
    public static void main(String[] args) {
        Solution sol = new Solution();
        sol.moveZeroes(new int[]{0,1,0,3,12});
    }
}
class Solution {
    public void moveZeroes(int[] nums) {
        if(nums.length<2) return;
        int z = 0, nz = 0, temp;
        while(nz < nums.length){
            while(nums[nz]==0){
                nz++;
                if(nz>=nums.length) return;
            }
            while(nums[z]!=0){
                z++;
                if(z>=nums.length) return;
            }
            if(z<nz){
                temp = nums[nz];
                nums[nz] = nums[z];
                nums[z] = temp;
            }
            else nz++;
        }
    }
}