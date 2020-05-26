package _402;

/*
 * Created by Rebecca Dsouza on 5/13/20
 */
public class RemoveKDigits {
    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(sol.removeKdigits("1432219", 3));
        System.out.println(sol.removeKdigits("10200", 1));
        System.out.println(sol.removeKdigits("10",2));
    }
}
class Solution {
    public String reduce(String num){
        boolean flag = false;
        for(int i = 1;i<num.length();i++){
            if(((int) num.charAt(i-1)-'0')>((int) num.charAt(i)-'0')){
                num = num.substring(0,i-1) + num.substring(i);
                flag = true;
                break;
            }
        }
        if(!flag) num = num.substring(0,num.length()-1);
        return num;
    }
    public String removeKdigits(String number, int k) {
        if(number.length()==k || number.equals("")) return "0";
        for(int i = 0;i<k;i++) number = reduce(number);
        int start = 0;
        for(char x:number.toCharArray())
            if(x!='0') break;
            else start++;
        return (start>number.length()-1)?"0":number.substring(start);
    }
}