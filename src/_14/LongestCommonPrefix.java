package _14;

/*
 * Created by Rebecca Dsouza on 3/7/20
 */
public class LongestCommonPrefix {
    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(sol.longestCommonPrefix(new String[]{"flower","flow","flight"}));
        System.out.println(sol.longestCommonPrefix(new String[]{"dog","racecar","car"}));
    }
}

class Solution {
    public String longestCommonPrefix(String[] strs) {
        if(strs.length==0)return "";
        int min_length = 100000;
        for (String str : strs) {
            min_length = Math.min(min_length, str.length());
        }
        StringBuilder ans = new StringBuilder();
        boolean end = false;
        for(int i = 0; i<min_length;i++){
            char temp;
            char prev = strs[0].charAt(i);
            for(int j = 1; j<strs.length;j++){
                temp = strs[j].charAt(i);
                if(prev!=temp){
                    end = true;
                    break;
                }
                prev = temp;
            }
            if(!end){
                ans.append(prev);
            }
        }
        return ans.toString();
    }
}
