package _933;

/*
* Created by Rebecca Dsouza on 10/1/20
*/

import java.util.*;

public class NumberOfRecentCalls {
    public static void main(String[] args){
        RecentCounter recentCounter = new RecentCounter();
        System.out.println(recentCounter.ping(1));     // requests = [1], range is [-2999,1], return 1
        System.out.println(recentCounter.ping(100));   // requests = [1, 100], range is [-2900,100], return 2
        System.out.println(recentCounter.ping(3001));  // requests = [1, 100, 3001], range is [1,3001], return 3
        System.out.println(recentCounter.ping(3002));  // requests = [1, 100, 3001, 3002], range is [2,3002], return 3
    }
}
class RecentCounter {
    List<Integer> al;
    int ptr;
    public RecentCounter() {
        al = new ArrayList<>();
        ptr = 0;
    }
    public int ping(int t) {
        al.add(t);
        int lower = t-3000;
        while(al.get(ptr)<lower) ptr++;
        return al.size()-ptr;
    }
}