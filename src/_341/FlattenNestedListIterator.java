package _341;

import java.util.*;
/*
 * Created by Rebecca Dsouza on 4/26/20
 */
public class FlattenNestedListIterator {
    public static void main(String[] args) {

    }
}

 // This is the interface that allows for creating nested lists.
 // You should not implement it, or speculate about its implementation
interface NestedInteger {

     // @return true if this NestedInteger holds a single integer, rather than a nested list.
     public boolean isInteger();

     // @return the single integer that this NestedInteger holds, if it holds a single integer
     // Return null if this NestedInteger holds a nested list
     public Integer getInteger();

     // @return the nested list that this NestedInteger holds, if it holds a nested list
     // Return null if this NestedInteger holds a single integer
     public List<NestedInteger> getList();
}

class NestedIterator implements Iterator<Integer> {
    ArrayList<Integer> al = new ArrayList<>();
    int ptr = 0;
    public void function(List<NestedInteger> nl){
        for(NestedInteger x:nl)
            if(x.isInteger()) al.add(x.getInteger());
            else function(x.getList());
    }
    public NestedIterator(List<NestedInteger> nestedList) {
        function(nestedList);
    }
    @Override
    public Integer next() {
        return al.get(ptr++);
    }
    @Override
    public boolean hasNext() {
        return ptr<al.size();
    }
}