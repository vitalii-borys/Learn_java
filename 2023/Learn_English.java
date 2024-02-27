import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.Scanner;

public class Learn_English {
    public static void main(String[] args) {
        Map<String, String> database = new HashMap<>(); // Store English words and their translations

        // Read words and translations from a text file and populate the database
        try (BufferedReader reader = new BufferedReader(new FileReader("word_database.txt"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split("\t");
                if (parts.length == 2) {
                    database.put(parts[0], parts[1]);
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

        for (String englishWord : keys) {
            String translation = database.get(englishWord);
            int indexToGuess = random.nextInt(englishWord.length());

            StringBuilder wordWithMissingLetter = new StringBuilder(englishWord);
            wordWithMissingLetter.setCharAt(indexToGuess, '_');

            System.out.println("Guess a character from the English word: " + wordWithMissingLetter + " (" + translation + ")");

            while (true) {
                System.out.print("Enter the missing letter or character (type 'exit' to quit): ");
                String userGuess = scanner.nextLine();

                if (userGuess.equalsIgnoreCase("exit")) {
                    System.out.println("Exiting the game.");
                    scanner.close();
                    return; // Exit the program
                }

                if (userGuess.length() == 1) {
                    char guessedCharacter = userGuess.charAt(0);

                    if (guessedCharacter == englishWord.charAt(indexToGuess)) {
                        System.out.println("Yes, it is: " + englishWord);
                        break;
                    } else {
                        System.out.println("Sorry, that's not correct. Try again.");
                    }
                } else {
                    System.out.println("Please enter a single letter or character.");
                }
            }
        }

        scanner.close();
    }
}
