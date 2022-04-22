package com.uca.security;

import java.nio.charset.StandardCharsets;
import java.util.Base64;

public class HashPasswordSecurity {
    /** Encrypt a password **/
    public static String getHash(String password) {
        Base64.Encoder encode = Base64.getEncoder();
        String hashValue = encode.encodeToString(password.getBytes(StandardCharsets.UTF_8));
        return hashValue;
    }

    /** Decrypt a password **/
    public static String decryptHash(String hashPassword) {
        Base64.Decoder decode = Base64.getDecoder();
        byte[] bytes = decode.decode(hashPassword);
        return new String(bytes);
    }
       /* SecureRandom random = new SecureRandom();
        byte[] salt = new byte[16];
        random.nextBytes(salt);
        KeySpec spec = new PBEKeySpec(password.toCharArray(), salt, 65536, 128);
        try {
            SecretKeyFactory factory = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA1");
            byte[] hash = factory.generateSecret(spec).getEncoded();
            hashValue = Base64.getEncoder().encodeToString(hash);
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        } catch (InvalidKeySpecException e) {
            e.printStackTrace();
        } */
}
