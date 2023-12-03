package edu.hw8;

import edu.hw8.Task3.MultiThreadPasswordCracker;
import edu.hw8.Task3.PasswordCracker;
import org.junit.jupiter.api.Test;
import java.security.NoSuchAlgorithmException;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ExecutionException;

public class Task3Test {
    @Test
    public void passwordCrackerTest() throws NoSuchAlgorithmException, InterruptedException, ExecutionException {
        int passwordLength = 4;
        PasswordCracker passwordCracker = new PasswordCracker(passwordLength);
        MultiThreadPasswordCracker multiThreadPasswordCracker = new MultiThreadPasswordCracker(passwordLength, 6);
        Map<String, String> passwords = new HashMap<>();
        passwords.put("ayaz", "02c425157ecd32f259548b33402ff6d3");
        passwords.put("ayaz2", "e2fc714c4727ee9395f324cd2e7f331f");
        passwords.put("ayaz3", "962012d09b8170d912f0669f6d7d9d07");

        long startTime = System.currentTimeMillis();
        Map<String, String> crackedPassword = passwordCracker.crack(passwords);
        long endTime = System.currentTimeMillis();
        long elapsedTime = endTime - startTime;

        System.out.println("PasswordCracker.crack() elapsed time: " + elapsedTime + " milli");
        System.out.println("Cracked password: " + crackedPassword);

        startTime = System.currentTimeMillis();
        crackedPassword = multiThreadPasswordCracker.crack(passwords);
        endTime = System.currentTimeMillis();
        elapsedTime = endTime - startTime;

        System.out.println("MultiThreadPasswordCracker.crack() elapsed time: " + elapsedTime + " milli");
        System.out.println("Cracked password: " + crackedPassword);
    }
}
