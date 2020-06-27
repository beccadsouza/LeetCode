package _969;

import java.util.*;

/*
 * Created by Rebecca Dsouza on 6/27/20
 */
public class PancakeSorting {
    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(sol.pancakeSort(new int[]{3,2,4,1}));
        System.out.println(sol.pancakeSort(new int[]{1,2,3}));
    }
}
class Solution {
    List<Integer> ans = new ArrayList<>();
    public int posOfGreatestElem(int[] A, int rear){
        int pos = 0;
        for(int i = 1; i<rear; i++) if(A[pos]<A[i]) pos = i;
        return pos;
    }
    public void flip(int[] A, int k){
        ans.add(k);
        for(int i = 0; i< k/2; i++){
            int temp = A[i];
            A[i] = A[k-i-1];
            A[k-i-1] = temp;
        }
    }
    public List<Integer> pancakeSort(int[] A) {
        int rear = A.length;
        for(int i = 0; i<A.length;i++){
            int pos = posOfGreatestElem(A, rear);
            if(pos!=rear-1){
                flip(A, pos+1);
                flip(A, rear);
            }
            rear--;
        }
        return ans;
    }
}