package edu.project1;

import org.jetbrains.annotations.NotNull;

public interface IDictionary {
    void addWord(String word);

    @NotNull String generate();
}
