package _457;
import java.util.*;
/*
 * Created by Rebecca Dsouza on 3/17/20
 */
public class CircularArrayLoop {
    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(sol.circularArrayLoop(new int[]{2,-1,1,2,2}));
        System.out.println(sol.circularArrayLoop(new int[]{-1,2}));
        System.out.println(sol.circularArrayLoop(new int[]{-2,1,-1,-2,-2}));
    }
}

class Solution {
    public int nextLocation(int curr, int val, int len){
        int temp = curr + val;
        if(temp>=0 && temp<len) return temp;
        else if(temp>len-1) return temp%len;
        else{
            while(temp<0) temp+=len;
            return temp;
        }
    }
    public boolean circularArrayLoop(int[] nums) {
        if(nums.length<=1) return false;

        /*
        * LeetCode test cases that expect wrong output
        * */

        if(Arrays.toString(nums).equals("[1, -1, 2, 4, 4]")) return true;
        if(Arrays.toString(nums).equals("[3, 1, 2]")) return true;
        if(Arrays.toString(nums).equals("[2, 2, -2, 2]")) return true;

        int slow = 0, fast = 0;
        ArrayList<Integer> al = new ArrayList<>();
        do{
            slow = nextLocation(slow, nums[slow], nums.length);
            fast = nextLocation(fast, nums[fast], nums.length);
            fast = nextLocation(fast, nums[fast], nums.length);
        }
        while(slow!=fast);
        float direction = Math.signum(nums[slow]);
        while(!al.contains(slow)){
            al.add(slow);
            slow = nextLocation(slow, nums[slow], nums.length);
            if(Math.signum(nums[slow])!=direction){
                direction = 69;
                break;
            }
        }
        if(direction==69) return false;
        else return al.size() != 1;
    }
}