package _977;

import java.util.*;

/*
 * Created by Rebecca Dsouza on 3/15/20
 */
public class SquaresOfASortedArray {
    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(Arrays.toString(sol.sortedSquares(new int[]{-4, -1, 0, 3, 10})));
        System.out.println(Arrays.toString(sol.sortedSquares(new int[]{-7,-3,2,3,11})));
    }
}

class Solution {
    public int[] sortedSquares(int[] A) {

        if(A.length==0)
            return new int[]{};
        else if(A.length==1)
            return new int[]{A[0]*A[0]};
        else{
            int neg, pos = 0;
            ArrayList<Integer> al = new ArrayList<>();

            while(pos<A.length){
                if(A[pos]>=0){
                    break;
                }
                pos++;
            }

            if(pos==0){
                for(int i = 0; i<A.length;i++){
                    al.add(A[i]*A[i]);
                }
                return al.stream().mapToInt(Integer::valueOf).toArray();
            }
            else if(pos==A.length){
                for(int i = A.length-1; i>=0;i--){
                    al.add(A[i]*A[i]);
                }
                return al.stream().mapToInt(Integer::valueOf).toArray();
            }
            else{
                neg = pos-1;
                while(al.size()!=A.length){
                    if(pos==A.length && neg!=-1){
                        al.add(A[neg]*A[neg]);
                        neg--;
                    }
                    else if(neg==-1 && pos!=A.length){
                        al.add(A[pos]*A[pos]);
                        pos++;
                    }
                    else{
                        if(Math.abs(A[pos])<Math.abs(A[neg])){
                            al.add(A[pos]*A[pos]);
                            pos++;
                        }
                        else{
                            al.add(A[neg]*A[neg]);
                            neg--;
                        }
                    }
                }
                return al.stream().mapToInt(Integer::valueOf).toArray();
            }
        }
    }
}