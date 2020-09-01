package _797;
/*
* Created by Rebecca Dsouza on 7/25/20
*/
import java.util.*;
public class AllPathsFromSourceToTarget {
    public static void main(String[] args){
        Solution sol = new Solution();
        System.out.println(sol.allPathsSourceTarget(new int[][]{{1,2},{3},{3},{}}));
    }
}
class Solution {
    List<List<Integer>> ll = new ArrayList<>();
    public void dfs(int src, int dest, List<Integer> al, int[][] graph){
        if(src==dest) ll.add(new ArrayList<>(al));
        else{
            for(int x:graph[src]){
                al.add(x);
                dfs(x,dest,al,graph);
                al.remove(al.size()-1);
            }
        }
    }
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        List<Integer> al = new ArrayList<Integer>();
        al.add(0);
        dfs(0,graph.length-1,al,graph);
        return ll;
    }
}