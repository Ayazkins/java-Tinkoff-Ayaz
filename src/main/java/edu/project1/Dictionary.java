package edu.project1;

import org.jetbrains.annotations.NotNull;

public interface Dictionary {
    void addWord(String word);

    @NotNull String generate();
}
