package _1447;

import java.util.*;

/*
 * Created by Rebecca Dsouza on 5/16/20
 */
public class SimplifiedFractions {
    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(sol.simplifiedFractions(2));
        System.out.println(sol.simplifiedFractions(3));
        System.out.println(sol.simplifiedFractions(4));
        System.out.println(sol.simplifiedFractions(1));
    }
}
class Solution {
    HashSet<Double> hs = new HashSet<>();
    public List<String> simplifiedFractions(int no) {
        List<String> al = new ArrayList<>();
        if(no==1) return al;
        else{
            for(int d = 2;d<no+1;d++){
                for(int n = 1;n<d;n++){
                    double temp = (double)n/(double)d;
                    if(!hs.contains(temp)){
                        hs.add(temp);
                        al.add(n+"/"+d);
                    }
                }
            }
        }
        return al;
    }
}