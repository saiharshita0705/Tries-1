// Longest Word in Dictionary(https://leetcode.com/problems/longest-word-in-dictionary/)

// Time Complexity : O(n x l) nxl for insertion
// Space Complexity : O(n x l)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no

// Your code here along with comments explaining your approach in three sentences only
/*
 * Here, first build a trie using the words in the dictionary and traverse along the trie to find the max length string on when every character has
 * the isEnd as true. And if you find the words of same length do nothing as the traversal goes lexographically only. If greater word is found then
 * replace max String with word found. Finally, return maxStr.
 */
// 1
class Solution {
    class TrieNode{
        TrieNode []children;
        boolean isEnd;
        public TrieNode(){
            this.children = new TrieNode[26];
        }
    }
    private void insert(TrieNode root, String word){
        TrieNode curr = root;
        for(int i = 0; i<word.length();i++){
            char ch = word.charAt(i);
                if(curr.children[ch - 'a'] == null){
                    curr.children[ch - 'a'] = new TrieNode();
                }
                curr = curr.children[ch - 'a'];
            }
            curr.isEnd = true;
    }
    public String longestWord(String[] words) {
        TrieNode root = new TrieNode();
        for(String word: words){
            insert(root, word);
        }
        Queue<TrieNode> q = new LinkedList<>();
        Queue<String> str = new LinkedList<>();
        q.add(root);
        str.add("");
        String currStr = "";
        while(!q.isEmpty()){
            TrieNode node = q.poll();
            currStr = str.poll();
            for(int i = 25; i>=0;i--){
                if(node.children[i] != null && node.children[i].isEnd){
                    q.add(node.children[i]);
                    String newStr = currStr + (char) ('a' + i);
                    str.add(newStr);
                }
            }
        }
        return currStr;
    }
}
// 2
class Solution {
    class TrieNode{
        TrieNode []children;
        boolean isEnd;
        public TrieNode(){
            this.children = new TrieNode[26];
        }
    }
    private void insert(TrieNode root, String word){
        TrieNode curr = root;
        for(int i = 0; i<word.length();i++){
            char ch = word.charAt(i);
                if(curr.children[ch - 'a'] == null){
                    curr.children[ch - 'a'] = new TrieNode();
                }
                curr = curr.children[ch - 'a'];
            }
            curr.isEnd = true;
    }

    String maxStr;
    public String longestWord(String[] words) {
        TrieNode root = new TrieNode();
        for(String word: words){
            insert(root, word);
        }
        this.maxStr = "";
        StringBuilder path = new StringBuilder();
        helper(root, path);
        return maxStr;
    }
    private void helper(TrieNode curr, StringBuilder path){
        //base
        if(path.length()>maxStr.length()){
            maxStr = path.toString();
        }
        //logic
        for(int i = 0; i<=25;i++){
            if(curr.children[i]!=null && curr.children[i].isEnd){
            char ch = (char)('a'+i);
            int le = path.length();
            //action
            path.append(ch);
            //recurse
            helper(curr.children[i], path);
            //backtrack
            path.setLength(le);
            }
        }

    }
}