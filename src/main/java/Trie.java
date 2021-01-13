import java.util.HashMap;
import java.util.Map;

public class Trie {

    class Node{
        boolean isEndOfWord;
        Map<Character, Node> children;
        public Node(){
            children = new HashMap<Character, Node>();
            isEndOfWord = false;
        }
    }
    Node root = null;
    /** Initialize your data structure here. */
    public Trie() {
        root = new Node();
    }

    /** Inserts a word into the trie. */
    public void insert(String word) {
        Node node = root;
        for(int i=0;i<word.length();i++){
            Node temp = node.children.get(word.charAt(i));
            if(temp == null){
                Node newNode = new Node();
                node.children.put(word.charAt(i),newNode);
                node = newNode;
            } else {
                node = temp;
            }
        }
        node.isEndOfWord = true;
    }

    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        Node node = root;
        for(int i=0;i<word.length();i++){
            Node temp = node.children.get(word.charAt(i));
            if(temp == null){ return false;}
            else {
                node = temp;
            }
        }
        return node.isEndOfWord;
    }

    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        Node node = root;
        for(int i=0;i<prefix.length();i++){
            Node temp = node.children.get(prefix.charAt(i));
            if(temp == null){ return false;}
            else {
                node = temp;
            }
        }
        return true;
    }

    public static void main(String [] args){
        Trie trie = new Trie();
        trie.insert("hello");
        trie.insert("hell");
        System.out.println(trie.search("hel"));
        System.out.println(trie.startsWith("hel"));
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */

