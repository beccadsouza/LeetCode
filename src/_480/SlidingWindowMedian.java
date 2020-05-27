package _480;

import java.util.*;

/*
 * Created by Rebecca Dsouza on 4/1/20
 */
public class SlidingWindowMedian {
    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(Arrays.toString(sol.medianSlidingWindow(new int[]{1,3,-1,-3,5,3,6,7},3)));
    }
}
class Solution {
    PriorityQueue<Double> first = new PriorityQueue<>(Collections.reverseOrder());
    PriorityQueue<Double> second = new PriorityQueue<>();

    public void addNum(double n){
        // System.out.println(first + " " + second);
        // System.out.println("Adding element " + n);
        if(first.size()==0 || first.peek()>=n){
            first.add(n);
            if(first.size()-second.size() >1){
                second.add(first.poll());
            }
        }
        else{
            second.add(n);
            if(second.size()-first.size() >1){
                first.add(second.poll());
            }
        }
        // System.out.println(first + " " + second);
    }

    public void removeNum(double n){
        // System.out.println(first + " " + second);
        // System.out.println("Removing element " + n);
        if(n<=first.peek()){
            first.remove(n);
            if(second.size()-first.size()>1){
                first.add(second.poll());
            }
        }
        else{
            second.remove(n);
            if(first.size()-second.size()>1){
                second.add(first.poll());
            }
        }
        // System.out.println(first + " " + second);
    }

    public double getMedian(){
        if(first.size()==second.size()) return (double)(first.peek()+second.peek())/2;
        else if (first.size()>second.size()) return (double) first.peek();
        else return second.peek();
    }

    public double[] medianSlidingWindow(int[] nums, int k) {
        if(k==1){

            double[] ans = new double[nums.length-k+1];
            for(int i = 0;i<nums.length;i++){
                ans[i] = (double)nums[i];
            }
            return ans;
        }
        ArrayList<Double> al = new ArrayList<>();
        double[] ans = new double[nums.length-k+1];

        for(int i = 0;i<nums.length;i++){
            // System.out.println("\nAt nums[i=" + i + "]:" + nums[i] + " heaps are " + first + " " + second);
            if(i<k){
                // insert and balance
                addNum((double)nums[i]);
            }
            else{
                // insert and balance
                addNum((double)nums[i]);
                // remove and balance
                removeNum((double)nums[i-k]);
            }
            if(i>=k-1){
                // print median
                // al.add(getMedian());
                ans[i-k+1] = getMedian();
                // System.out.println("MEDIAN IS "+ ans[i-k+1]);
            }
        }

        // System.out.println(al);

        // return new double[]{};
        return ans;
    }
}