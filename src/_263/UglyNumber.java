package _263;

/*
 * Created by Rebecca Dsouza on 7/5/20
 */
public class UglyNumber {
    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(sol.isUgly(6));
        System.out.println(sol.isUgly(8));
        System.out.println(sol.isUgly(14));
    }
}
class Solution {
    public boolean isUgly(int num) {
        if(num<=0) return false;
        while(num%2==0) num /= 2;
        while(num%3==0) num /= 3;
        while(num%5==0) num /= 5;
        return (num==1);
    }
}