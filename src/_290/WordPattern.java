package _290;
/*
* Created by Rebecca Dsouza on 9/7/20
*/
import java.util.*;
public class WordPattern {
    public static void main(String[] args){
        Solution sol = new Solution();
        System.out.println(sol.wordPattern("abba", "dog cat cat dog"));
        System.out.println(sol.wordPattern("abba", "dog cat cat fish"));
        System.out.println(sol.wordPattern("aaaa", "dog cat cat dog"));
        System.out.println(sol.wordPattern("abba", "dog dog dog dog"));
    }
}
class Solution {
    public boolean wordPattern(String pattern, String str) {
        Map<Character,String> hm = new HashMap<>();
        Set<String> hs = new HashSet<>();
        String[] words = str.split(" ");
        int psize = pattern.length();
        if(psize!=words.length) return false;
        for(int i = 0;i<psize;i++){
            char p = pattern.charAt(i);
            if(hm.containsKey(p)){
                if(!hm.get(p).equals(words[i])) return false;
            }
            else {
                if(hs.contains(words[i])) return false;
                hm.put(p,words[i]);
                hs.add(words[i]);
            }
        }
        return true;
    }
}