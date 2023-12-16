package com.martijn.CompCheck.user;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class PasswordHashing {
    public static String createHash (String password) {
        try {
            MessageDigest messageDigest = MessageDigest.getInstance("SHA");

            messageDigest.update(password.getBytes());
            byte[] resultByteArray = messageDigest.digest();

            StringBuilder builder = new StringBuilder();

            for (byte b : resultByteArray) {
                builder.append(String.format("%02x", b));
            }

            return builder.toString();

        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }

        return "";

    }
}
