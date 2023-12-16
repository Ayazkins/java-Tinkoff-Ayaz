package edu.hw10.Task1.RandomValuesGenerator;

import edu.hw10.Task1.Annotations.Max;
import edu.hw10.Task1.Annotations.Min;
import java.lang.reflect.Parameter;
import java.util.Random;

public class RandomIntegerGenerator implements RandomGenerator<Integer> {
    private static final Random RANDOM = new Random();

    @Override
    public Integer generate(Parameter parameter) {
        Min min = parameter.getAnnotation(Min.class);
        Max max = parameter.getAnnotation(Max.class);
        int minVal = Integer.MIN_VALUE;
        int maxVal = Integer.MAX_VALUE;
        if (min != null) {
            minVal = min.value();
        }
        if (max != null) {
            maxVal = max.value();
        }
        return RANDOM.nextInt(minVal, maxVal + 1);
    }
}
