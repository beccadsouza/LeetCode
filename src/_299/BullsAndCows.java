package _299;
/*
* Created by Rebecca Dsouza on 9/11/20
*/

public class BullsAndCows {
    public static void main(String[] args){
        Solution sol = new Solution();
        System.out.println(sol.getHint("1807","7810"));
        System.out.println(sol.getHint("1123","0111"));
    }
}
class Solution {
    public String getHint(String secret, String guess) {
        char[] s = secret.toCharArray(), g = guess.toCharArray();
        StringBuilder sb = new StringBuilder();
        int[] freq = new int[10];
        int a = 0, b = 0;
        for(int i=0; i<s.length; i++){
            if(s[i] == g[i]){
                g[i] = '*';
                a++;
            }
            else freq[s[i]-'0']++;
        }
        for (char c : g) {
            if (c != '*' && freq[c - '0'] > 0) {
                freq[c - '0']--;
                b++;
            }
        }
        return sb.append(a).append("A").append(b).append("B").toString();
    }
}