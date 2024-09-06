package com.Futureintern_JD_5.Service;

import org.springframework.stereotype.Service;

import java.security.SecureRandom;
import java.util.List;

public  interface PasswordGeneratorService {
     List<String> generatePasswords(int length, int quantity,
                                            boolean includeNumbers, boolean includeLowercase,
                                            boolean includeUppercase, boolean includeSymbols,
                                            boolean noSimilarChars, boolean noDuplicateChars,
                                            boolean noSequentialChars);

     String generatePassword(int length, boolean includeNumbers,
                                     boolean includeLowercase, boolean includeUppercase,
                                     boolean includeSymbols, boolean noSimilarChars,
                                     boolean noDuplicateChars, boolean noSequentialChars);
}

