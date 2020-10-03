package _39;

/*
* Created by Rebecca Dsouza on 10/2/20
*/

import java.util.stream.Collectors;
import java.util.*;

public class CombinationSum {
    public static void main(String[] args){
        Solution sol = new Solution();
        System.out.println(sol.combinationSum(new int[]{2,3,6,7},7));
        System.out.println(sol.combinationSum(new int[]{2,3,5},8));
        System.out.println(sol.combinationSum(new int[]{2},1));
        System.out.println(sol.combinationSum(new int[]{1},1));
        System.out.println(sol.combinationSum(new int[]{1},2));
    }
}
class Solution {
    List<List<Integer>> al = new ArrayList<>();
    int[] candidates;
    int target;
    public void helperSum(int index, int sum, String combo){
        if(index>candidates.length-1 || sum==target){
            if(sum==target){
                List<Integer> ll = Arrays.stream(combo.split(",")).map(Integer::parseInt).collect(Collectors.toList());
                al.add(ll.subList(1,ll.size()));
            }
        }
        else{
            for(int i = index;i<candidates.length;i++){
                if((sum+candidates[i])<=target) helperSum(i,sum+candidates[i],combo+","+candidates[i]);
                else break;
            }
        }
    }
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        Arrays.sort(candidates);
        this.candidates = candidates;
        this.target = target;
        helperSum(0,0,"0");
        return al;
    }
}