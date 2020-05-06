package _1306;

import java.util.*;

/*
 * Created by Rebecca Dsouza on 5/6/20
 */
public class JumpGameIII {
    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(sol.canReach(new int[]{4,2,3,0,3,1,2},5));
        System.out.println(sol.canReach(new int[]{4,2,3,0,3,1,2},0));
        System.out.println(sol.canReach(new int[]{3,0,2,1,2},2));
    }
}
class Solution {
    public boolean canReach(int[] arr, int start) {
        HashMap<Integer, ArrayList<Integer>> hm = new HashMap<>();
        Queue<Integer> queue = new LinkedList<>();
        boolean[] visited = new boolean[arr.length];

        for(int i = 0;i<arr.length;i++){
            hm.put(i, new ArrayList<>());
            if(i+arr[i]<arr.length) hm.get(i).add(i+arr[i]);
            if(i-arr[i]>=0) hm.get(i).add(i-arr[i]);
        }
        queue.add(start);
        while(!queue.isEmpty()){
            int currLoc = queue.poll();
            if(visited[currLoc]) continue;
            if(arr[currLoc]==0) return true;
            else{
                queue.addAll(hm.get(currLoc));
                visited[currLoc] = true;
            }
        }
        return false;
    }
}