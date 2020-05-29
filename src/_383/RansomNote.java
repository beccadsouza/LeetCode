package _383;
/*
 * Created by Rebecca Dsouza on 5/3/20
 */
public class RansomNote {
    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(sol.canConstruct("a","b"));
        System.out.println(sol.canConstruct("aa","ab"));
        System.out.println(sol.canConstruct("aa","aab"));
    }
}
class Solution {
    public boolean canConstruct(String ransomNote, String magazine) {
        int[] freq = new int[26];
        int m = magazine.length(), r = ransomNote.length();
        for(int i = 0;i<m;i++) freq[(int)magazine.charAt(i)-97]++;
        for(int i = 0;i<r;i++)
            if(freq[(int)ransomNote.charAt(i)-97]==0) return false;
            else freq[(int)ransomNote.charAt(i)-97]--;
        return true;
    }
}