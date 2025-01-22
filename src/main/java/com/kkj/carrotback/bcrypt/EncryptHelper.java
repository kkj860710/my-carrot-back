package com.kkj.carrotback.bcrypt;

public interface EncryptHelper {

    String encrypt(String plainText);
    boolean isMatch(String plainText, String encryptedText);
}
