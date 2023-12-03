package edu.hw8.Task3;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class MultiThreadPasswordCracker {
    private final static String ALPHABET = "0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
    private final int passwordLength;
    private final int numOfThreads;

    public MultiThreadPasswordCracker(int passwordLength, int numOfThreads) {
        this.passwordLength = passwordLength;
        this.numOfThreads = numOfThreads;
    }

    public Map<String, String> crack(Map<String, String> passwords) throws InterruptedException, ExecutionException {
        Map<String, String> out = new HashMap<>();
        for (Map.Entry<String, String> entry : passwords.entrySet()) {
            String hash = entry.getValue();
            out.put(entry.getKey(), crackPassword(hash));
        }
        return out;
    }

    private String crackPassword(String hash) throws InterruptedException, ExecutionException {
        ExecutorService executorService = Executors.newFixedThreadPool(numOfThreads);
        List<PasswordCrackerThread> passwordCrackers = new ArrayList<>();
        int passwordsCount = (int) Math.pow(ALPHABET.length(), passwordLength);
        int passwordsPerThread = passwordsCount / numOfThreads;
        for (int i = 0; i < numOfThreads; ++i) {
            int start = i * passwordsPerThread;
            int end = (i == numOfThreads - 1) ? passwordsCount - 1 : (i + 1) * passwordsPerThread - 1;
            passwordCrackers.add(new PasswordCrackerThread(hash, start, end, passwordLength));
        }
        String result = executorService.invokeAny(passwordCrackers);
        executorService.shutdownNow();
        return result;
    }
}
