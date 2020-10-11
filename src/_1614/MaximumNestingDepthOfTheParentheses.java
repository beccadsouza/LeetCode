package _1614;
/*
* Created by Rebecca Dsouza on 10/11/20
*/
public class MaximumNestingDepthOfTheParentheses {
    public static void main(String[] args){
        Solution sol = new Solution();
        System.out.println(sol.maxDepth("(1+(2*3)+((8)/4))+1"));
        System.out.println(sol.maxDepth("(1)+((2))+(((3)))"));
        System.out.println(sol.maxDepth("1+(2*3)/(2-1)"));
        System.out.println(sol.maxDepth("1"));
    }
}
class Solution {
    public int maxDepth(String s) {
        StringBuilder sb = new StringBuilder();
        for(char x:s.toCharArray()) if(x=='(' || x==')') sb.append(x);
        s = sb.toString();
        int size, count = 0;
        do{
            size = s.length();
            if(size==0) break;
            s = s.replace("()","");
            count++;
        } while(s.length()!=size);
        return count;
    }
}