package _975;

import java.util.*;

/*
 * Created by Rebecca Dsouza on 5/5/20
 */
public class OddEvenJump {
    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(sol.oddEvenJumps(new int[]{10,13,12,14,15}));
        System.out.println(sol.oddEvenJumps(new int[]{2,3,1,1,4}));
        System.out.println(sol.oddEvenJumps(new int[]{5,1,3,4,2}));
    }
}

class Solution {
    public int oddEvenJumps(int[] A) {
        HashMap<Integer,Integer> hm = new HashMap<>();
        int[] smallestGreater = new int[A.length], greatestSmaller = new int[A.length];
        boolean[] odd = new boolean[A.length], even = new boolean[A.length];
        int count=1,max=A[0],min=A[0];
        for(int i = 0;i<A.length;i++){
            max = Math.max(max,A[i]);
            min = Math.min(min,A[i]);
        }
        for(int i = A.length-1;i>=0;i--){
            smallestGreater[i] = -1;
            greatestSmaller[i] = -1;
            if(i==A.length-1){
                odd[i] = true;
                even[i] = true;
            }
            else{
                for(int j=A[i];j<max+1;j++){
                    if(hm.containsKey(j)){
                        smallestGreater[i] = hm.get(j);
                        break;
                    }
                }
                for(int j=A[i];j>min-1;j--){
                    if(hm.containsKey(j)){
                        greatestSmaller[i] = hm.get(j);
                        break;
                    }
                }
                if(smallestGreater[i]!=-1){
                    odd[i] = even[smallestGreater[i]];
                    if(odd[i]) count++;
                }
                else odd[i] = false;
                if(greatestSmaller[i]!=-1) even[i] = odd[greatestSmaller[i]];
                else even[i] = false;
            }
            hm.put(A[i],i);
        }
        return count;
    }
}