package _1429;

import java.util.*;

/*
 * Created by Rebecca Dsouza on 4/28/20
 */
public class FirstUniqueNumber {
    public static void main(String[] args) {
        FirstUnique fu;
        fu = new FirstUnique(new int[]{2,3,5});
        System.out.println(fu.showFirstUnique());
        fu.add(5);
        System.out.println(fu.showFirstUnique());
        fu.add(2);
        System.out.println(fu.showFirstUnique());
        fu.add(3);
        System.out.println(fu.showFirstUnique());

        fu = new FirstUnique(new int[]{7,7,7,7,7,7});
        System.out.println(fu.showFirstUnique());
        fu.add(7);
        fu.add(3);
        fu.add(3);
        fu.add(7);
        fu.add(17);
        System.out.println(fu.showFirstUnique());

        fu = new FirstUnique(new int[]{809});
        System.out.println(fu.showFirstUnique());
        fu.add(809);
        System.out.println(fu.showFirstUnique());
    }
}

class FirstUnique {
    HashMap<Integer, Boolean> hm = new HashMap<>();
    LinkedHashSet<Integer> lhs = new LinkedHashSet<>();
    int unique = -1;
    public void makeUnique(){
        if(lhs.size()==0) unique = -1;
        else unique = lhs.iterator().next();
    }
    public FirstUnique(int[] nums) {
        for(int x:nums){
            if(!lhs.contains(x) && !hm.getOrDefault(x, false)) lhs.add(x);
            else lhs.remove(x);
            hm.put(x,true);
        }
    }
    public int showFirstUnique() {
        makeUnique();
        return unique;
    }
    public void add(int value) {
        if(!lhs.contains(value) && !hm.getOrDefault(value, false)){
            lhs.add(value);
            hm.put(value,true);
        }
        else{
            lhs.remove(value);
            if(unique==value) unique = -1;
        }
    }
}