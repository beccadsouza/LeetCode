package _17;

import java.util.*;

/*
 * Created by Rebecca Dsouza on 5/3/20
 */
public class LetterCombinationsOfAPhoneNumber {
    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(sol.letterCombinations("23"));
    }
}
class Solution {
    String[] hm = new String[]{"abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};
    List<String> al = new ArrayList<>();
    public void function(int pos, String combo, String digits){
        if(pos==digits.length()) al.add(combo);
        else{
            String mapping = hm[((int)digits.charAt(pos)-'0')-2];
            for(int i = 0;i<mapping.length();i++)
                function(pos+1,combo+mapping.substring(i,i+1),digits);
        }
    }
    public List<String> letterCombinations(String digits) {
        if(digits.length()==0) return al;
        function(0,"",digits);
        return al;
    }
}