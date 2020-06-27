package _403;

import java.util.*;

/*
 * Created by Rebecca Dsouza on 6/26/20
 */
public class FrogJump {
    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(sol.canCross(new int[]{0,1,3,5,6,8,12,17}));
        System.out.println(sol.canCross(new int[]{0,1,2,3,4,8,9,11}));
    }
}
class Solution {

    Set<Integer> pos = new HashSet<>();
    Set<String> memo = new HashSet<>();
    boolean ans = false;
    int dest = -1;

    public void function(int curr, int jump){
        if(curr==dest) ans = true;
        if(!ans && jump!=0){
            String hash = curr + ":" + jump;
            if(!memo.contains(hash)){
                memo.add(hash);
                if(pos.contains(curr+jump)){
                    function(curr+jump,jump-1);
                    function(curr+jump,jump);
                    function(curr+jump,jump+1);
                }
            }
        }
    }

    public boolean canCross(int[] stones) {
        dest = stones[stones.length-1];
        for(int x: stones) pos.add(x);
        function(0,1);
        return ans;
    }

}