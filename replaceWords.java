// Replace Words (https://leetcode.com/problems/replace-words/)

// Time Complexity : O(n x l + m x w) nxl for insertion, mxw for finding the shortest word in sentence.
// Space Complexity : O(n x l + m x w)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no

// Your code here along with comments explaining your approach in three sentences only
/*
 * Here, trienode class is created to keep elements as nodes. First insert all words in dixtionary into a trie and then find the shortest
 * word to replace any word in sentence, let curr is the root. While traversing along the word, if the curr.children at place ch - a is null
 * or curr.isEnd is true then break and add char to replacement and curr to curr.children[ch - a] and after breaking if curr.isEnd is true
 * add replacement to result else add previous currWord to resut. When i is not the first word append space to result for all words before
 * performing all above. Finally return result in string format.
 */
class Solution {
    class TrieNode{
        TrieNode []children;
        boolean isEnd;
        public TrieNode(){
            this.children = new TrieNode[26];
        }
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
    private TrieNode root;
    public String replaceWords(List<String> dictionary, String sentence) {
        this.root = new TrieNode();
        for(String str: dictionary){
            insert(str);
        }
        String []words = sentence.split(" ");
        StringBuilder result = new StringBuilder();
        for(int i = 0; i< words.length;i++){
            if(i!=0) result.append(" ");
            String currWord = words[i];
            TrieNode curr = root;
            StringBuilder replacement = new StringBuilder();
            for(int j = 0; j < currWord.length();j++){
                char ch = currWord.charAt(j);
                if(curr.children[ch - 'a'] == null || curr.isEnd) break;
                replacement.append(ch);
                curr = curr.children[ch - 'a'];
            }
            if(curr.isEnd){
                result.append(replacement);
            }
            else{
                result.append(currWord);
            }
                
        }
        return result.toString();

    }
    
}
