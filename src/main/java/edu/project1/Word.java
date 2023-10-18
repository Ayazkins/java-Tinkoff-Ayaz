package edu.project1;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import java.util.Arrays;

public class Word {

    private final String word;

    private String curWord;

    public Word(WordDictionary wordDictionary) {
        word = wordDictionary.Generate();
        StringBuilder sb = new StringBuilder();
        while (sb.length() < word.length()) {
            sb.append("*");
        }
        curWord = sb.toString();
    }

    public boolean TryChar(char newChar) {
        int index = word.indexOf(newChar);
        if (index == -1) {
            return false;
        }
        while (index != -1) {
            char[] chars = curWord.toCharArray();
            chars[index] = newChar;
            curWord = String.valueOf(chars);
            index = word.indexOf(newChar, index + 1);
        }
        return true;
    }

    public String GetCurWord() {
        return curWord;
    }

    public boolean IsWordFull() {
        return word.equals(curWord);
    }

    public int Length() {
        return word.length();
    }
}
