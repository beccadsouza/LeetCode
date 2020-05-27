package _826;
import java.util.*;
/*
 * Created by Rebecca Dsouza on 4/17/20
 */
public class MostProfitAssigningWork {
    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(
                sol.maxProfitAssignment(
                        new int []{2,4,6,8,10},
                        new int []{10,20,30,40,50},
                        new int []{4,5,6,7})
        );
    }
}
class Tuple{
    int para1;
    int para2;
    public Tuple(int para1, int para2){
        this.para1 = para1;
        this.para2 = para2;
    }
    public String toString(){
        return "(" + this.para1 + ", " + this.para2 + ")";
    }
}
class TupleComparator implements Comparator<Tuple>{
    public int compare(Tuple one, Tuple two){
        if(one.para1<two.para1) return -1;
        else if(one.para1==two.para1) return 0;
        else return 1;
    }
}
class Solution {
    public int maxProfitAssignment(int[] difficulty, int[] profit, int[] worker) {
        Tuple[] array = new Tuple[profit.length];
        for(int i = 0;i<profit.length;i++) array[i] = new Tuple(difficulty[i], profit[i]);
        Arrays.sort(array, new TupleComparator());
        Arrays.sort(worker);
        int workerPtr = 0, profitPtr = 0, ans = 0, max = 0;
        while(workerPtr < worker.length){
            int ability = worker[workerPtr];
            while(profitPtr<array.length && ability >= array[profitPtr].para1){
                max = Math.max(max, array[profitPtr].para2);
                profitPtr++;
            }
            ans += max;
            workerPtr++;
        }
        return ans;
    }
}