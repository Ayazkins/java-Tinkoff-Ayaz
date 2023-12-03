package edu.hw8.Task3;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.concurrent.Callable;

public class PasswordCrackerThread implements Callable<String> {
    private final static String ALPHABET = "0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";

    private final int passwordLength;
    private final String hash;
    private final int start;
    private final int end;

    public PasswordCrackerThread(String hash, int start, int end, int passwordLength) {
        this.hash = hash;
        this.start = start;
        this.end = end;
        this.passwordLength = passwordLength;
    }

    private String generatePassword(int number) {
        int cloneNumber = number;
        StringBuilder password = new StringBuilder();
        while (cloneNumber > 0) {
            password.insert(0, ALPHABET.charAt(cloneNumber % ALPHABET.length()));
            cloneNumber /= ALPHABET.length();
        }
        while (password.length() < passwordLength) {
            password.insert(0, ALPHABET.charAt(0));
        }
        return password.toString();
    }

    private boolean checkPasswords(String password) throws NoSuchAlgorithmException {
        MessageDigest md = MessageDigest.getInstance("MD5");
        byte[] digest = md.digest(password.getBytes());
        StringBuilder sb = new StringBuilder();
        for (byte b : digest) {
            sb.append(String.format("%02x", b));
        }
        return sb.toString().equals(hash);
    }

    @Override
    public String call() throws Exception {
        for (int i = start; i <= end; ++i) {
            String password = generatePassword(i);
            try {
                if (checkPasswords(password)) {
                    return password;
                }
            } catch (NoSuchAlgorithmException e) {
                throw new RuntimeException(e);
            }
        }
        throw new Exception("Wrong password format");
    }
}
