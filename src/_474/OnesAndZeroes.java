package _474;

import java.util.*;

/*
 * Created by Rebecca Dsouza on 7/1/20
 */

public class OnesAndZeroes {
    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(sol.findMaxForm(
            new String[]{"011","1","11","0","010","1","10","1","1","0","0","0","01111","011","11","00","11","10","1","0","0","0","0","101","001110","1","0","1","0","0","10","00100","0","10","1","1","1","011","11","11","10","10","0000","01","1","10","0"},
            44,
            39
        ));
    }
}

class Pair{
    int zeros;
    int ones;
    public Pair(int zeros, int ones){
        this.zeros = zeros;
        this.ones = ones;
    }
    public String toString(){
        return "[" + this.zeros + ":" + this.ones + "]";
    }
}

class Solution {
    Map<String, Integer> hm = new HashMap<>();
    List<Pair> al = new ArrayList<>();

    public int function(int m, int n, int index){

        if(index==al.size()) return 0;
        else{
            String key = m+":"+n+":"+index;
            if(hm.containsKey(key)) return hm.get(key);
            else{
                int maxNumber = Integer.MIN_VALUE;
                Pair temp = al.get(index);
                if(m-temp.zeros>=0 && n-temp.ones>=0){
                    maxNumber = Math.max(maxNumber, function(m-temp.zeros, n-temp.ones, index+1)+1);
                }
                maxNumber = Math.max(maxNumber, function(m, n, index+1));
                hm.put(key, maxNumber);
                return maxNumber;
            }
        }
    }

    public int findMaxForm(String[] strs, int m, int n) {
        for (String str : strs) {
            int len = str.length(), zeros = 0, ones = 0;
            for (int j = 0; j < len; j++) if (str.charAt(j) == '0') zeros++; else ones++;
            if (m >= zeros && n >= ones) {
                al.add(new Pair(zeros, ones));
            }
        }
        return function(m, n, 0);
    }
}