package _784;

import java.util.*;

/*
 * Created by Rebecca Dsouza on 4/6/20
 */
public class LetterCasePermutation {
    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(sol.letterCasePermutation("a1b2"));
        System.out.println(sol.letterCasePermutation("3z4"));
        System.out.println(sol.letterCasePermutation("12345"));
    }
}
class Solution {
    public void function(String S, String X, List<String> al){
        if (X.length()==S.length()) al.add(X);
        else{
            int currPos = X.length(), ascii = (int) S.charAt(currPos);
            if(ascii<65) function(S,X+S.substring(currPos,currPos+1),al);
            else{
                function(S,X+S.substring(currPos,currPos+1).toUpperCase(),al);
                function(S,X+S.substring(currPos,currPos+1).toLowerCase(),al);
            }
        }
    }
    public List<String> letterCasePermutation(String S) {
        List<String> ans = new ArrayList<>();
        function(S,"",ans);
        return ans;
    }
}