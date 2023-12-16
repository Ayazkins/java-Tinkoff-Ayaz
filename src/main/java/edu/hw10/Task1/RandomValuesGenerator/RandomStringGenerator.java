package edu.hw10.Task1.RandomValuesGenerator;

import edu.hw10.Task1.Annotations.NotNull;
import java.lang.reflect.Parameter;
import java.util.Random;

public class RandomStringGenerator implements RandomGenerator<String> {
    private static final int MIN_LENGTH = 2;
    private static final int MAX_LENGTH = 50;
    private static final int START_ALPHABET = 'a';

    private static final int END_ALPHABET = 'z';
    private static final Random RANDOM = new Random();

    @Override
    public String generate(Parameter parameter) {
        NotNull notNull = parameter.getAnnotation(NotNull.class);
        if (notNull == null && RANDOM.nextInt(MIN_LENGTH - 1, MAX_LENGTH) == MIN_LENGTH - 1) {
            return null;
        }
        int length = RANDOM.nextInt(MIN_LENGTH, MAX_LENGTH);
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < length; ++i) {
            stringBuilder.append(RANDOM.nextInt(START_ALPHABET, END_ALPHABET + 1));
        }
        return stringBuilder.toString();
    }
}
