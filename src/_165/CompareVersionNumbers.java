package _165;
/*
* Created by Rebecca Dsouza on 9/10/20
*/

import java.util.*;

public class CompareVersionNumbers {
    public static void main(String[] args){
        Solution sol = new Solution();
        System.out.println(sol.compareVersion("0.1","1.1"));
        System.out.println(sol.compareVersion("1.0.1","1"));
        System.out.println(sol.compareVersion("7.5.2.4","7.5.3"));
        System.out.println(sol.compareVersion("1.01","1.001"));
        System.out.println(sol.compareVersion("1.0","1.0.0"));
    }
}
class Solution {
    public int compareVersion(String version1, String version2) {
        int[] v1 = Arrays.stream(version1.split("\\.")).mapToInt(Integer::parseInt).toArray();
        int[] v2 = Arrays.stream(version2.split("\\.")).mapToInt(Integer::parseInt).toArray();
        // System.out.println(Arrays.toString(v1));
        // System.out.println(Arrays.toString(v2));
        for(int i = 0;i<Math.max(v1.length,v2.length);i++){
            int x1 = 0, x2 = 0;
            if(i<v1.length) x1 = v1[i];
            if(i<v2.length) x2 = v2[i];
            if(x1!=x2){
                return (x1>x2)?1:-1;
            }
        }
        return 0;
    }
}