package _1446;

/*
 * Created by Rebecca Dsouza on 5/16/20
 */
public class ConsecutiveCharacters {
    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(sol.maxPower("leetcode"));
        System.out.println(sol.maxPower("abbcccddddeeeeedcba"));
        System.out.println(sol.maxPower("triplepillooooow"));
        System.out.println(sol.maxPower("hooraaaaaaaaaaay"));
        System.out.println(sol.maxPower("tourist"));
    }
}
class Solution {
    public int maxPower(String s) {
        if(s.length()==0) return 0;
        if(s.length()==1) return 1;
        int front = 0, rear = 1, max = 1, temp = 1;
        while(rear<s.length()){
            if(s.charAt(front)==s.charAt(rear)){
                temp++;
                max = Math.max(temp, max);
            }
            else{
                front = rear;
                temp = 1;
            }
            rear++;
        }
        return max;
    }
}