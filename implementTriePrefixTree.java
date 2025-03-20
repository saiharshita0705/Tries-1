// Implement Trie (Prefix Tree)(https://leetcode.com/problems/implement-trie-prefix-tree/)

// Time Complexity : O(l) for insertion, O(l) for search, O(l) for prefix
// Space Complexity : O(n x l) for insertion 
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no

// Your code here along with comments explaining your approach in three sentences only
/*
 * Here, trienode class is created to keep elements as nodes. For insertion, let curr is the root. While traversing along the word, if the
 * root.children at place ch - a is null insert a new trienode and make curr to curr.children[ch-a]. and when the word ends make curr.isend
 * to true. For search, same way as above if the curr.children is null then return null if not return curr.isEnd. Same way for prefix, if
 * the curr.children is null then return null if not return true.
 */
class Trie {
    class TrieNode{
        TrieNode children[];
        boolean isEnd;
        public TrieNode(){
            this.children = new TrieNode[26];
        }
    }
    private TrieNode root;
    public Trie() {
        this.root = new TrieNode();
    }

    public void insert(String word) {
        TrieNode curr  = root;
        for(int i = 0; i<word.length();i++){
            char ch = word.charAt(i);
            if(curr.children[ch - 'a'] == null){
                curr.children[ch - 'a'] = new TrieNode();
            }
            curr = curr.children[ch - 'a'];
        }
        curr.isEnd = true;
    }
    
    public boolean search(String word) {
        TrieNode curr  = root;
        for(int i = 0; i<word.length();i++){
            char ch = word.charAt(i);
            if(curr.children[ch - 'a'] == null){
                return false;
            }
            curr = curr.children[ch - 'a'];
        }
        return curr.isEnd;
        
    }
    
    public boolean startsWith(String prefix) {
        TrieNode curr  = root;
        for(int i = 0; i<prefix.length();i++){
            char ch = prefix.charAt(i);
            if(curr.children[ch - 'a'] == null){
                return false;
            }
            curr = curr.children[ch - 'a'];
        }
        return true;
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */