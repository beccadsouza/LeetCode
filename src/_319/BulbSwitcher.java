package _319;

/*
 * Created by Rebecca Dsouza on 3/10/20
 */
public class BulbSwitcher {
    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(sol.bulbSwitch(3));
    }
}

class Solution {
    public int bulbSwitch(int n) {
        int i = 1;
        while(i*i <= n) i +=1;
        return i-1;
    }
}