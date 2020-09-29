package _139;
import java.util.*;
/*
* Created by Rebecca Dsouza on 9/29/20
*/
public class WordBreak {
    public static void main(String[] args){
        Solution sol = new Solution();
        System.out.println(sol.wordBreak("leetcode",Arrays.asList("leet", "code")));
        System.out.println(sol.wordBreak("applepenapple",Arrays.asList("apple", "pen")));
        System.out.println(sol.wordBreak("catsandog",Arrays.asList("cats", "dog", "sand", "and", "cat")));
    }
}
class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        int slen = s.length();
        boolean flag = false;
        boolean[][] dp = new boolean[slen][slen];
        Set<String> hs = new HashSet<>(wordDict);
        for(int i = 0;i<slen;i++){
            for(int j = i;j<slen;j++) dp[i][j] = (i==0 || flag) && hs.contains(s.substring(i,j+1));
            flag = false;
            for(int k = 0;k<i+1;k++) flag = flag || dp[k][i];
        }
        return flag;
    }
}