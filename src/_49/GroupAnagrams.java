package _49;

import java.util.*;

/*
 * Created by Rebecca Dsouza on 4/6/20
 */
public class GroupAnagrams {
    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(sol.groupAnagrams(
                new String[]{"eat", "tea", "tan", "ate", "nat", "bat"})
        );
    }
}
class Solution {

    public List<List<String>> groupAnagrams(String[] strs) {

        List<List<String>> ans = new ArrayList<>();
        HashMap<String, ArrayList<String>> hm = new HashMap<>();
        ArrayList<String> al;
        String str;
        char[] arr;

        for(String x: strs){
            arr = x.toCharArray();
            Arrays.sort(arr);
            str = new String(arr);
            if(!hm.containsKey(str))  hm.put(str,new ArrayList<>());
            hm.get(str).add(x);
        }

        ans.addAll(hm.values());
        return ans;
    }
}