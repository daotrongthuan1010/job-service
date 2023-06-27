package com.job.future.jobservice.utils;

import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import java.security.SecureRandom;

public class SecretKeyGenerator {
    public static SecretKey generateSecretKey() {
        try {
            KeyGenerator keyGenerator = KeyGenerator.getInstance("HmacSHA256");
            SecureRandom secureRandom = new SecureRandom();
            keyGenerator.init(secureRandom);
            return keyGenerator.generateKey();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
