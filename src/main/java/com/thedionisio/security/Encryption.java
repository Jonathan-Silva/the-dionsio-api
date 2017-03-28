package com.thedionisio.security;

import org.springframework.security.authentication.encoding.MessageDigestPasswordEncoder;

/**
 * Created by jonathan on 3/19/17.
 */
public class Encryption {

    private static Object salt;

    private static MessageDigestPasswordEncoder getInstanceMessageDisterPassword() {

        MessageDigestPasswordEncoder   digestPasswordEncoder = new MessageDigestPasswordEncoder("SHA-1");

        return digestPasswordEncoder;

    }


    public String generateHash(String password) {

        MessageDigestPasswordEncoder digestPasswordEncoder = getInstanceMessageDisterPassword();

        String encodePassword = digestPasswordEncoder.encodePassword(password, salt);

        return encodePassword;

    }


    public static boolean isPasswordValid(String hashPassword, String password) {

        MessageDigestPasswordEncoder digestPasswordEncoder = getInstanceMessageDisterPassword();

        return digestPasswordEncoder.isPasswordValid(hashPassword, password, salt);

    }

}
