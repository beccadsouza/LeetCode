package _1269;

import java.util.*;

/*
* Created by Rebecca Dsouza on 7/5/20
*/


public class NumberOfWaysToStayInTheSamePlaceAfterSomeSteps {
    public static void main(String[] args){
    
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

    public int function(int steps, int end, int curr){

        if(steps==0) return (curr==0)?1:0;

        Pair key = new Pair(steps, curr);
        if(hm.containsKey(key)) return hm.get(key);

        int ways = 0;
        if(curr!=end-1) ways = (ways%mod+function(steps-1, end, curr+1)%mod)%mod;
        if(curr!=0) ways = (ways%mod + function(steps-1, end, curr-1)%mod)%mod;
        ways = (ways%mod + function(steps-1, end, curr)%mod)%mod;

        hm.put(key,ways);
        return ways%mod;
    }

    public int numWays(int steps, int arrLen) {
        return function(steps, arrLen, 0);
    }

}