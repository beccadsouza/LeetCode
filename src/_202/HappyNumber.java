package _202;

import java.util.*;

/*
 * Created by Rebecca Dsouza on 4/4/20
 */
public class HappyNumber {
    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(sol.isHappy(19));
    }
}
class Solution {
    public int process(int n){
        int sum = 0;
        while(n!=0){
            sum += Math.pow(n%10,2);
            n = n/10;
        }
        return sum;
    }
    public boolean isHappy(int n) {
        HashSet<Integer> hs = new HashSet<>();
        while(!hs.contains(n)){
            hs.add(n);
            n = process(n);
            if(n==1) return true;
        }
        return false;
    }
}