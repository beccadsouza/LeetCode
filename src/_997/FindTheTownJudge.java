package _997;

/*
 * Created by Rebecca Dsouza on 5/10/20
 */
public class FindTheTownJudge {
    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(sol.findJudge(2, new int[][]{{1,2}}));
        System.out.println(sol.findJudge(3, new int[][]{{1,3},{2,3}}));
        System.out.println(sol.findJudge(3, new int[][]{{1,3},{2,3},{3,1}}));
        System.out.println(sol.findJudge(3, new int[][]{{1,2},{2,3}}));
        System.out.println(sol.findJudge(4, new int[][]{{1,3},{1,4},{2,3},{2,4},{4,3}}));
    }
}
class Solution {
    public int findJudge(int N, int[][] trust) {
        boolean[] hasTrusted = new boolean[N+1];
        int[] people = new int[N+1];
        for(int i = 0;i<trust.length;i++){
            hasTrusted[trust[i][0]] = true;
            people[trust[i][1]]++;
        }
        for(int i = 1;i<N+1;i++){
            if(people[i]==N-1 && !hasTrusted[i]) return i;
        }
        return -1;
    }
}