package _520;
/*
* Created by Rebecca Dsouza on 8/1/20
*/

public class DetectCapital {
    public static void main(String[] args){
        Solution sol = new Solution();
        System.out.println(sol.detectCapitalUse("USA"));
        System.out.println(sol.detectCapitalUse("FlaG"));
    }
}
class Solution {
    public boolean detectCapitalUse(String word) {
        int wordLength = word.length(), capsCount = 0;
        for(int i = 0;i<wordLength;i++)
            if(Character.isUpperCase(word.charAt(i))) capsCount++;
        return capsCount%wordLength==0 || (capsCount==1 && Character.isUpperCase(word.charAt(0)));
    }
}

/*
    CASE 1: All Caps; capsCount = wordLength
    CASE 2: First Letter Caps; capsCount = 1
    CASE 3: All Not Caps; capsCount = 0
*/