package _54;

import java.util.*;

/*
 * Created by Rebecca Dsouza on 5/9/20
 */
public class SpiralMatrix {
    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(sol.spiralOrder(new int[][]{{1,2,3},{4,5,6},{7,8,9}}));
        System.out.println(sol.spiralOrder(new int[][]{{1,2,3,4},{5,6,7,8},{9,10,11,12}}));
    }
}
class Solution {
    public List<Integer> spiralOrder(int[][] ma) {
        List<Integer> al = new ArrayList<>();
        if(ma.length==0) return al;
        int i=0,j=0,m=ma.length,n=ma[0].length,count=m*n,direction=1,N=-1,S=m,E=n,W=-1;
        while(count!=0){
            switch(direction){
                case 1: // going right, switch down
                    if((j)==E){
                        j--;
                        i++;
                        direction = 2;
                        N++;
                    }
                    else{
                        al.add(ma[i][j]);
                        j++;
                        count--;
                    }
                    break;
                case 2: // going down, switch left
                    if((i)==S){
                        i--;
                        j--;
                        direction = 3;
                        E--;
                    }
                    else{
                        al.add(ma[i][j]);
                        i++;
                        count--;
                    }
                    break;
                case 3: // going left, switch up
                    if((j)==W){
                        j++;
                        i--;
                        direction = 4;
                        S--;
                    }
                    else{
                        al.add(ma[i][j]);
                        j--;
                        count--;
                    }
                    break;
                case 4: // going up, switch right
                    if((i)==N){
                        i++;
                        j++;
                        direction = 1;
                        W++;
                    }
                    else{
                        al.add(ma[i][j]);
                        i--;
                        count--;
                    }
                    break;
            }
        }
        return al;
    }
}