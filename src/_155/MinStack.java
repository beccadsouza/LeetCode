package _155;

import java.util.*;

/*
 * Created by Rebecca Dsouza on 4/11/20
 */
public class MinStack {
    /** initialize your data structure here. */
    Stack<Integer> stack, min;
    public MinStack() {
        stack = new Stack<>();
        min = new Stack<>();
    }
    public void push(int x) {
        if(stack.size()==0 || x<min.peek()){
            min.push(x);
        }
        else{
            min.push(min.peek());
        }
        stack.push(x);
    }
    public void pop() {
        stack.pop();
        min.pop();
    }
    public int top() {
        return stack.peek();
    }
    public int getMin() {
        return min.peek();
    }
    public static void main(String[] args) {
        MinStack minStack = new MinStack();
        minStack.push(-2);
        minStack.push(0);
        minStack.push(-3);
        System.out.println(minStack.getMin()); // return -3
        minStack.pop();
        System.out.println(minStack.top());    // return 0
        System.out.println(minStack.getMin()); // return -2
    }
}
