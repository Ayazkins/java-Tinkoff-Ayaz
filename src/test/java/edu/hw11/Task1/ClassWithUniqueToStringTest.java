package edu.hw11.Task1;

import net.bytebuddy.ByteBuddy;
import net.bytebuddy.dynamic.DynamicType;
import net.bytebuddy.implementation.FixedValue;
import net.bytebuddy.implementation.MethodCall;
import net.bytebuddy.matcher.ElementMatchers;
import org.junit.jupiter.api.Test;
import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ClassWithUniqueToStringTest {
    @Test
    public void newClass()
        throws NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        Object testClass = new ByteBuddy()
            .subclass(Object.class)
            .name("TestClass")
            .method(ElementMatchers.isToString())
            .intercept(FixedValue.value("Hello, ByteBuddy!"))
            .make()
            .load(getClass().getClassLoader())
            .getLoaded()
            .newInstance();
        assertEquals(testClass.toString(), "Hello, ByteBuddy!");
    }
}
