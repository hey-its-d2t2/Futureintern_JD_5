package com.Futureintern_JD_5.ServiceImpl;

import com.Futureintern_JD_5.Service.PasswordGeneratorService;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class PasswordGeneratorServiceImpl implements PasswordGeneratorService {

    private static final String LOWERCASE = "abcdefghijkmnopqrstuvwxyz"; // Removed similar characters like 'l'
    private static final String UPPERCASE = "ABCDEFGHJKLMNPQRSTUVWXYZ";   // Removed 'O'
    private static final String NUMBERS = "23456789";                     // Removed '0' and '1'
    private static final String SYMBOLS = "!\"#$%&'()*+,-./:;<=>?@[\\]^_`{|}~";

    @Override
    public List<String> generatePasswords(int length, int quantity,
                                          boolean includeNumbers, boolean includeLowercase,
                                          boolean includeUppercase, boolean includeSymbols,
                                          boolean noSimilarChars, boolean noDuplicateChars,
                                          boolean noSequentialChars) {
        List<String> passwords = new ArrayList<>();
        for (int i = 0; i < quantity; i++) {
            passwords.add(generatePassword(length, includeNumbers, includeLowercase, includeUppercase,
                    includeSymbols, noSimilarChars, noDuplicateChars, noSequentialChars));
        }
        return passwords;
    }

    @Override
    public String generatePassword(int length, boolean includeNumbers,
                                   boolean includeLowercase, boolean includeUppercase,
                                   boolean includeSymbols, boolean noSimilarChars,
                                   boolean noDuplicateChars, boolean noSequentialChars) {
        // Build the character pool based on user selections
        StringBuilder charPool = new StringBuilder();
        if (includeLowercase) charPool.append(LOWERCASE);
        if (includeUppercase) charPool.append(UPPERCASE);
        if (includeNumbers) charPool.append(NUMBERS);
        if (includeSymbols) charPool.append(SYMBOLS);

        // Handle case where no options are selected
        if (charPool.length() == 0) {
            throw new IllegalArgumentException("At least one character type should be selected");
        }

        Random random = new Random();
        StringBuilder password = new StringBuilder();
        Set<Character> usedChars = new HashSet<>();

        for (int i = 0; i < length; i++) {
            char nextChar;

            do {
                nextChar = charPool.charAt(random.nextInt(charPool.length()));

                // Check for duplicate characters if not allowed
                if (noDuplicateChars && usedChars.contains(nextChar)) {
                    continue;
                }

                // Ensure no sequential characters if not allowed
                if (noSequentialChars && i > 0 && Math.abs(password.charAt(i - 1) - nextChar) == 1) {
                    continue;
                }

                break;

            } while (true);

            password.append(nextChar);
            usedChars.add(nextChar);
        }

        return password.toString();
    }
}
