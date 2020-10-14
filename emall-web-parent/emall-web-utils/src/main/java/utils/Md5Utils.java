package utils;

import java.math.BigInteger;
import java.security.MessageDigest;

/**
 * @author tty
 * @create 2020-09-04-8:34
 */
public class Md5Utils {

    public static String md5(String source) {

        String algorithm = "md5";
        String md5Source = null;
        int signNum = 1;
        byte[] digest = null;

        if (source != null && source.length() > 0) {
            try {
                MessageDigest instance = MessageDigest.getInstance(algorithm);
                digest = instance.digest(source.getBytes("utf-8"));
                md5Source = new BigInteger(signNum, digest).toString(16);
            } catch (Exception e) {
                e.printStackTrace();
            }
            return md5Source;
        }

        return null;

    }

}
