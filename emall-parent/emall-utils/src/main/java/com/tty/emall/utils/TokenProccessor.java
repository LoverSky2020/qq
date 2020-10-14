package com.tty.emall.utils;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;
import java.util.Random;

/**
 * @author tty
 * @create 2020-09-02-13:47
 */
public class TokenProccessor {

    private TokenProccessor(){}

    private static final TokenProccessor instance = new TokenProccessor();

    public static TokenProccessor getInstance() {
        return instance;
    }

    public String makeToken() {
        String token = (System.currentTimeMillis() + new Random().nextInt(9999999) + "");
        try {
            MessageDigest md5 = MessageDigest.getInstance("md5");
            byte[] digest = md5.digest(token.getBytes());
            String s = new BigInteger(1, digest).toString(16);
            return s;
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return null;
    }

}
