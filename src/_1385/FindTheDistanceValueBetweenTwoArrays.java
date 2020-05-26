package _1385;
/*
 * Created by Rebecca Dsouza on 3/21/20
 */
public class FindTheDistanceValueBetweenTwoArrays {
    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(sol.findTheDistanceValue(new int[]{4,5,8},new int[]{10,9,1,8},2));
        System.out.println(sol.findTheDistanceValue(new int[]{1,4,2,3},new int[]{-4,-3,6,10,20,30},3));
        System.out.println(sol.findTheDistanceValue(new int[]{2,1,100,3},new int[]{-5,-2,10,-3,7},6));
    }
}
class Solution {
    public int findTheDistanceValue(int[] arr1, int[] arr2, int d) {
        int count = 0;
        for (int item : arr1) {
            for (int value : arr2) {
                if ((Math.abs(item - value) <= d)) {
                    count++;
                    break;
                }
            }
        }
        return arr1.length - count;
    }
}