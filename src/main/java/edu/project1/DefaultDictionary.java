package edu.project1;

import org.jetbrains.annotations.NotNull;

public class DefaultDictionary implements Dictionary {
    private String[] words;

    public DefaultDictionary() {
        words = new String[0];
    }

    public void addWord(String word) {
        String[] newArr = new String[words.length + 1];
        for (int i = 0; i < words.length; ++i) {
            newArr[i] = words[i];
        }
        newArr[newArr.length - 1] = word;
        words = newArr;
    }

    public @NotNull String generate() {
        int index = (int) (Math.random() * words.length);
        return words[index];
    }
}
