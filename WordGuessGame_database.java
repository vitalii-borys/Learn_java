import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.util.*;
import java.util.regex.Pattern;

public class WordGuessGame_database {
    public static void main(String[] args) throws UnsupportedEncodingException {
        // Set the console encoding to UTF-8 for proper character display
        System.setOut(new java.io.PrintStream(System.out, true, "UTF-8"));

        Map<String, String> database = new HashMap<>();
        List<String> cyrillicWords = new ArrayList<>();

        // Read words and translations from a text file with UTF-8 encoding
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream("word_database.txt"), "UTF-8"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split("\t");
                if (parts.length == 2) {
                    String englishWord = parts[0];
                    String translation = parts[1];

                    // Check if the English word contains only English characters
                    if (isEnglishWord(englishWord)) {
                        database.put(englishWord, translation);
                    } else {
                        // Store Cyrillic words separately
                        cyrillicWords.add(englishWord + " (" + translation + ")");
                    }
                }
            }
        } catch (IOException e) {
            System.err.println("Error reading the word database file: " + e.getMessage());
            return;
        }

        Random random = new Random();
        Scanner scanner = new Scanner(System.in);

        ArrayList<String> keys = new ArrayList<>(database.keySet());
        // Shuffle the keys to display words in random order
        Collections.shuffle(keys);

        // Ask the user how many random characters should be missing
        System.out.print("Enter the number of random characters to be missing (1, 2, or 3): ");
        int missingCharacterCount = scanner.nextInt();

        for (String englishWord : keys) {
            String translation = database.get(englishWord);

            // Create an array to store the indices of missing characters
            int[] missingCharacterIndices = new int[missingCharacterCount];
            for (int i = 0; i < missingCharacterCount; i++) {
                missingCharacterIndices[i] = random.nextInt(englishWord.length());
            }

            // Sort the indices in ascending order
            Arrays.sort(missingCharacterIndices);

            // Generate the word with missing characters
            StringBuilder wordWithMissingCharacters = new StringBuilder(englishWord);
            for (int i = missingCharacterCount - 1; i >= 0; i--) {
                wordWithMissingCharacters.setCharAt(missingCharacterIndices[i], '_');
            }

            System.out.println("Guess " + missingCharacterCount + " character(s) from the English word: " +
                    wordWithMissingCharacters + " (" + translation + ")");

            while (true) {
                System.out.print("Enter the missing letter(s) or character(s) (type 'skip' to skip, 'exit' to quit): ");
                String userGuess = scanner.next();

                if (userGuess.equalsIgnoreCase("exit")) {
                    System.out.println("Exiting the game.");
                    scanner.close();
                    return; // Exit the program
                } else if (userGuess.equalsIgnoreCase("skip")) {
                    System.out.println("Skipping to the next word.");
                    break; // Skip to the next word
                }

                if (userGuess.length() == missingCharacterCount) {
                    boolean isCorrect = true;
                    for (int i = 0; i < missingCharacterCount; i++) {
                        char guessedCharacter = userGuess.charAt(i);
                        int indexToGuess = missingCharacterIndices[i];
                        char actualCharacter = englishWord.charAt(indexToGuess);

                        if (guessedCharacter != actualCharacter) {
                            isCorrect = false;
                            break;
                        }
                    }

                    if (isCorrect) {
                        System.out.println("Yes, it is: " + englishWord);
                        break;
                    } else {
                        System.out.println("Sorry, that's not correct. Try again.");
                    }
                } else {
                    System.out.println("Please enter " + missingCharacterCount + " character(s).");
                }
            }
        }

        // Print Cyrillic words alongside English words
        System.out.println("Cyrillic words (translations):");
        for (String cyrillicWord : cyrillicWords) {
            System.out.println(cyrillicWord);
        }

        scanner.close();
    }

    // Helper method to check if a word contains only English characters
    private static boolean isEnglishWord(String word) {
        return Pattern.matches("^[a-zA-Z]+$", word);
    }
}