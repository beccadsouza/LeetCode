package _461;

/*
 * Created by Rebecca Dsouza on 7/5/20
 */
public class HammingDistance {
    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(sol.hammingDistance(1,4));
    }
}
class Solution {
    public int hammingDistance(int x, int y) {
        int dist = 0;
        while(x!=y){
            if((x&1^y&1)==1) dist++;
            x >>= 1;
            y >>= 1;
        }
        return dist;
    }
}