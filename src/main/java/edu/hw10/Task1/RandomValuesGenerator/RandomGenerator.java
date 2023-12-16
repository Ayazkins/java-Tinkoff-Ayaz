package edu.hw10.Task1.RandomValuesGenerator;

import java.lang.reflect.Parameter;

public interface RandomGenerator<T> {
    T generate(Parameter parameter);

}
