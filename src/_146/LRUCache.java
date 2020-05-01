package _146;

import java.util.*;

/*
 * Created by Rebecca Dsouza on 4/24/20
 */

class Node{
    Node prev = null, next = null;
    int key, value;
    public Node(int key, int value){
        this.key = key;
        this.value = value;
    }
    public String toString(){return String.valueOf(this.value);}
}

class LRUCache {
    HashMap<Integer, Node> hm = new HashMap<>();
    Node start=null,last = null;
    int capacity;
    public LRUCache(int capacity) {this.capacity = capacity;}

    public int get(int key) {
        if(hm.containsKey(key)){
            Node temp = hm.get(key);
            if (start.key != temp.key) {
                if (last.key == temp.key) {
                    last = last.prev;
                    last.next = null;
                } else {
                    temp.next.prev = temp.prev;
                    temp.prev.next = temp.next;
                }
                temp.next = start;
                temp.prev = null;
                start.prev = temp;
                start = temp;
            }
            return temp.value;
        }
        else return -1;
    }

    public void put(int key, int value) {
        if(start==null && last==null){
            Node temp = new Node(key, value);
            start = temp;
            last = temp;
            hm.put(key,temp);
        }
        else{
            if(!hm.containsKey(key)){
                Node temp = new Node(key, value);
                temp.next = start;
                start.prev = temp;
                start = temp;
                hm.put(key,temp);
                if(hm.size()>capacity){
                    hm.remove(last.key);
                    last = last.prev;
                    last.next = null;
                }
            }
            else{
                Node temp = hm.get(key);
                temp.value = value;
                if(start.key!=temp.key){
                    if(last.key==temp.key){
                        last = last.prev;
                        last.next = null;
                    }
                    else{
                        temp.next.prev = temp.prev;
                        temp.prev.next = temp.next;
                    }
                    temp.next = start;
                    temp.prev = null;
                    start.prev = temp;
                    start = temp;
                }
            }
        }
    }

    public static void main(String[] args){
        LRUCache cache = new LRUCache( 2 /* capacity */ );
        cache.put(1, 1);
        cache.put(2, 2);
        System.out.println(cache.get(1));       // returns 1
        cache.put(3, 3);    // evicts key 2
        System.out.println(cache.get(2));       // returns -1 (not found)
        cache.put(4, 4);    // evicts key 1
        System.out.println(cache.get(1));       // returns -1 (not found)
        System.out.println(cache.get(3));       // returns 3
        System.out.println(cache.get(4));       // returns 4
    }
}