package edu.hw11.Task2;

import net.bytebuddy.ByteBuddy;
import net.bytebuddy.implementation.MethodDelegation;
import net.bytebuddy.matcher.ElementMatchers;
import org.junit.jupiter.api.Test;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import static net.bytebuddy.matcher.ElementMatchers.isDeclaredBy;
import static net.bytebuddy.matcher.ElementMatchers.returns;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class Task2 {
    @Test
    public void changeOperationTest()
        throws NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        Method method = ArithmeticUtils.class.getDeclaredMethod("sum", int.class, int.class);
        ArithmeticUtils a = new ByteBuddy()
            .subclass(ArithmeticUtils.class)
            .method(ElementMatchers.named(method.getName())
                .and(isDeclaredBy(ArithmeticUtils.class)
                    .and(returns(method.getReturnType()))))
            .intercept(MethodDelegation.to(NewArithmeticUtils.class))
            .make()
            .load(getClass().getClassLoader())
            .getLoaded()
            .getDeclaredConstructor()
            .newInstance();
        assertEquals(a.sum(5, 4), 20);
    }
}
