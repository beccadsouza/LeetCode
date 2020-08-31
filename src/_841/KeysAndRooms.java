package _841;
/*
* Created by Rebecca Dsouza on 7/16/20
*/

import java.util.*;

public class KeysAndRooms {
    public static void main(String[] args){
        Solution sol = new Solution();
        List<List<Integer>> al = new ArrayList<>();
        int[][] arr = new int[][]{{1},{2},{3},{}};
        for(int[] x:arr) al.add(new ArrayList<>(){{for (int y:x) add(y);}});
        System.out.println(sol.canVisitAllRooms(al));
    }
}
class Solution {
    boolean[] visited;
    public void function(List<List<Integer>> rooms, int start){
        visited[start] = true;
        for(int x:rooms.get(start)) if(!visited[x]) function(rooms, x);
    }
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        visited = new boolean[rooms.size()];
        function(rooms,0);
        for(boolean x:visited) if(!x) return false;
        return true;
    }
}