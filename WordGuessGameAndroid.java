import java.io.UnsupportedEncodingException;
import java.util.*;
import java.util.regex.Pattern;

public class WordGuessGameAndroid {
    public static void main(String[] args) throws UnsupportedEncodingException {
        // Set the console encoding to UTF-8 for proper character display
        System.setOut(new java.io.PrintStream(System.out, true, "UTF-8"));

        Map<String, String> database = new HashMap<>();
        List<String> cyrillicWords = new ArrayList<>();

        // Input data in the specified format
        String inputData = "hear	чути\n" +
                "hair	волосся\n" +
                "clothes	одяг\n" +
                "hear	чути\n" +
                "hair	волосся\n" +
                "clothes	одяг\n" +
                "soon	скоро\n" +
                "think	думати\n" +
                "bottom	дно\n" +
                "heaven	небеса\n" +
                "know	знати\n" +
                "through	крізь\n" +
                "steal	красти\n" +
                "under	під\n" +
                "wish	побажання\n" +
                "must	повинен\n" +
                "hope	надія\n" +
                "wrong	неправильно\n" +
                "plenty	багато\n" +
                "seem	здається\n" +
                "return	повернутися\n" +
                "wife	дружина\n" +
                "then	потім\n" +
                "hurt	завдати болю\n" +
                "sense	відчувати\n" +
                "convince	переконувати\n" +
                "curiosity	допитливість\n" +
                "patient	терплячий\n" +
                "kingdom	королівство\n" +
                "full	повний\n" +
                "empty	порожній\n" +
                "huge	величезний\n" +
                "dry	сухий";

        String[] lines = inputData.split("\n");
        for (String line : lines) {
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
                System.out.print("Enter the missing letter or character (type 'skip' to skip, 'exit' to quit): ");
                String userGuess = scanner.nextLine();

                if (userGuess.equalsIgnoreCase("exit")) {
                    System.out.println("Exiting the game.");
                    scanner.close();
                    return; // Exit the program
                } else if (userGuess.equalsIgnoreCase("skip")) {
                    System.out.println("Skipping to the next word.");
                    break; // Skip to the next word
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
