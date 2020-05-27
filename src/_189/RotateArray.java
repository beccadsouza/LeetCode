package _189;

/*
 * Created by Rebecca Dsouza on 4/1/20
 */
public class RotateArray {
    public static void main(String[] args) {
        Solution sol = new Solution();
        sol.rotate(new int[]{1,2,3,4,5,6,7},3);
        sol.rotate(new int[]{-1,-100,3,99},2);
    }
}
class Solution {

    public int gcd(int a, int b){
        if(b==0) return a;
        return gcd(b,a%b);
    }

    public int mod(int a, int b){
        return ((a%b)+b)%b;
    }

    public void rotate(int[] nums, int k) {
        int n = nums.length, r = gcd(n,k);
        for(int i = 0;i<r;i++){
            int val = nums[i], ptr = i;
            while(ptr!=mod(i+k,n)){
                nums[ptr] = nums[mod(ptr-k,n)];
                ptr = mod(ptr-k,n);
            }
            nums[ptr] = val;
        }
    }

}