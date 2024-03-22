package HayanLee.이진탐색.기출문제.Q30_가사검색.풀이과정.Trie구조사용;

import java.util.*;

class Solution {
    public int[] solution(String[] words, String[] queries) {
        Trie[] tries = new Trie[10001];
        Trie[] reverseTries = new Trie[10001];
        int[] answer = new int[queries.length];

        // Initializing tries and reverseTries arrays
        for (String word : words) {
            int len = word.length();
            if (tries[len] == null) {
                tries[len] = new Trie();
                reverseTries[len] = new Trie();
            }
            tries[len].insert(word);
            reverseTries[len].insert(new StringBuilder(word).reverse().toString());
        }

        // Searching for each query
        for (int i = 0; i < queries.length; i++) {
            String query = queries[i];
            int len = query.length();
            if (query.charAt(0) == '?') {
                if (reverseTries[len] == null) {
                    answer[i] = 0;
                } else {
                    answer[i] = reverseTries[len].search(new StringBuilder(query).reverse().toString());
                }
            } else {
                if (tries[len] == null) {
                    answer[i] = 0;
                } else {
                    answer[i] = tries[len].search(query);
                }
            }
        }

        return answer;
    }

    class Trie {
        TrieNode root;

        Trie() {
            this.root = new TrieNode();
        }

        void insert(String word) {
            TrieNode node = this.root;
            for (char c : word.toCharArray()) {
                node.count++;
                node = node.children.computeIfAbsent(c, ch -> new TrieNode());
            }
            node.count++;
        }

        int search(String query) {
            TrieNode node = this.root;
            for (char c : query.toCharArray()) {
                if (c == '?') {
                    return node.count;
                }
                if (!node.children.containsKey(c)) {
                    return 0;
                }
                node = node.children.get(c);
            }
            return node.count;
        }
    }

    class TrieNode {
        Map<Character, TrieNode> children;
        int count;

        TrieNode() {
            this.children = new HashMap<>();
            this.count = 0;
        }
    }
}

