package _140;
/*
* Created by Rebecca Dsouza on 9/29/20
*/
import java.util.*;
public class WordBreakII {
    public static void main(String[] args){
        Solution sol = new Solution();
        System.out.println(sol.wordBreak("leetcode",Arrays.asList("leet", "code")));
        System.out.println(sol.wordBreak("applepenapple",Arrays.asList("apple", "pen")));
        System.out.println(sol.wordBreak("catsandog",Arrays.asList("cats", "dog", "sand", "and", "cat")));
    }
}
class Solution {
    List<String> al = new ArrayList<>();
    public void wordBreakHelper(String s,boolean[][] dp, int col, String ans){
        if(col==-1) al.add(ans.substring(1));
        else
            for(int i = 0;i<col+1;i++)
                if(dp[i][col]) wordBreakHelper(s,dp,i-1," "+s.substring(i,col+1)+ans);

    }
    public List<String> wordBreak(String s, List<String> wordDict) {
        int slen = s.length();
        boolean flag = false;
        boolean[][] dp = new boolean[slen][slen];
        Set<String> hs = new HashSet<>(wordDict);
        for(int i = 0;i<slen;i++){
            for(int j = i;j<slen;j++) dp[i][j] = (i==0 || flag) && hs.contains(s.substring(i,j+1));
            flag = false;
            for(int k = 0;k<i+1;k++) flag = flag || dp[k][i];
        }
        wordBreakHelper(s,dp,slen-1,"");
        return al;
    }
}

/*
"leetcode", ["leet","code"]

    0   1   2   3   4   5   6   7
0   F   F   F   T   F   F   F   F
1       F   F   F   F   F   F   F
2           F   F   F   F   F   F
3               F   F   F   F   F
4                   F   F   F   T
5                       F   F   F
6                           F   F
7                               F
*/
