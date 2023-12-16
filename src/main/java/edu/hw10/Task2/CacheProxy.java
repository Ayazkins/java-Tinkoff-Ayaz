package edu.hw10.Task2;

import edu.hw10.Task2.Annotations.Cache;
import edu.hw6.Task1.DiskMap;
import java.io.IOException;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public final class CacheProxy implements InvocationHandler {

    private final Object target;
    private final Map<String, Object> cache;

    private final Map<String, String> cacheToFile;

    private CacheProxy(String path, Object target) throws IOException {
        this.target = target;
        cache = new HashMap<>();
        cacheToFile = new DiskMap(path);
    }

    public static <T> T create(T target, Class<?> interfaceClass, String path) throws IOException {
        return (T) Proxy.newProxyInstance(
            interfaceClass.getClassLoader(),
            new Class<?>[] {interfaceClass},
            new CacheProxy(path, target)
        );
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        Cache cacheAnnotation = method.getAnnotation(Cache.class);
        boolean persist = cacheAnnotation != null && cacheAnnotation.persist();
        String key = method.getName() + " " + Arrays.toString(args);
        if (cacheToFile.containsKey(key) || cache.containsKey(key)) {
            if (persist) {
                return cacheToFile.get(key);
            }
            return cache.get(key);
        }
        var result = method.invoke(target, args);
        if (persist) {
            cacheToFile.put(key, result.toString());
            return result;
        }
        cache.put(key, result);
        return result;
    }
}
