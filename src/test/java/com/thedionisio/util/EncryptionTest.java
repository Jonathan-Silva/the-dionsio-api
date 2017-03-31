package com.thedionisio.util;

import com.thedionisio.security.Encryption;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by jonathan on 3/19/17.
 */
public class EncryptionTest {
    private Encryption encryption = new Encryption();

    @Test
    public void encryptionTest(){

        assertEquals("7c4a8d09ca3762af61e59520943dc26494f8941b",
                      encryption.generateHash("123456"));

    }

    @Test
    public void isValid()
    {
        assertEquals(true,
                Encryption.isPasswordValid(encryption.generateHash("123456"),
                                                                   "123456"));
    }


}
