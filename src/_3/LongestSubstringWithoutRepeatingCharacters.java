package _3;

import java.util.HashMap;

/*
 * Created by Rebecca Dsouza on 3/5/20
 */
public class LongestSubstringWithoutRepeatingCharacters {
    public static void main(String[] args){
        Solution sol = new Solution();
        System.out.println(sol.lengthOfLongestSubstring("abcabcbb"));
        System.out.println(sol.lengthOfLongestSubstring("bbbbb"));
        System.out.println(sol.lengthOfLongestSubstring("pwwkew"));
        System.out.println(sol.lengthOfLongestSubstring("abba"));
        System.out.println(sol.lengthOfLongestSubstring("aabaab!bb"));

    }
}

class Solution {
    public int lengthOfLongestSubstring(String s) {
        if(s.length()==0){
            return 0;
        }
        HashMap<Character, Integer> hm = new HashMap<>();
        for(int i = 0;i<256;i++){
            hm.put((char)(i), -1);
        }
        int ans = 1;
        int start = 0;
        int end = 1;
        char[] str = s.toLowerCase().toCharArray();
        hm.put(str[0], 0);

        while(end != str.length){
            if(hm.get(str[end])!=-1){
                int lastPos = hm.get(str[end]);
                if(start<=lastPos) {
                    ans = Math.max(ans, (end - start));
                    start = lastPos + 1;
                }
            }
            hm.put(str[end], end);
            end += 1;
        }

        return Math.max(ans, end - start);
    }
}