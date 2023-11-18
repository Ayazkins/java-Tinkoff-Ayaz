package edu.hw6;

import edu.hw6.Task5.HackerNews;
import org.junit.jupiter.api.Test;
import java.util.Arrays;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class Task5Test {
    @Test
    public void titleTest() {
        String newsTitle = HackerNews.news(38290145);
        assertEquals(newsTitle, "The real realtime preemption end game");
    }

    @Test
    public void topStoriesTest() {
        long[] topStories = HackerNews.hackerNewsTopStories();
        assertTrue(topStories.length > 0);
        for (var a : topStories) {
            assertThat(a).isPositive().isNotNull();
        }
    }
}
