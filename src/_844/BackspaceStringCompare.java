package _844;

/*
 * Created by Rebecca Dsouza on 3/15/20
 */
public class BackspaceStringCompare {
    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(sol.backspaceCompare("ab#c","ad#c"));
        System.out.println(sol.backspaceCompare("ab##","c#d#"));
        System.out.println(sol.backspaceCompare("a##c","#a#c"));
        System.out.println(sol.backspaceCompare("a#c","b"));
    }
}
class Solution {
    public boolean backspaceCompare(String S, String T) {
        StringBuilder s = new StringBuilder();
        StringBuilder t = new StringBuilder();
        int s_count = 0, t_count = 0;
        for(int i=S.length()-1;i>=0;i--)
            if(S.charAt(i)=='#') s_count++;
            else
            if(s_count>0) s_count--;
            else s.append(S.charAt(i));
        for(int i=T.length()-1;i>=0;i--)
            if(T.charAt(i)=='#') t_count++;
            else
            if(t_count>0) t_count--;
            else t.append(T.charAt(i));
        return s.toString().equals(t.toString());
    }
}