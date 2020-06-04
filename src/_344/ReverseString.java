package _344;

import java.util.*;

/*
 * Created by Rebecca Dsouza on 6/4/20
 */
public class ReverseString {
    public static void main(String[] args) {
        Solution sol = new Solution();
        char[] s = new char[]{'h','e','l','l','o'};
        sol.reverseString(s);
        System.out.println(Arrays.toString(s));
    }
}
class Solution {
    public void reverseString(char[] s) {
        for(int i = 0; i<s.length/2;i++){
            char temp = s[i];
            s[i] = s[s.length-i-1];
            s[s.length-i-1] = temp;
        }
    }
}