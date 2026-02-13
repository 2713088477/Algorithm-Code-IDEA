package ZuoVideo44;

public class Code01_TrieTree {
    static class Trie1{
        class TrieNode{
            int pass;
            int end;
            TrieNode[] next = new TrieNode[26];
        }
        private TrieNode root;
        /** Initialize your data structure here. */
        public Trie1() {
            root = new TrieNode();
        }
        /** Inserts a word into the trie. */
        public void insert(String word) {
            char[] array = word.toCharArray();
            TrieNode node = root;
            node.pass++;
            for (char c : array) {
                int index = c-'a';
                if(node.next[index]==null){
                    node.next[index] = new TrieNode();
                }
                node = node.next[index];
                node.pass++;
            }
            node.end++;
        }

        /** delete the word in the trie*/
        public void delete(String word){
            char[] array = word.toCharArray();
            TrieNode node = root;
            root.pass--;
            for (char c : array) {
                int index = c-'a';
                //这个方法我实现的时候，必须要确保word存在于前缀树中
                node = node.next[index];
                node.pass--;
            }
            node.end--;
        }

        /** Returns if the word is in the trie. */
        public boolean search(String word) {
            char[] array = word.toCharArray();
            TrieNode node = root;
            for (char c : array) {
                int index = c-'a';
                if(node.next[index]==null) return false;
                node = node.next[index];
            }
            return node.end >0;
        }

        /** Returns if there is any word in the trie that starts with the given prefix. */
        public int startsWith(String prefix) {
            char[] array = prefix.toCharArray();
            TrieNode node = root;
            for (char c : array) {
                int index = c-'a';
                if(node.next[index]==null) return 0;
                node = node.next[index];
            }
            return node.pass;
        }
    }
}
