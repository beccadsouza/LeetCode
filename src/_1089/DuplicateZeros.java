package _1089;
/*
 * Created by Rebecca Dsouza on 4/23/20
 */
public class DuplicateZeros {
    public static void main(String[] args) {
        Solution sol = new Solution();
        sol.duplicateZeros(new int[]{1,0,2,3,0,4,5,0});
    }
}
class Solution {
    public void duplicateZeros(int[] arr) {
        boolean replicateLastValue = false;
        int index=0,count=0,n = arr.length,ptr=n-1;
        // counting upto where the shifting should start
        for(int i = 0;i<n;i++){
            count++;
            if(arr[i]==0){
                if(count==n){
                    replicateLastValue = false;
                    index = i;
                    break;
                }
                else{
                    count++;
                    if(count==n){
                        replicateLastValue = true;
                        index = i;
                        break;
                    }
                }
            }
            if(count==n){
                index = i;
                break;
            }
        }
        // shifting values in place
        for(int j = index;j>=0;j--){
            if(arr[j]==0){
                if(j==index && !replicateLastValue){
                    arr[ptr] = 0;
                    ptr--;
                }
                else{
                    arr[ptr] = 0;
                    ptr--;
                    arr[ptr] = 0;
                    ptr--;
                }
            }
            else{
                arr[ptr] = arr[j];
                ptr--;
            }
        }
    }
}