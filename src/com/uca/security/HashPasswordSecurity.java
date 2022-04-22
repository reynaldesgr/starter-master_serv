package com.uca.security;

import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;
import java.nio.charset.StandardCharsets;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.Base64;


public class HashPasswordSecurity {
    private static final int salt = 32; // Salt
    private static final int iterations = 6635; // Iterations
    private static final int keyLength  = 256;  // Desired length fo key

    /** Get hash **/
    public static String getHash(String password) {
        try {
            byte[] saltPassword = SecureRandom.getInstance("SHA1PRNG").generateSeed(salt);
            return Base64.getEncoder().encodeToString(saltPassword) + "$" + hash(password, saltPassword);
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    /** Check if a password given in the login form matches a stored password **/
    public static boolean check(String password, String passwordStored) throws Exception{
        String[] salt = passwordStored.split("\\$");
        if(salt.length < 2){
            throw new IllegalStateException("Password have form 'salt$hash'");
        }
        String hashValue = hash(password, Base64.getDecoder().decode(salt[0]));
        return hashValue.equals(salt[1]);
    }

    /** Private hash function **/
    private static String hash(String password, byte[] salt) throws Exception{
        if(password == null || password.length() == 0){
            throw new IllegalArgumentException("Empty password.");
        }
        SecretKeyFactory factory = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA1");
        SecretKey key = factory.generateSecret(new PBEKeySpec(
                password.toCharArray(), salt, iterations, keyLength)
        );
        return Base64.getEncoder().encodeToString(key.getEncoded());
    }
}
