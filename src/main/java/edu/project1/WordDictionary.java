package edu.project1;

public class WordDictionary {
    private String[] words;

    public WordDictionary() {
        words = new String[0];
    }

    public void addWord(String word) {
        words = new String[words.length + 1];
        words[words.length - 1] = word;
    }

    public String generate() {
        int index = (int) (Math.random() * words.length);
        return words[index];
    }
}
