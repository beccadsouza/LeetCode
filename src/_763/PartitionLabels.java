package _763;
/*
* Created by Rebecca Dsouza on 9/4/20
*/
import java.util.*;
public class PartitionLabels {
    public static void main(String[] args){
        Solution sol = new Solution();
        System.out.println(sol.partitionLabels("ababcbacadefegdehijhklij"));
    }
}
class Pair{
    int start, end;
    public Pair(int start, int end){
        this.start = start;
        this.end = end;
    }
    public String toString(){
        return "(" + this.start + "," + this.end + ")";
    }
}
class Solution {
//    PriorityQueue<Pair> pq = new PriorityQueue<>(
//            (a,b)->{
//                // System.out.println(a + " " + b);
//                return a.start - b.start;
//            }
//    );
    PriorityQueue<Pair> pq = new PriorityQueue<>(
            Comparator.comparingInt(a -> a.start)
    );
    Map<Character,Pair> hm = new HashMap<>();
    List<Integer> al = new ArrayList<>();
    public List<Integer> partitionLabels(String S) {
        int size = S.length();
        for(int i = 0;i<size;i++){
            char x = S.charAt(i);
            if(hm.containsKey(x)){
                Pair temp = hm.get(x);
                temp.end = i;
                hm.put(x, temp);
            }
            else hm.put(x,new Pair(i,i));

        }
        pq.addAll(hm.values());
        // System.out.println(hm);
        while(pq.size()>1){
            Pair pair1 = pq.poll();
            Pair pair2 = pq.poll();
            if(pair2.start<pair1.end){
                pq.add(new Pair(pair1.start,Math.max(pair1.end,pair2.end)));
            }
            else{
                // System.out.println(pair1);
                al.add(pair1.end-pair1.start+1);
                pq.add(pair2);
            }
        }
        if(pq.size()==1){
            // System.out.println(pq.poll());
            Pair temp = pq.poll();
            al.add(temp.end-temp.start+1);
        }
        return al;
    }
}