package _210;
/*
* Created by Rebecca Dsouza on 7/18/20
*/

import java.util.*;

public class CourseScheduleII {
    public static void main(String[] args){
        Solution sol = new Solution();
        System.out.println(Arrays.toString(sol.findOrder(2, new int[][]{{1, 0}})));
        System.out.println(Arrays.toString(sol.findOrder(4, new int[][]{{1,0},{2,0},{3,1},{3,2}})));
        System.out.println(Arrays.toString(sol.findOrder(1, new int[][]{{}})));

    }
}
class Solution {
    Map<Integer, List<Integer>> adjList = new HashMap<>();
    Map<Integer, Integer> visited = new HashMap<>();
    List<Integer> ans = new ArrayList<>();
    Boolean isCyclic = false;
    public void dfs(int start){
        if(!isCyclic){
            visited.put(start,0);
            for(int dest:adjList.getOrDefault(start, new ArrayList<>()))
                if(visited.get(dest)==-1) dfs(dest);
                else if(visited.get(dest)==0) isCyclic = true;
            visited.put(start,1);
            ans.add(start);
        }
    }
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        for(int[] edge: prerequisites){
            List<Integer> temp = adjList.getOrDefault(edge[1], new ArrayList<>());
            temp.add(edge[0]);
            adjList.put(edge[1],temp);
        }
        for(int i = 0;i<numCourses;i++) visited.put(i,-1);
        for(int i = 0;i<numCourses;i++) if(visited.get(i)==-1) dfs(i);
        Collections.reverse(ans);
        return (isCyclic)?(new int[]{}):(ans.stream().mapToInt(Integer::valueOf).toArray());
    }
}