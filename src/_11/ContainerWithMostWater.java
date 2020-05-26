package _11;
/*
 * Created by Rebecca Dsouza on 5/9/20
 */
public class ContainerWithMostWater {
    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(sol.maxArea(new int[]{1,8,6,2,5,4,8,3,7}));
    }
}
class Solution {
    public int maxArea(int[] h) {
        int ans = 0, p1 = 0, p2 = h.length-1;
        while(p1!=p2){
            ans = Math.max(ans, Math.min(h[p1],h[p2])*(p2-p1));
            if(h[p1]<h[p2]) p1++;
            else p2--;
        }
        return ans;
    }
}