import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Map;
import java.util.Random;
import java.util.Scanner;
import java.util.Set;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

public class EnglishGuessGame {
    public static int one_two_or_three(Scanner external_Scanner) {
        String input = external_Scanner.nextLine();
        while (input.isEmpty()) {
            System.out.println("Write 1, 2 or 3, please:");
            input = external_Scanner.nextLine();
        }
        while (input.length() !=1) {
            System.out.println("Only one digit - 1, 2 or 3, please:");
            input = external_Scanner.nextLine();
            while (!Character.isDigit(input.charAt(0))) {
                System.out.println("Only 1, 2 or 3, please:");
                input = external_Scanner.nextLine();
            }
        }
        while (Integer.parseInt(input) != 1 && Integer.parseInt(input) != 2 && Integer.parseInt(input) != 3) {
            System.out.println("Only 1, 2 or 3, please:");
            input = external_Scanner.nextLine();
        }
        int out = Integer.valueOf(input);
        return out;
    }
    public static boolean answer_matches(char[] hiddenChars, char[] user_chars) {
        boolean matches;
        if (Arrays.equals(hiddenChars, user_chars)) {
            matches = true;
        } else {
            matches = false;
        }
        return matches;
    }
    public static char[] chars_from_ints(int[] input_ints, String input_String) {
        char[] out_chars = new char[ input_ints.length];
        int a = 0;
        for (int i : input_ints) {
            out_chars[a] = input_String.charAt(i);
            a++;
        }
        return out_chars;
    }
    public static char[] get_chars_input(Scanner expternal_Scanner, int chars_count) {
        char[] out = new char[chars_count];
        System.out.println("Guess hidden:");
        String input = expternal_Scanner.nextLine();
        for (int i = 0; i < chars_count; i++) {
            boolean input_fits = false;
            while (input_fits == false) {
                if (input.length() != chars_count) {
                    System.out.println("Letters count should be " + chars_count);
                    input = expternal_Scanner.nextLine();
                } else {
                    input_fits = true;
                }
            }
            out[i] = input.charAt(i);
        }
        return out;
    }
    public static boolean char_contains(Set<Integer> my_Set, int input_int) {
        boolean conta = false;
        for (int a = 0; a < my_Set.size(); a++) {
            if(my_Set.contains(input_int)) {
                conta = true;
            }
        }
    return conta;
    }
    public static String get_random_String_from_map(Map<String, String> hm) {
        Map<Integer, String> newOneMap = new HashMap<Integer, String>();
        int count = 0;
        for (String d : hm.keySet()) {
            newOneMap.put(count, d);
            count++;
        }
        System.out.println(newOneMap);
        Random myNewRandom = new Random();
        int newRandInt = myNewRandom.nextInt(count);
        System.out.println(newRandInt + " is RandInt for String");
        String my_random_String = newOneMap.get(newRandInt);
        return my_random_String;
    }
    public static String cut_tabulation(String a) {
        String first = a.replaceAll("[\\t\\s]+", " ");
        String out = first.replaceAll("^[\\s\\t]+|[\\s\\t]+$","");
        return out;
    }
    public static int[] get_correct_random_ints(String hashmapString, int count_random_ints) {
        int[] out = new int[count_random_ints];
        Random rand = new Random();
        int myrand = rand.nextInt(hashmapString.length());
        Set<Integer> intset = new HashSet<Integer>();
        while (intset.size() < count_random_ints) {
            if (hashmapString.charAt(myrand) == ' ' || hashmapString.charAt(myrand) == '-') {
                myrand = rand.nextInt(hashmapString.length());
            } else if (hashmapString.charAt(myrand) != ' ') {
                intset.add(myrand);
                myrand = rand.nextInt(hashmapString.length());
            }
            int i = 0;
            for (int c : intset) {
                out[i] = c;
                i++;
            }
        }
        return out;
    }
    public static String randInt_to_hiddenString(String hashMapString, int[] randInts) {
        char[] charsToWorkWith = hashMapString.toCharArray();
        char[] outPut = new char[hashMapString.length()];
        for (int a = 0; a < charsToWorkWith.length; a++) {
            for (int b = 0; b < randInts.length; b++) {
                if (a == randInts[b]) {
                    outPut[a] = '*';
                    break;
                } else {
                    outPut[a] = charsToWorkWith[a];
                }
            }
        }
        String out = String.valueOf(outPut);
        return out;
    }
    public static Map<String, String> create_Map(File en, File cr) throws IOException {
        BufferedReader myBufferedEnglishReader = new BufferedReader(new FileReader(en));
        BufferedReader myBufferedCyrillicReader = new BufferedReader(new FileReader(cr));
        String myEnglishString;
        String myCyrillicString;
        Map<String, String> myMap = new HashMap<String, String>();
        while ((myEnglishString = myBufferedEnglishReader.readLine()) != null && (myCyrillicString = myBufferedCyrillicReader.readLine()) != null) {
            myMap.put(cut_tabulation(myEnglishString), cut_tabulation(myCyrillicString));
        }
        myBufferedEnglishReader.close();
        myBufferedCyrillicReader.close();
        return myMap;
    }
    public static void main(String[] args) throws Exception {
        File myEnglishFile = new File("C:\\Users\\photo\\Documents\\GitHub\\Learn_java\\English_words.txt");
        File myCyrillicFile = new File("C:\\Users\\photo\\Documents\\GitHub\\Learn_java\\Cyrillic_words.txt");
        Map<String, String> myHashMap = create_Map(myEnglishFile, myCyrillicFile);
        List<String> list_From_Map = new ArrayList<>(myHashMap.keySet());
        Collections.shuffle(list_From_Map);
        Scanner scan = new Scanner(System.in);
        System.out.println("How many chars in word should be missing? (1, 2 or 3)");
        int how_many_chars_to_guess = one_two_or_three(scan);
        for (String toFind : list_From_Map) {
            int[] ints_to_guess = get_correct_random_ints(toFind, how_many_chars_to_guess);
            String hidden = randInt_to_hiddenString(toFind, ints_to_guess);
            System.out.println(hidden + " " + myHashMap.get(toFind).toLowerCase());
            char[] answer = get_chars_input(scan, how_many_chars_to_guess);
            char[] hidden_chars = chars_from_ints(ints_to_guess, toFind);
            while (answer_matches(answer, hidden_chars) == false) {
                System.out.println("Try again:");
                System.out.println(hidden + " " + myHashMap.get(toFind).toLowerCase());
                answer = get_chars_input(scan, how_many_chars_to_guess);
            }
            if (answer_matches(answer, hidden_chars)) {
                System.out.println("Correct. It is \"" + toFind + "\".");
            }
        }
        scan.close();
    }
}
