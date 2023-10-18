package edu.project1;

import java.util.List;

public class WordDictionary {
    private String[] words;

    public WordDictionary() {
        words = new String[0];
    }

    public void AddWord(String word) {
        words = new String[words.length + 1];
        words[words.length - 1] = word;
    }
    public String Generate() {
        int index = (int) (Math.random() * words.length);
        return words[index];
    }
}
