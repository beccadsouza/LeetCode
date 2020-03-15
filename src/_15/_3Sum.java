package _15;
import java.util.*;
/*
 * Created by Rebecca Dsouza on 3/15/20
 */
public class _3Sum {
    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(sol.threeSum(new int[]{-1, 0, 1, 2, -1, -4}));
    }
}
class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        HashMap<Integer, ArrayList<Integer>> hm = new HashMap<>();
        List<List<Integer>> al = new ArrayList<>();
        if(nums.length<3) return al;
        for (int num : nums) hm.put(num, new ArrayList<>());
        for(int i = 0;i<nums.length;i++) hm.get(nums[i]).add(i);
        ArrayList<Integer> temp1;
        HashSet<String> hs = new HashSet<>();
        Arrays.sort(nums);
        for(int i = 0; i<nums.length; i++){
            for(int j=i+1; j<nums.length;j++){
                int c = -(nums[i]+nums[j]);
                if(hm.containsKey(c)){
                    temp1 = hm.get(c);
                    int var = 0;
                    if(c == nums[i]) var += 1;
                    if(c == nums[j]) var += 1;
                    if(temp1.size()<(var+1)){
                        break;
                    }
                    Integer[] temp2 = new Integer[]{nums[i], nums[j], c};
                    Arrays.sort(temp2);
                    String hash = temp2[0]+","+temp2[1]+","+temp2[2];
                    if(!hs.contains(hash)){
                        hs.add(hash);
                        al.add(Arrays.asList(temp2));
                    }
                }
            }
        }
        return al;
    }
}