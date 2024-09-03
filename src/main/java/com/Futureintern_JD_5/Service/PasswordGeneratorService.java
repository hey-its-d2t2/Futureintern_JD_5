package com.Futureintern_JD_5.Service;

import org.springframework.stereotype.Service;

import java.security.SecureRandom;

@Service
public class PasswordGeneratorService {

    private static final String UPPERCASE = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    private static final String LOWERCASE = "abcdefghijklmnopqrstuvwxyz";
    private static final String DIGITS = "0123456789";
    private static final String SPECIAL_CHARACTERS = "!@#$%^&*()-_+=<>?";

    public String generatePassword(int length, boolean useUpper, boolean useLower, boolean useDigits, boolean useSpecial) {
        StringBuilder characterPool = new StringBuilder();
        SecureRandom random = new SecureRandom();

        if (useUpper) characterPool.append(UPPERCASE);
        if (useLower) characterPool.append(LOWERCASE);
        if (useDigits) characterPool.append(DIGITS);
        if (useSpecial) characterPool.append(SPECIAL_CHARACTERS);

        if (characterPool.length() == 0) throw new IllegalArgumentException("No character types selected");

        StringBuilder password = new StringBuilder(length);
        for (int i = 0; i < length; i++) {
            int index = random.nextInt(characterPool.length());
            password.append(characterPool.charAt(index));
        }
        return password.toString();
    }
}
