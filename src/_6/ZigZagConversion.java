package _6;

/*
 * Created by Rebecca Dsouza on 3/6/20
 */
public class ZigZagConversion {
    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(sol.convert("PAYPALISHIRING", 3));
        System.out.println(sol.convert("PAYPALISHIRING", 4));
        System.out.println(sol.convert("AB", 1));
    }
}

class Solution {
    public String convert(String s, int numRows) {
        if(numRows==1){
            return s;
        }

        StringBuffer[] rows = new StringBuffer[numRows];
        for(int i = 0; i<numRows; i++){
            rows[i] = new StringBuffer("");
        }

        boolean forward = true;
        int ptr = 0;

        for(int i = 0; i<s.length(); i++){

            char x = s.charAt(i);
            rows[ptr].append(x);

            if(forward){
                if(ptr!=numRows-1){
                    ptr += 1;
                }
                else{
                    ptr -= 1;
                    forward = false;
                }
            }
            else{
                if(ptr!=0){
                    ptr -= 1;
                }
                else{
                    ptr += 1;
                    forward = true;
                }
            }
        }

        StringBuffer ans = new StringBuffer();
        for(int i = 0; i<numRows; i++){
            ans.append(rows[i]);
        }
        return ans.toString();
    }
}
