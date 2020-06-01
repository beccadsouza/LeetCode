package _208;

import java.util.*;

/*
 * Created by Rebecca Dsouza on 6/1/20
 */
public class ImplementTriePrefixTree {
    public static void main(String[] args) {
        Trie trie = new Trie();
        trie.insert("apple");
        System.out.println(trie.search("apple"));   // returns true
        System.out.println(trie.search("app"));     // returns false
        System.out.println(trie.startsWith("app")); // returns true
        trie.insert("app");
        System.out.println(trie.search("app"));     // returns true
    }
}


/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */

class Trie {

    HashMap<Character, Trie> hm;

    /** Initialize your data structure here. */
    public Trie() {
        hm = new HashMap<>();
    }

    /** Inserts a word into the trie. */
    public void insert(String word) {
        if(word.length()==0){
            hm.put('0',new Trie());
            return;
        }
        if(!hm.containsKey(word.charAt(0))){
            Trie temp = new Trie();
            temp.insert(word.substring(1));
            hm.put(word.charAt(0), temp);
        }
        else{
            hm.get(word.charAt(0)).insert(word.substring(1));
        }
    }

    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        if(word.length()==0 && hm.containsKey('0')) return true;
        else if(word.length()==0 && !hm.containsKey('0')) return false;
        else if(hm.containsKey(word.charAt(0))){
            return hm.get(word.charAt(0)).search(word.substring(1));
        }
        else return false;
    }

    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        if(prefix.length()==0) return true;
        if(hm.containsKey(prefix.charAt(0))){
            return hm.get(prefix.charAt(0)).startsWith(prefix.substring(1));
        }
        else return false;
    }
}
