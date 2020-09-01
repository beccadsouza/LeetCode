package _258;
/*
* Created by Rebecca Dsouza on 7/26/20
*/

public class AddDigits {
    public static void main(String[] args){
        Solution sol = new Solution();
        System.out.println(sol.addDigits(38));
    }
}
class Solution {
    public int addDigits(int num) {
        if (num == 0) return 0;
        if (num % 9 == 0) return 9;
        return num % 9;
    }
}