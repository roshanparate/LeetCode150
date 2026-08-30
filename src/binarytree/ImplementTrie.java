package binarytree;

public class ImplementTrie {

    private TrieNode root;
    public ImplementTrie() {
        root = new TrieNode();
    }

    public void insert(String word) {
        TrieNode node = root;
        for(int i = 0; i < word.length(); i++){
            char ch = word.charAt(i);
            if(!node.containsChar(ch)){
                node.addChar(ch);
            }
            node = node.getChild(ch);
        }
        node.isEnd();
    }

    public boolean search(String word) {
        TrieNode node = root;
        for(int i = 0; i < word.length(); i++){
            char ch = word.charAt(i);
            if(!node.containsChar(ch)){
                return false;
            }else{
                node = node.getChild(ch);
            }
        }

        if(node.isEndingNode()){
            return true;
        }else{
            return false;
        }
    }

    public boolean startsWith(String prefix) {
        TrieNode node = root;
        for(int i = 0; i < prefix.length(); i++){
            char ch = prefix.charAt(i);
            if(!node.containsChar(ch)){
                return false;
            }else {
                node = node.getChild(ch);
            }
        }
        return true;
    }
}

class TrieNode {
    private TrieNode[] children;
    public boolean isEnd;

    public TrieNode() {
        this.children = new TrieNode[26];
        this.isEnd = false;
    }

    public boolean containsChar(char ch){
        return children[ch - 'a'] != null;
    }

    public void addChar(char ch){
        children[ch - 'a'] = new TrieNode();
    }

    public TrieNode getChild(char ch){
        return children[ch - 'a'];
    }

    public boolean isEnd(){
        return this.isEnd = true;
    }

    public boolean isEndingNode(){
        return this.isEnd;
    }
}

class Main {
    public static void main(String[] args) {
        ImplementTrie trie = new ImplementTrie();
        trie.insert("apple");
        System.out.println(trie.search("apple"));   // returns true
        System.out.println(trie.search("app"));     // returns false
        System.out.println(trie.startsWith("app")); // returns true
        trie.insert("app");
        System.out.println(trie.search("app"));     // returns true
    }
}
