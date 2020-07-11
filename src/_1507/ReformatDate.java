package _1507;
/*
* Created by Rebecca Dsouza on 7/11/20
*/

import java.util.*;

public class ReformatDate {
    public static void main(String[] args){
        Solution sol = new Solution();
        System.out.println(sol.reformatDate("20th Oct 2052"));
        System.out.println(sol.reformatDate("6th Jun 1933"));
        System.out.println(sol.reformatDate("26th May 1960"));
    }
}
class Solution {
    Map<String,String> hm = new HashMap<>();
    public String reformatDate(String date) {
        String[] months = new String[]{"Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec"};
        for(int i = 1;i<13;i++){
            String month = (i<10)?("0"+ i):String.valueOf(i);
            hm.put(months[i-1],month);
        }
        if(date.length()==12) date = "0"+date;
        String day = date.substring(0,2);
        String month = hm.get(date.substring(5,8));
        String year = date.substring(9,13);
        return year + "-" + month + "-" + day;
    }
}