package edu.hw8.Task3;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.HashMap;
import java.util.Map;

public class PasswordCracker {
    private final static String ALPHABET = "0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
    private final int passwordLength;

    public PasswordCracker(int passwordLength) {
        this.passwordLength = passwordLength;
    }

    public Map<String, String> crack(Map<String, String> passwords) throws NoSuchAlgorithmException {
        Map<String, String> out = new HashMap<>();
        for (Map.Entry<String, String> a : passwords.entrySet()) {
            int start = 0;
            String password = generatePassword(start);
            while (!checkPassword(password, a.getValue())) {
                ++start;
                password = generatePassword(start);
            }
            out.put(a.getKey(), password);
        }
        return out;
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

    private boolean checkPassword(String password, String hash) throws NoSuchAlgorithmException {
        MessageDigest md = MessageDigest.getInstance("MD5");
        byte[] digest = md.digest(password.getBytes());
        StringBuilder sb = new StringBuilder();
        for (byte b : digest) {
            sb.append(String.format("%02x", b));
        }
        return sb.toString().equals(hash);
    }
}
