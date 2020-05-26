package _1232;

/*
 * Created by Rebecca Dsouza on 5/8/20
 */
public class CheckIfItIsAStraightLine {
    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(sol.checkStraightLine(new int[][]{{1,2},{2,3},{3,4},{4,5},{5,6},{6,7}}));
    }
}
class Solution {
    public boolean checkStraightLine(int[][] c) {
        if(c.length<2) return false;
        else{
            double slope=((double)c[1][1]-(double)c[0][1])/((double)c[1][0]-(double)c[0][0]);
            for(int i =2;i<c.length-1;i++)
                if(((double)c[i][1]-(double)c[i+1][1])/((double)c[i][0]-(double)c[i+1][0])!=slope) return false;
        }
        return true;
    }
}