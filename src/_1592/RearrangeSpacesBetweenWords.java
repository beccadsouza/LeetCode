package _1592;
import java.util.*;
/*
* Created by Rebecca Dsouza on 10/4/20
*/
public class RearrangeSpacesBetweenWords {
    public static void main(String[] args){
        Solution sol = new Solution();
        System.out.println(sol.reorderSpaces("  this   is  a sentence "));
        System.out.println(sol.reorderSpaces(" practice   makes   perfect"));
        System.out.println(sol.reorderSpaces("hello   world"));
        System.out.println(sol.reorderSpaces("  walks  udp package   into  bar a"));
        System.out.println(sol.reorderSpaces("a"));
    }
}
class Solution {
    public String reorderSpaces(String text) {
        List<String> al = new ArrayList<>();
        String[] words = text.split("\\s+");
        int spaces = text.length(), pad, xtra;
        for(String word:words)
            if(word.length()!=0){
                al.add(word);
                spaces -= word.length();
            }
        pad = (al.size()==1)?0:Math.abs(spaces/(al.size()-1));
        xtra = spaces - pad*(al.size()-1);
        StringBuilder ans = new StringBuilder(al.get(0));
        for(String word:al.subList(1,al.size())) ans.append(" ".repeat(pad)).append(word);
        return ans + " ".repeat(xtra);
    }
}