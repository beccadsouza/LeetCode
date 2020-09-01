package _705;
/*
* Created by Rebecca Dsouza on 8/3/20
*/

public class DesignHashSet {
    public static void main(String[] args){
        MyHashSet hashSet = new MyHashSet();
        hashSet.add(1);
        hashSet.add(2);
        hashSet.contains(1);    // returns true
        hashSet.contains(3);    // returns false (not found)
        hashSet.add(2);
        hashSet.contains(2);    // returns true
        hashSet.remove(2);
        hashSet.contains(2);    // returns false (already removed)
    }
}
class Node{
    Node next;
    int val;
    public Node(int val){ this.val = val; }
}

class MyHashSet {

    /** Initialize your data structure here. */
    Node[] set;
    int size = 1000;
    public MyHashSet() {
        set = new Node[this.size];
    }
    public void add(int key) {
        int hash = key%this.size;
        if(set[hash]==null) set[hash] = new Node(key);
        else if(set[hash].val==key) return;
        else{
            Node pre = set[hash], curr = set[hash].next;
            while(curr!=null){
                if(curr.val==key) return;
                pre = curr;
                curr = curr.next;
            }
            pre.next = new Node(key);
        }
    }

    public void remove(int key) {
        int hash = key%this.size;
        if(set[hash]==null) return;
        else if(set[hash].val==key) set[hash] = set[hash].next;
        else{
            Node pre = set[hash], curr = set[hash].next;
            while(curr!=null){
                if(curr.val==key) {
                    pre.next = curr.next;
                    break;
                }
                pre = curr;
                curr = curr.next;
            }
        }
    }

    /** Returns true if this set contains the specified element */
    public boolean contains(int key) {
        int hash = key%this.size;
        Node curr = set[hash];
        while(curr!=null){
            if(curr.val==key) return true;
            curr = curr.next;
        }
        return false;
    }
}

/**
 * Your MyHashSet object will be instantiated and called as such:
 * MyHashSet obj = new MyHashSet();
 * obj.add(key);
 * obj.remove(key);
 * boolean param_3 = obj.contains(key);
 */