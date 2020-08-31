package _67;
/*
* Created by Rebecca Dsouza on 7/20/20
*/

import java.math.BigInteger;

public class AddBinary {
    public static void main(String[] args){
        Solution sol = new Solution();
        System.out.println(sol.addBinary("11","1"));
        System.out.println(sol.addBinary("1010","1011"));
    }
}
class Solution {
    public String addBinary(String a, String b) {
        return new BigInteger(a, 2).add(new BigInteger(b, 2)).toString(2);
    }
}