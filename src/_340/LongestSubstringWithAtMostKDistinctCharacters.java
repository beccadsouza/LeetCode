package _340;

import java.util.HashMap;

/*
 * Created by Rebecca Dsouza on 3/14/20
 */
public class LongestSubstringWithAtMostKDistinctCharacters {
    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(sol.lengthOfLongestSubstringKDistinct("eceba", 2));
    }
}
/*
* Given a string, find the length of the longest substring T that contains at most k distinct characters.
* For example, Given s = “eceba” and k = 2,
* T is "ece" which its length is 3.
* */
class Solution{

    public int lengthOfLongestSubstringKDistinct(String s, int k) {
        int front = 0, rear = 0, curr_k = 0, ans = 0;
        HashMap<Character, Integer> hm = new HashMap<>();
        for(int i = 0; i<256;i++){
            hm.put((char)i, 0);
        }
        char c[] = s.toCharArray();
        while(rear<c.length){
            if(hm.get(c[rear])==0){
                curr_k += 1;
                hm.put(c[rear],1);
            }
            else{
                hm.put(c[rear], hm.get(c[rear])+1);
            }
            if(curr_k==k){
                ans = Math.max(ans, rear-front+1);
            }
            else if(curr_k>k){
                while(curr_k>k && front<c.length){
                    hm.put(c[front],hm.get(c[front])-1);
                    if(hm.get(c[front])==0){
                        curr_k -= 1;
                    }
                    front++;
                }
            }
            rear++;
        }
        if(ans==0) return -1;
        return ans;
    }
}