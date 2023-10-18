package edu.project1;

import java.util.List;

public class WordDictionary {
    private final String[] words;

    public WordDictionary() {
        words = new String[4];
        words[0] = "java";
        words[1] = "coffee";
        words[2] = "bridge";
        words[3] = "validity";
    }

    public String Generate() {
        int index = (int) (Math.random() * words.length);
        return words[index];
    }
}
