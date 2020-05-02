package _771;

import java.util.*;

/*
 * Created by Rebecca Dsouza on 5/2/20
 */
public class JewelsAndStones {
    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(sol.numJewelsInStones("aA","aAAbbbb"));
        System.out.println(sol.numJewelsInStones("z","ZZ"));
    }
}
class Solution {
    public int numJewelsInStones(String J, String S) {
        int ans = 0;
        HashSet<Character> hs = new HashSet<>();
        for(char x:J.toCharArray()) hs.add(x);
        for(char x:S.toCharArray()) if(hs.contains(x)) ans++;
        return ans;
    }
}