package _1155;

import java.util.*;
/*
 * Created by Rebecca Dsouza on 7/3/20
 */
public class NumberOfDiceRollsWithTargetSum {
    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(sol.numRollsToTarget(1,6,3));
        System.out.println(sol.numRollsToTarget(2,6,7));
        System.out.println(sol.numRollsToTarget(2,5,10));
        System.out.println(sol.numRollsToTarget(1,2,3));
//        System.out.println(sol.numRollsToTarget(30,30,500));
    }
}
class Pair<K, V> {
    Object K, V;
    public Object getKey(){
        return this.K;
    }
    public Object getValue(){
        return this.V;
    }
    public Pair(Object K, Object V){
        this.K = K;
        this.V = V;
    }
    public boolean equals(Pair<K, V> O){
        return this.K.equals(O.getKey()) && this.V.equals(O.getValue());
    }
}
class Solution {
    Map<Pair<Integer, Integer>, Integer> hm = new HashMap<>();
    int mod = 1000000007;
    public int function(int noOfDice, int maxFace, int target, int curr, int count){
        if(count==noOfDice) return (target==curr)?1:0;
        Pair<Integer, Integer> key = new Pair<>(curr, count);
        if(hm.containsKey(key)) return hm.get(key);
        int ways = 0;
        int start = Math.min(maxFace, target-curr);
        for(int i = start; i>0; i--){
            ways += function(noOfDice, maxFace, target, curr+i, count+1)%mod;
            ways = ways%mod;
        }
        hm.put(key, ways);
        return ways;
    }
    public int numRollsToTarget(int d, int f, int target) {
        return function(d, f, target, 0, 0);
    }
}