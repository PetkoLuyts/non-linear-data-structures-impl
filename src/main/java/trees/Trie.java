package trees;

import java.util.HashMap;
import java.util.Map;

public class Trie {
    private TrieNode root;

    private static class TrieNode {
        Map<Character, TrieNode> children;
        boolean endOfString;

        public TrieNode() {
            children = new HashMap<>();
            endOfString = false;
        }
    }

    public Trie() {
        this.root = new TrieNode();
        System.out.println("The Trie has been created!");
    }

    public void insert(String word) {
        TrieNode current = root;

        for (int i = 0; i < word.length(); i++) {
            char ch = word.charAt(i);
            TrieNode node = current.children.get(ch);

            if (node == null) {
                current.children.put(ch,node);
            }

            current = node;
        }

        current.endOfString = true;
        System.out.println("Successfully inserted " + word + " in Trie");
    }
}
