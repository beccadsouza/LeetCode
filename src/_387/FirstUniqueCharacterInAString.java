package _387;

/*
 * Created by Rebecca Dsouza on 5/5/20
 */
public class FirstUniqueCharacterInAString {
    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(sol.firstUniqChar("leetcode"));
        System.out.println(sol.firstUniqChar("loveleetcode"));
    }
}
class Solution {
    public int firstUniqChar(String s) {
        int[] freq = new int[26];
        int slen = s.length();
        for(int i = 0;i<slen;i++) freq[(int)s.charAt(i)-'a']++;
        for(int i = 0;i<slen;i++) if(freq[(int)s.charAt(i)-'a']==1) return i;
        return -1;
    }
}