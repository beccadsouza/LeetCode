package _1414;

import java.util.*;

/*
 * Created by Rebecca Dsouza on 4/18/20
 */
public class FindTheMinimumNumberOfFibonacciNumbersWhoseSumIsK {
    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(sol.findMinFibonacciNumbers(7));
        System.out.println(sol.findMinFibonacciNumbers(10));
        System.out.println(sol.findMinFibonacciNumbers(19));
    }
}
class Solution {
    public int findMinFibonacciNumbers(int k) {
        long[] fib = new long[50];
        fib[0] = 1;
        fib[1] = 1;
        fib[2] = 2;
        TreeSet<Long> treeset = new TreeSet<>();
        treeset.add((long)1);
        treeset.add((long)2);
        for(int i = 3;fib[i-1]<=k;i++){
            fib[i] = fib[i-1] + fib[i-2];
            treeset.add(fib[i]);
        }
        int count = 0;
        SortedSet<Long> temp;
        while(k>0){
            if(treeset.contains((long)k)){
                count++;
                break;
            }
            temp = treeset.headSet((long)k);
            k -= temp.last();
            count++;
        }
        return count;
    }
}