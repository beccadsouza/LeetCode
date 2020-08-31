package _1276;
/*
* Created by Rebecca Dsouza on 7/16/20
*/

import java.util.*;

public class NumberOfBurgersWithNoWasteOfIngredients {
    public static void main(String[] args){
        Solution sol = new Solution();
        System.out.println(sol.numOfBurgers(16,7));
        System.out.println(sol.numOfBurgers(17,4));
        System.out.println(sol.numOfBurgers(4,17));
        System.out.println(sol.numOfBurgers(0,0));
        System.out.println(sol.numOfBurgers(2,1));
    }
}
class Solution {
    List<Integer> al = new ArrayList<>();
    public List<Integer> numOfBurgers(int t, int c) {

        if(t%2!=0 || t/2<c || 2*c<t/2 ) return al;
        al.add(t/2-c);
        al.add(2*c-t/2);
        return al;
    }
}

/*
    a + b = cheese
    2a + b = tomato/2

    a = tomato/2 - cheese
    b = 2 cheese - tomato/2
*/