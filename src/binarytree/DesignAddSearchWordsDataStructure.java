package binarytree;

public class DesignAddSearchWordsDataStructure {


    public static void main(String[] args) {
        WordDictionary wordDictionary = new WordDictionary();
        wordDictionary.addWord("bad");
        wordDictionary.addWord("dad");
        wordDictionary.addWord("mad");
        System.out.println(wordDictionary.search("pad")); // Output: false
        System.out.println(wordDictionary.search("bad")); // Output: true
        System.out.println(wordDictionary.search(".ad")); // Output: true
        System.out.println(wordDictionary.search("b..")); // Output: true
    }

}

class WordDictionary{

    private TrieNodeDS root;

    public WordDictionary() {
        this.root = new TrieNodeDS();
    }

    public void addWord(String word) {
        TrieNodeDS node = root;
        for(int i = 0; i < word.length(); i++){

            char ch = word.charAt(i);

            if(word.charAt(i) == '.') continue;

            if(!node.containsKey(ch)){
                node.put(ch, new TrieNodeDS());
            }
            node = node.get(ch);
        }
        node.setEnd();
    }

    public boolean search(String word) {
        return searchWord(word, root, 0);
    }

    public boolean searchWord(String word, TrieNodeDS node, int index){
        if(index == word.length()){
            return node.isEnd();
        }

        char ch = word.charAt(index);
        if(ch == '.'){
            for(TrieNodeDS child: node.children){
                if(child != null && searchWord(word, child, index + 1)){
                    return true;
                }
            }
            return false;
        }else{
            TrieNodeDS child = node.get(ch);
            return child != null && searchWord(word, child, index + 1);
        }
    }
}

class TrieNodeDS{
    public TrieNodeDS[] children;
    private boolean isEnd;

    public TrieNodeDS(){
        this.children = new TrieNodeDS[256];
        this.isEnd = false;
    }

    public boolean containsKey(char ch){
        return children[ch - 'a'] != null;
    }

    public void put(char ch, TrieNodeDS node){
        children[ch - 'a'] = node;
    }

    public TrieNodeDS get(char ch){
        return children[ch - 'a'];
    }

    public boolean setEnd(){
        return this.isEnd = true;
    }

    public boolean isEnd(){
        return this.isEnd;
    }
}
