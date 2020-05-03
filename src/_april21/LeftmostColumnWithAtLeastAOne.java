package _april21;

import java.util.*;

/*
 * Created by Rebecca Dsouza on 4/21/20
 */
public class LeftmostColumnWithAtLeastAOne {
    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(sol.leftMostColumnWithOne(new BinaryMatrix(new int[][]{{0,0},{1,1}})));
        System.out.println(sol.leftMostColumnWithOne(new BinaryMatrix(new int[][]{{0,0},{0,1}})));
        System.out.println(sol.leftMostColumnWithOne(new BinaryMatrix(new int[][]{{0,0},{0,0}})));
        System.out.println(sol.leftMostColumnWithOne(new BinaryMatrix(new int[][]{{0,0,0,1},{0,0,1,1},{0,1,1,1}})));
    }
}

class BinaryMatrix{
    int[][] arr;
    public BinaryMatrix(int[][] arr){
        this.arr = arr;
    }
    public int get(int x, int y) {
        return arr[x][y];
    }
    public List<Integer> dimensions() {
        List<Integer> al = new ArrayList<>();
        al.add(arr.length);
        al.add(arr[0].length);
        return al;
    }

}
class Solution {
    public int leftMostColumnWithOne(BinaryMatrix binaryMatrix) {
        int rows = binaryMatrix.dimensions().get(0);
        int cols = binaryMatrix.dimensions().get(1);
        int ans = -1, r = 0, c = cols-1;
        while(true){
            if(binaryMatrix.get(r,c)==1) ans = c;
            if(c==0 && ans!=-1) break;
            else{
                if(binaryMatrix.get(r,c-1)==0) r += 1;
                else c -= 1;
            }
            if(r==rows) break;
        }
        return ans;
    }
}