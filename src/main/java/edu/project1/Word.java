package edu.project1;

public class Word {

    private final String word;

    private String curWord;

    public Word(WordDictionary wordDictionary) {
        word = wordDictionary.generate();
        StringBuilder sb = new StringBuilder();
        while (sb.length() < word.length()) {
            sb.append("*");
        }
        curWord = sb.toString();
    }

    public boolean tryChar(char newChar) {
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

    public String getCurWord() {
        return curWord;
    }

    public boolean isWordFull() {
        return word.equals(curWord);
    }

    public int length() {
        return word.length();
    }
}
