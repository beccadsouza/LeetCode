package _657;
/*
* Created by Rebecca Dsouza on 10/7/20
*/
public class RobotReturnToOrigin {
    public static void main(String[] args){
        Solution sol = new Solution();
        System.out.println(sol.judgeCircle("UD"));
        System.out.println(sol.judgeCircle("LL"));
        System.out.println(sol.judgeCircle("RRDD"));
        System.out.println(sol.judgeCircle("LDRRLRUULR"));
        System.out.println(sol.judgeCircle("RLUURDDDLU"));
    }
}
class Solution {
    public boolean judgeCircle(String moves){
        int x = 0, y = 0;
        for(char c:moves.toCharArray()){
            if(c=='U') y++;
            if(c=='D') y--;
            if(c=='L') x--;
            if(c=='R') x++;
        }
        return (x==0) && (y==0);
    }
}