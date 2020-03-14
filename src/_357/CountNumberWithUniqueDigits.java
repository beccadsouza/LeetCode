package _357;
import java.util.HashMap;
/*
 * Created by Rebecca Dsouza on 3/10/20
 */
public class CountNumberWithUniqueDigits {
    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(sol.countNumbersWithUniqueDigits(2));
    }
}
class Solution {
    public int countNumbersWithUniqueDigits(int n) {
        HashMap<Integer, Integer> hm = new HashMap<>();
        hm.put(0,1);
        hm.put(1,9);
        hm.put(2,81);
        int recent = 81;
        int ans = 0;
        for(int i=0;i<=n;i++){
            if(i<3){
                ans += hm.get(i);
            }
            else if(i<11){
                ans += (11-i)*recent;
                recent = (11-i)*recent;
            }
        }
        return ans;
    }
}