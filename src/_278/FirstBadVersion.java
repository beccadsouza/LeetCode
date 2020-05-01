package _278;

/*
 * Created by Rebecca Dsouza on 5/1/20
 */
public class FirstBadVersion {
    public static void main(String[] args) {
        Solution sol = new Solution();
        sol.version = 4;
        System.out.println(sol.firstBadVersion(5));
    }
}
class Solution {
    int version;
    public boolean isBadVersion(int n){
        return n >= version;
    }
    public int firstBadVersion(int n) {
        int start = 1, end = n, mid;
        while(start<end){
            mid = start + (end-start)/2;
            if(isBadVersion(mid)) end = mid;
            else start = mid+1;
        }
        return start;
    }
}