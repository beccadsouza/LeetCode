package _295;

import java.util.*;

/*
 * Created by Rebecca Dsouza on 3/29/20
 */
public class FindMedianFromDataStream {
    public static void main(String[] args) {
        MedianFinder obj = new MedianFinder();
        obj.addNum(1);
        obj.addNum(2);
        System.out.println(obj.findMedian());
        obj.addNum(3);
        System.out.println(obj.findMedian());
    }
}

class MedianFinder {
    PriorityQueue<Integer> first;
    PriorityQueue<Integer> second;

    public MedianFinder() {
        first = new PriorityQueue<Integer>(Collections.reverseOrder());
        second = new PriorityQueue<Integer>();
    }

    public void addNum(int num) {
        if(first.size()==0||first.peek()>num){
            first.add(num);
            if(first.size()-second.size() > 1) second.add(first.poll());
        }
        else{
            second.add(num);
            if(second.size()-first.size() >1) first.add(second.poll());
        }
    }

    public double findMedian() {
        if(first.size()==second.size()) return (double) (second.peek()+first.peek())*0.5 ;
        else{
            if(first.size()>second.size()) return (double) first.peek();
            else return (double) second.peek();
        }
    }
}

/*
*       CTCI SOLUTION FROM VIDEO
* */
/*
class MedianFinder {

    PriorityQueue<Integer> lowers;
    PriorityQueue<Integer> highers;

    public MedianFinder() {
//        lowers = new PriorityQueue<>(new Comparator<Integer>(){
//            public int compare(Integer a, Integer b){return -1*a.compareTo(b);}
//        });
        lowers = new PriorityQueue<>((a, b) -> -1*a.compareTo(b));
        highers = new PriorityQueue<>();
    }

    public void addNum(int num) {
        if(lowers.size()==0||lowers.peek()>=num) lowers.add(num);
        else highers.add(num);
        if(Math.abs(lowers.size()-highers.size())>1) rebalanceHeaps();
    }

    public void rebalanceHeaps(){
        PriorityQueue<Integer> biggerHeap = lowers.size()>highers.size()?lowers:highers;
        PriorityQueue<Integer> smallerHeap = lowers.size()<=highers.size()?lowers:highers;
        smallerHeap.add(biggerHeap.poll());
    }

    public double findMedian() {
        PriorityQueue<Integer> biggerHeap = lowers.size()>highers.size()?lowers:highers;
        PriorityQueue<Integer> smallerHeap = lowers.size()<=highers.size()?lowers:highers;
        if(biggerHeap.size()==smallerHeap.size())
            return (double)(biggerHeap.peek()+smallerHeap.peek())/2;
        else return (double)biggerHeap.peek();
    }
}
 */