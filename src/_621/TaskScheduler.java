package _621;
import java.util.*;
/*
 * Created by Rebecca Dsouza on 3/17/20
 */
public class TaskScheduler {
    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(sol.leastInterval(new char[]{'A','A','A','B','B','B'}, 2));
    }
}
class Solution {
    public int leastInterval(char[] tasks, int n) {
        HashMap<Character, Integer> hm = new HashMap<>();
        for(char x: tasks) hm.put(x, hm.getOrDefault(x, 0)+1);
        int max_occur = 0, freq_max_occur;
        for(int x:hm.values()) max_occur = Math.max(max_occur, x);
        freq_max_occur = Collections.frequency(hm.values(), max_occur);
        return Math.max(tasks.length, (max_occur-1)*(n+1) + freq_max_occur);
    }
}