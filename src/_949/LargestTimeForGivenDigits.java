package _949;
/*
* Created by Rebecca Dsouza on 9/1/20
*/

import java.util.*;

public class LargestTimeForGivenDigits {
    public static void main(String[] args){
        Solution sol = new Solution();
        System.out.println(sol.largestTimeFromDigits(new int[]{1,2,3,4}));
        System.out.println(sol.largestTimeFromDigits(new int[]{5,5,5,5}));
    }
}
class Solution {
    List<String> al = new ArrayList<>();
    public void permutations(String remaining, String prefix){
        if(remaining.length()==0){
            int hh = Integer.parseInt(prefix.substring(0,2));
            int mm = Integer.parseInt(prefix.substring(2,4));
            if(hh<24 && mm<60) al.add(prefix);
        }
        else{
            for(int i = 0;i<remaining.length();i++)
                permutations(remaining.substring(0,i)+remaining.substring(i+1),prefix+remaining.substring(i,i+1));
        }
    }
    public String largestTimeFromDigits(int[] A) {
        StringBuilder sb = new StringBuilder();
        for(int x:A) sb.append(x);
        permutations(sb.toString(),"");
        Collections.sort(al);
        if(al.size()==0) return "";
        String ans = al.get(al.size()-1);
        return ans.substring(0,2)+":"+ans.substring(2,4);
    }
}