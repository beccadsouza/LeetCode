package _438;

import java.util.*;

/*
 * Created by Rebecca Dsouza on 3/14/20
 */
public class FindAllAnagramsInAString {
    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(sol.findAnagrams("cbaebabacd", "abc"));
        System.out.println(sol.findAnagrams("abab", "ab"));
    }
}

class Solution {

    public List<Integer> findAnagrams(String s, String p) {

        if(s.length()==0 || s.length()<p.length())
            return new ArrayList<>();

        ArrayList<Integer> al = new ArrayList<Integer>();

        HashMap<Character, Integer> ref = new HashMap<Character, Integer>();

        for(char x : p.toCharArray()){
            ref.put(x, ref.getOrDefault(x, 0)+1) ;
        }

        int front = 0, rear = 0;

        HashMap<Character, Integer> temp = new HashMap<Character, Integer>();


        while(rear<s.length()){

            if(ref.getOrDefault(s.charAt(rear), 0)!=0){
                temp.put(s.charAt(rear), temp.getOrDefault(s.charAt(rear), 0) + 1);

                if((rear-front+1)==p.length()){
                    if(temp.equals(ref)){
                        al.add(front);
                    }
                    temp.put(s.charAt(front), temp.get(s.charAt(front)) - 1);
                    front++;
                }
                rear++;
            }
            else{
                for(int i = front; i<rear;i++){
                    temp.put(s.charAt(i), temp.get(s.charAt(i))-1);
                }
                rear++;
                front = rear;
            }
        }
        return al;
    }
}
