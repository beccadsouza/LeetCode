package _211;
/*
* Created by Rebecca Dsouza on 8/6/20
*/

import java.util.*;

public class DesignAddAndSearchWordsDataStructure {
    public static void main(String[] args){
        WordDictionary wordDictionary = new WordDictionary();
        wordDictionary.addWord("bad");
        wordDictionary.addWord("dad");
        wordDictionary.addWord("mad");
        wordDictionary.search("pad"); // return False
        wordDictionary.search("bad"); // return True
        wordDictionary.search(".ad"); // return True
        wordDictionary.search("b.."); // return True
    }
}
class Trie {
    HashMap<Character, Trie> hm;
    boolean isEnd = false;
    public Trie() {hm = new HashMap<>();}
    public void insert(String word) {
        if(word.length()==1){
            if(!hm.containsKey(word.charAt(0))) hm.put(word.charAt(0),new Trie());
            isEnd = true;
            return;
        }
        if(!hm.containsKey(word.charAt(0))){
            Trie temp = new Trie();
            temp.insert(word.substring(1));
            hm.put(word.charAt(0), temp);
        }
        else hm.get(word.charAt(0)).insert(word.substring(1));
    }

    public boolean search(String word) {
        if(word.charAt(0)=='.'){
            if(word.length()==1) return (hm.size()>0) && isEnd;
            else{
                for(Map.Entry<Character, Trie> x:hm.entrySet())
                    if(x.getValue().search(word.substring(1))) return true;
                return false;
            }
        }
        else if(word.length()==1) return hm.containsKey(word.charAt(0)) && isEnd;
        else if(hm.containsKey(word.charAt(0))) return hm.get(word.charAt(0)).search(word.substring(1));
        else return false;
    }
}
class WordDictionary {
    Trie trie;
    public WordDictionary() {
        trie = new Trie();
    }
    public void addWord(String word) {
        trie.insert(word);
    }
    public boolean search(String word) {
        return trie.search(word);
    }
}
