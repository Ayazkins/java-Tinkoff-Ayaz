package edu.hw10.Task1;

import edu.hw10.Task1.Annotations.NotNull;
import edu.hw10.Task1.RandomValuesGenerator.RandomGenerator;
import java.lang.reflect.Constructor;
import java.lang.reflect.Executable;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.lang.reflect.Parameter;
import java.util.Map;

public class ObjectGenerator {
    public static final String CAN_NOT_CREATE_CLASS = "Can not create class";
    private final Map<String, RandomGenerator<?>> randomGeneratorMap;

    public ObjectGenerator(Map<String, RandomGenerator<?>> randomGeneratorMap) {
        this.randomGeneratorMap = randomGeneratorMap;
    }

    public <T> T nextObject(Class<T> tClass, String method)
        throws InvocationTargetException, InstantiationException, IllegalAccessException {
        try {
            return nextObject(tClass);
        } catch (IllegalArgumentException e) {
            Method actualMethod = getFactoryMethod(tClass, method);
            if (actualMethod != null) {
                return (T) createObject(actualMethod);

            }
        }
        throw new IllegalArgumentException(CAN_NOT_CREATE_CLASS);
    }

    public <T> T nextObject(Class<T> tClass)
        throws InvocationTargetException, InstantiationException, IllegalAccessException {
        Constructor<?> constructor = getConstructor(tClass);
        if (constructor != null) {
            return (T) createObject(constructor);
        }
        throw new IllegalArgumentException(CAN_NOT_CREATE_CLASS);
    }

    private Constructor<?> getConstructor(Class<?> tClass) {
        for (Constructor<?> constructor : tClass.getConstructors()) {
            if (Modifier.isPublic(constructor.getModifiers())) {
                return constructor;
            }
        }
        return null;
    }

    private Method getFactoryMethod(Class<?> tClass, String methodName) {
        for (Method method : tClass.getMethods()) {
            if (method.getName().equals(methodName)
                && Modifier.isPublic(method.getModifiers())
                && Modifier.isStatic(method.getModifiers())) {
                return method;
            }
        }
        return null;
    }

    private Object createObject(Executable executable)
        throws InvocationTargetException, InstantiationException, IllegalAccessException {
        Parameter[] parameters = executable.getParameters();
        Object[] args = new Object[parameters.length];
        for (int i = 0; i < args.length; ++i) {
            Parameter parameter = parameters[i];
            Object value = getObject(parameter);
            args[i] = value;
        }
        if (executable instanceof Constructor<?>) {
            return ((Constructor<?>) executable).newInstance(args);
        } else {
            return ((Method) executable).invoke(null, args);
        }
    }

    private Object getObject(Parameter parameter) {
        Object val;
        try {
            val = randomGeneratorMap.get(parameter.getType().getName()).generate(parameter);
        } catch (NullPointerException e) {
            return null;
        }
        NotNull notNull = parameter.getAnnotation(NotNull.class);
        if (notNull != null && val == null) {
            throw new IllegalArgumentException("Value can not be null");
        }
        return val;
    }
}
