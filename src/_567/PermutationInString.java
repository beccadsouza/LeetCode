package _567;

import java.util.*;

/*
 * Created by Rebecca Dsouza on 5/18/20
 */
public class PermutationInString {
    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(sol.checkInclusion("ab","eidbaooo"));
        System.out.println(sol.checkInclusion("ab","eidboaoo"));
    }
}
class Solution {
    HashMap<Character, Integer> hm = new HashMap<>();
    public boolean checkInclusion(String s1, String s2) {
        for(char x:s1.toCharArray()) hm.put(x, hm.getOrDefault(x,0)+1);
        int front = 0, rear = 0, count = 0;
        while(rear<s2.length()){
            char x = s2.charAt(rear);
            if(hm.containsKey(x)){
                if(hm.get(x)==0){
                    boolean flag = false;
                    for(int i = front;i<rear;i++){
                        char y = s2.charAt(i);
                        if(y==x){
                            front = i+1;
                            flag = true;
                            break;
                        }
                        hm.put(y,hm.get(y)+1);
                        count--;
                    }
                    if(!flag) front = rear;
                }
                else{
                    hm.put(x, hm.get(x)-1);
                    count++;
                }
            }
            else{
                for(int i = front;i<rear;i++){
                    char y = s2.charAt(i);
                    hm.put(y,hm.get(y)+1);
                    count--;
                }
                front = rear+1;
            }
            if(count==s1.length()) return true;
            rear++;
        }
        return false;
    }
}