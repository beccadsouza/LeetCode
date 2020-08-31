package _151;
/*
* Created by Rebecca Dsouza on 7/16/20
*/

public class ReverseWordsInAString {
    public static void main(String[] args){
        Solution sol = new Solution();
        System.out.println(sol.reverseWords("the sky is blue"));
        System.out.println(sol.reverseWords("  hello world!  "));
        System.out.println(sol.reverseWords("a good   example"));
    }
}
class Solution {
    public String reverseWords(String s) {
        StringBuilder sb = new StringBuilder();
        String[] arr = s.split(" ");
        for(int i = arr.length-1;i>=0;i--) if(arr[i].length()!=0) sb.append(arr[i]).append(" ");
        if(sb.length()>0) sb.deleteCharAt(sb.length()-1);
        return sb.toString();
    }
}