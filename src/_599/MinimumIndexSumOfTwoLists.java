package _599;

import java.util.*;

/*
 * Created by Rebecca Dsouza on 7/1/20
 */
public class MinimumIndexSumOfTwoLists {
    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(
                Arrays.toString(sol.findRestaurant(
                        new String[]{"Shogun", "Tapioca Express", "Burger King", "KFC"},
                        new String[]{"Piatti", "The Grill at Torrey Pines", "Hungry Hunter Steakhouse", "Shogun"}
                ))
        );
    }
}
class Solution {
    Map<String, Integer> hm1 = new HashMap<>();
    Map<String, Integer> hm2 = new HashMap<>();
    List<String> al = new ArrayList<>();

    public String[] findRestaurant(String[] list1, String[] list2) {
        for(int i=0;i<list1.length;i++) hm1.put(list1[i],i);
        for(int i=0;i<list2.length;i++) if(hm1.containsKey(list2[i])) hm2.put(list2[i], i+hm1.get(list2[i]));
        if(hm2.size()==0) return new String[]{};
        int minIndex = Collections.min(hm2.values());
        for(Map.Entry<String, Integer> x:hm2.entrySet()) if(x.getValue()==minIndex) al.add(x.getKey());
        return al.toArray(new String[0]);
    }
}