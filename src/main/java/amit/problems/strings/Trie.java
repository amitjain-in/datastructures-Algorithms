package amit.problems.strings;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * Credit: https://github.com/eugenp/tutorials/blob/master/data-structures/
 */
public class Trie {

    private final TrieNode root;

    public Trie() {
        root = new TrieNode(null);
    }

    /**
     * Inserts the word into this trie structure. O(n) where n is the word length.
     *
     * @param word - The word to be inserted in the trie.
     */
    public void insert(String word) {
        TrieNode current = root;

        for (int i = 0; i < word.length(); i++) {
            final TrieNode parent = current;
            current = current.getChildren().computeIfAbsent(word.charAt(i), c -> new TrieNode(parent));
        }
        current.setEndOfWord(true);
    }

    /**
     * Deletes the word from this trie.
     *
     * @param word - The word to be deleted.
     * @return true if the word was deleted and false otherwise
     */
    public boolean delete(String word) {
        return delete(root, word, 0);
    }

    public boolean containsNode(String word) {
        TrieNode current = root;

        for (int i = 0; i < word.length(); i++) {
            char ch = word.charAt(i);
            TrieNode node = current.getChildren().get(ch);
            if (node == null) {
                return false;
            }
            current = node;
        }
        return current.isEndOfWord();
    }

    private boolean delete(TrieNode current, String word, int index) {
        if (index == word.length()) {
            if (!current.isEndOfWord()) {
                return false;
            }
            current.setEndOfWord(false);
            return current.getChildren().isEmpty();
        }
        char ch = word.charAt(index);
        TrieNode node = current.getChildren().get(ch);
        if (node == null) {
            return false;
        }
        boolean shouldDeleteCurrentNode = delete(node, word, index + 1) && !node.isEndOfWord();

        if (shouldDeleteCurrentNode) {
            current.getChildren().remove(ch);
            return current.getChildren().isEmpty();
        }
        return false;
    }

    /**
     * Find a word into this trie if it exists
     *
     * @param word - The word to find
     * @return - true if the word exists in this trie and false otherwise.
     */
    public boolean find(String word) {
        TrieNode current = findNode(word);
        return current != null && current.isEndOfWord();
    }

    private TrieNode findNode(String word) {
        TrieNode current = root;
        for (int i = 0; i < word.length(); i++) {
            char ch = word.charAt(i);
            TrieNode node = current.getChildren().get(ch);
            if (node == null) {
                return null;
            }
            current = node;
        }
        return current;
    }

    //TODO Implement this.
    public List<String> prefixSearch(String prefix) {
        TrieNode current = findNode(prefix);
        List<String> results = new LinkedList<>();
        if (current != null) {
            Queue<TrieNode> q = new LinkedBlockingQueue<>();
            while(!q.isEmpty()) {
                
            }
        }
        return null;
    }

    static class TrieNode {

        private final HashMap<Character, TrieNode> children = new HashMap<>();
        private final TrieNode parent;
        private boolean isEndOfWord;

        TrieNode(TrieNode parent) {
            this.parent = parent;
        }

        public HashMap<Character, TrieNode> getChildren() {
            return children;
        }

        public void setEndOfWord(boolean endOfWord) {
            isEndOfWord = endOfWord;
        }

        public boolean isEndOfWord() {
            return isEndOfWord;
        }

        public TrieNode getParent() {
            return parent;
        }
    }
}


