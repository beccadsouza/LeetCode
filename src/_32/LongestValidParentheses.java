package _32;

import java.util.*;

/*
 * Created by Rebecca Dsouza on 5/6/20
 */
public class LongestValidParentheses {
    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(sol.longestValidParentheses("(()"));
        System.out.println(sol.longestValidParentheses(")()())"));
        // important test cases
        System.out.println(sol.longestValidParentheses("())()"));
        System.out.println(sol.longestValidParentheses("()(())"));
        System.out.println(sol.longestValidParentheses("((()())(()()))"));
    }
}
class Pair{
    int left,right;
    public Pair(int left, int right){
        this.left = left;
        this.right = right;
    }
    public String toString(){return "[" + this.left + "," + this.right +"]";}
}
class Solution {
    ArrayList<Pair> al = new ArrayList<>();
    boolean[] memo;
    public int answer(){
        int ans=0,temp=0;
        for(boolean x:memo){
            if(!x){
                ans = Math.max(temp,ans);
                temp = 0;
            }
            else temp++;
        }
        return Math.max(temp,ans);
    }
    public void boolify(String s){
        int left,right;
        for(Pair x:al){
            left = x.left-1;
            right = x.right+1;
            while(left>=0 && right<memo.length){
                if(!(memo[left]&&memo[right])){
                    if(s.charAt(left)=='(' && s.charAt(right)==')'){
                        memo[left] = true;
                        memo[right] = true;
                        left--;
                        right++;
                    }
                    else break;
                }
                else break;
            }
        }
    }
    public void combiner(){
        ArrayList<Pair> temp = new ArrayList<>();
        int left = -1,right=-1;
        for(int i = 0;i<memo.length;i++){
            if(memo[i]){
                if(left==-1) left = i;
                else right = i;
            }
            else{
                if(right!=-1){
                    temp.add(new Pair(left,right));
                    left = -1;
                    right = -1;
                }
            }
        }
        al = temp;
    }
    public int longestValidParentheses(String s) {
        if(s.length()==1) return 0;
        // generating initial list of pairs
        memo = new boolean[s.length()];
        int left = 0, right = 1, initialLength;
        while(right<s.length()){
            if(s.charAt(left)=='(' && s.charAt(right)==')'){
                al.add(new Pair(left,right));
                memo[left] = true;
                memo[right] = true;
                left++;
                right++;
            }
            left++;
            right++;
        }
        // initial boolify
        boolify(s);
        // combining patches of true
        while(true) {
            initialLength = al.size();
            combiner();
            if (al.size() != initialLength) boolify(s);
            else break;
        }
        return answer();
    }
}