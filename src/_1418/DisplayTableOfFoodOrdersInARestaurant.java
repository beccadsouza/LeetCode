package _1418;
import java.util.*;
import java.util.stream.Collectors;

/*
 * Created by Rebecca Dsouza on 4/19/20
 */
public class DisplayTableOfFoodOrdersInARestaurant {
    public static void main(String[] args) {
        Solution sol = new Solution();
        String[][] orders = new String[][]{
                {"David","3","Ceviche"},
                {"Corina","10","Beef Burrito"},
                {"David","3","Fried Chicken"},
                {"Carla","5","Water"},
                {"Carla","5","Ceviche"},
                {"Rous","3","Ceviche"}
        };
        System.out.println(
                sol.displayTable(
                    Arrays.stream(orders).map(Arrays::asList).collect(Collectors.toList())
                )
        );
    }
}
class Solution {
    public List<List<String>> displayTable(List<List<String>> orders) {
        HashMap<Integer, HashMap<String, Integer>> tableFoodFreq = new HashMap<>();
        HashSet<String> food = new HashSet<>();
        List<List<String>> ans = new ArrayList<>();

        for(List<String> order: orders){
            int tableNumber = Integer.parseInt(order.get(1));
            String foodItem = order.get(2);
            food.add(foodItem);
            HashMap<String, Integer> temp = tableFoodFreq.getOrDefault(tableNumber, new HashMap<>());
            temp.put(foodItem, temp.getOrDefault(foodItem, 0) + 1);
            tableFoodFreq.put(tableNumber, temp);
        }

        TreeSet<String> sortedFood = new TreeSet<>(food);

        System.out.println(tableFoodFreq + " " + sortedFood);

        ArrayList<String> temp = new ArrayList<>();
        temp.add("Table");
        temp.addAll(sortedFood);

        ans.add(temp);
        Map<Integer, HashMap<String, Integer>> sortedTableFoodFreq = new TreeMap<>(tableFoodFreq);

        for(Map.Entry<Integer, HashMap<String, Integer>> entry: sortedTableFoodFreq.entrySet()){
            int tableNumber = entry.getKey();
            HashMap<String, Integer> hm = entry.getValue();
            temp = new ArrayList<>();
            temp.add(String.valueOf(tableNumber));
            for(String foodItem: sortedFood){
                String qnty = String.valueOf(hm.getOrDefault(foodItem, 0));
                temp.add(qnty);
            }
            ans.add(temp);
        }


        return ans;
    }
}