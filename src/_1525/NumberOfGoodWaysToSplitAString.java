package _1525;
/*
* Created by Rebecca Dsouza on 7/25/20
*/

public class NumberOfGoodWaysToSplitAString {
    public static void main(String[] args){
        Solution sol = new Solution();
        System.out.println(sol.numSplits("aacaba"));
        System.out.println(sol.numSplits("abcd"));
        System.out.println(sol.numSplits("aaaaa"));
        System.out.println(sol.numSplits("acbadbaada"));
    }
}
class Solution {
    public int numSplits(String s) {
        int size = s.length(), ans = 0;
        int[] left = new int[size], right = new int[size];
        boolean[] map = new boolean[26];
        for(int i = 0;i<size;i++){
            char x = s.charAt(i);
            if(i==0){
                map[x-'a'] = true;
                left[i] = 1;
            }
            else{
                if(map[x-'a']){
                    left[i] = left[i-1];
                }
                else{
                    map[x-'a'] = true;
                    left[i] = left[i-1]+1;
                }
            }
        }
        map = new boolean[26];
        for(int i = size-1;i>=0;i--){
            char x = s.charAt(i);
            if(i==size-1){
                map[x-'a'] = true;
                right[i] = 1;
            }
            else{
                if(map[x-'a']){
                    right[i] = right[i+1];
                }
                else{
                    map[x-'a'] = true;
                    right[i] = right[i+1]+1;
                }
            }
        }
        for(int i = 1;i<size;i++){
            if(left[i-1]==right[i]) ans++;
        }
        return ans;
    }
}