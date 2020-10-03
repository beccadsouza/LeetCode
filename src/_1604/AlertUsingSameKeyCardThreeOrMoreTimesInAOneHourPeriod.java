package _1604;
/*
* Created by Rebecca Dsouza on 10/3/20
*/
import java.util.*;
public class AlertUsingSameKeyCardThreeOrMoreTimesInAOneHourPeriod {
    public static void main(String[] args){
        Solution sol = new Solution();
        System.out.println(sol.alertNames(
                new String[]{"daniel","daniel","daniel","luis","luis","luis","luis"},
                new String[]{"10:00","10:40","11:00","09:00","11:00","13:00","15:00"}
                ));
        System.out.println(sol.alertNames(
                new String[]{"alice","alice","alice","bob","bob","bob","bob"},
                new String[]{"12:01","12:00","18:00","21:00","21:20","21:30","23:00"}
        ));
        System.out.println(sol.alertNames(
                new String[]{"john","john","john"},
                new String[]{"23:58","23:59","00:01"}
        ));
        System.out.println(sol.alertNames(
                new String[]{"leslie","leslie","leslie","clare","clare","clare","clare"},
                new String[]{"13:00","13:20","14:00","18:00","18:51","19:30","19:49"}
        ));
    }
}
class Solution {
    Map<String, List<String>> hm = new HashMap<>();
    List<String> ans = new ArrayList<>();
    public void alertHelp(){
        for(Map.Entry<String, List<String>> x:hm.entrySet()){
            List<String> al = x.getValue();
            if(al.size()<3) continue;
            int a,b,c;
            a = Integer.parseInt(al.get(0).substring(0,2))*60 + Integer.parseInt(al.get(0).substring(3,5));
            b = Integer.parseInt(al.get(1).substring(0,2))*60 + Integer.parseInt(al.get(1).substring(3,5));
            for(int i = 2;i<al.size();i++){
                c = Integer.parseInt(al.get(i).substring(0,2))*60 + Integer.parseInt(al.get(i).substring(3,5));
                if((c-a)<=60) {
                    ans.add(x.getKey());
                    break;
                }
                a = b;
                b = c;
            }
        }
        Collections.sort(ans);
    }
    public List<String> alertNames(String[] keyName, String[] keyTime) {
        for(int i = 0;i<keyName.length;i++){
            List<String> al = hm.getOrDefault(keyName[i], new ArrayList<>());
            al.add(keyTime[i]);
            Collections.sort(al);
            hm.put(keyName[i],al);
        }
        alertHelp();
        return ans;
    }

}