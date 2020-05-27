package _1417;

import java.util.*;

/*
 * Created by Rebecca Dsouza on 4/19/20
 */
public class ReformatTheString {
    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(sol.reformat("a0b1c2"));
        System.out.println(sol.reformat("leetcode"));
        System.out.println(sol.reformat("1229857369"));
        System.out.println(sol.reformat("covid2019"));
        System.out.println(sol.reformat("ab123"));
    }
}
class Solution {
    public String reformat(String s) {
        ArrayList<Character> digits = new ArrayList<>();
        ArrayList<Character> alpha = new ArrayList<>();

        for(char x:s.toCharArray())
            if((int)(x) < 65) digits.add(x);
            else alpha.add(x);

        if(Math.abs(digits.size()-alpha.size())>1) return "";
        else {

            StringBuilder ans = new StringBuilder("");
            boolean flag = true;

            ListIterator<Character> digitsPtr = digits.listIterator();
            ListIterator<Character> alphaPtr = alpha.listIterator();

            if(digits.size()==alpha.size()){
                if((int)s.charAt(0)>65){
                    flag = false;
                }
            }
            else if(digits.size()>alpha.size()){
                ans.append(digitsPtr.next());
            }
            else{
                flag = false;
                ans.append(alphaPtr.next());
            }
            while(digitsPtr.hasNext() && alphaPtr.hasNext()){
                if(flag) {
                    ans.append(alphaPtr.next());
                    ans.append(digitsPtr.next());
                }
                else{
                    ans.append(digitsPtr.next());
                    ans.append(alphaPtr.next());
                }
            }

            return ans.toString();

        }

    }
}