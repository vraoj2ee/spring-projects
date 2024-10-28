package spring.security.jwt.security;

import java.security.SecureRandom;
import java.util.Base64;

public class SecretKeyGenerator {

    public static String generateSecretKey(int length) {
        SecureRandom random = new SecureRandom();
        byte[] key = new byte[length];
        random.nextBytes(key);
        return Base64.getEncoder().encodeToString(key);
    }

    public static void main(String[] args) {
        String secretKey = generateSecretKey(32); // Generate a 256-bit key (32 bytes)
        System.out.println("Generated SECRET_KEY: " + secretKey);
    }
}
