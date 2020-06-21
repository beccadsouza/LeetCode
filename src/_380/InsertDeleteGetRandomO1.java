package _380;

import java.util.*;

/*
 * Created by Rebecca Dsouza on 6/12/20
 */
public class InsertDeleteGetRandomO1 {
    public static void main(String[] args) {
        // Init an empty set.
        RandomizedSet randomSet = new RandomizedSet();

// Inserts 1 to the set. Returns true as 1 was inserted successfully.
        randomSet.insert(1);

// Returns false as 2 does not exist in the set.
        randomSet.remove(2);

// Inserts 2 to the set, returns true. Set now contains [1,2].
        randomSet.insert(2);

// getRandom should return either 1 or 2 randomly.
        randomSet.getRandom();

// Removes 1 from the set, returns true. Set now contains [2].
        randomSet.remove(1);

// 2 was already in the set, so return false.
        randomSet.insert(2);

// Since 2 is the only number in the set, getRandom always return 2.
        randomSet.getRandom();
    }
}
class RandomizedSet {

    Map<Integer, Integer> hm;
    List<Integer> al;
    Random rd;
    /** Initialize your data structure here. */
    public RandomizedSet() {
        hm = new HashMap<>();
        al = new ArrayList<>();
        rd = new Random();
    }

    /** Inserts a value to the set. Returns true if the set did not already contain the specified element. */
    public boolean insert(int val) {
        boolean ans = false;
        if(!hm.containsKey(val)){
            ans = true;
            al.add(val);
            hm.put(val,al.size()-1);
        }
        return ans;
    }

    /** Removes a value from the set. Returns true if the set contained the specified element. */
    public boolean remove(int val) {
        boolean ans = false;
        if(hm.containsKey(val)){
            ans = true;
            int index = hm.get(val);
            int lastElement = al.get(al.size()-1);
            al.set(index, lastElement);
            hm.put(lastElement, index);
            al.remove(al.size()-1);
            hm.remove(val);
        }
        return ans;
    }

    /** Get a random element from the set. */
    public int getRandom() {
        return al.get(rd.nextInt(al.size()));
    }
}

/**
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet obj = new RandomizedSet();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */