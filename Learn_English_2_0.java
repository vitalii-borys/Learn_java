import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Scanner;
import java.util.Set;

public class Learn_English_2_0 {
    public static void catch_exception(File fileName) throws IOException {
        try {
            BufferedReader br = new BufferedReader(new FileReader(fileName));
            br.close();
        } catch (FileNotFoundException ex) {
            System.out.println("Error. File " + fileName + " does not exist.");
            System.out.println("Exiting program...");
            System.exit(0);
        }
    }
    public static void write_Set_to_File(Set<String> input_Set, File file_name) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(file_name))) {
            for (String line : input_Set) {
                bw.write(line);
                bw.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
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
    public static int[] get_correct_random_ints(String hashmapString, Set<String> second_level_list, Set<String> third_Level_Set) {
        int count_random_ints = 1;
        if(second_level_list.contains(hashmapString)) {
            count_random_ints = 3;
        }
        if(third_Level_Set.contains(hashmapString)) {
            count_random_ints = hashmapString.length();
            char[] hashMapString_char_array = hashmapString.toCharArray();
            for (char c : hashMapString_char_array) {
                if(c == ' ' || c == '-') {
                    count_random_ints--;
                }
            }
        }
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
    public static String cut_tabulation(String a) {
        String first = a.replaceAll("[\\t\\s]+", " ");
        String out = first.replaceAll("^[\\s\\t]+|[\\s\\t]+$","");
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
    public static Set<String> create_Set(File en2) throws IOException {
        Set<String> mySet = new HashSet<String>();
        BufferedReader myBufferedEnglishReader = new BufferedReader(new FileReader(en2));
        String myEnglishString;
        while ((myEnglishString = myBufferedEnglishReader.readLine()) != null) {
            mySet.add(cut_tabulation(myEnglishString));
        }
        myBufferedEnglishReader.close();
        return mySet;
    }
    public static void main(String[] args) throws Exception {
        File myEnglishFile = new File("C:\\Users\\photo\\Documents\\GitHub\\Learn_java\\English_words.txt");
        File myEnglishFileLevelTwo = new File("C:\\Users\\photo\\Documents\\GitHub\\Learn_java\\English_words_level_2.txt");
        File myEnglishFileLevelThree = new File("C:\\Users\\photo\\Documents\\GitHub\\Learn_java\\English_words_level_3.txt");
        File myCyrillicFile = new File("C:\\Users\\photo\\Documents\\GitHub\\Learn_java\\Cyrillic_words.txt");
        catch_exception(myEnglishFile);
        catch_exception(myCyrillicFile);
        myEnglishFileLevelTwo.createNewFile();
        myEnglishFileLevelThree.createNewFile();
        Map<String, String> myHashMap = create_Map(myEnglishFile, myCyrillicFile);
        List<String> list_From_Map = new ArrayList<>(myHashMap.keySet());
        Collections.shuffle(list_From_Map);
        Set<String> second_level_Set = create_Set(myEnglishFileLevelTwo);
        Set<String> second_level_Set_to_write = create_Set(myEnglishFileLevelTwo);
        Set<String> third_level_Set = create_Set(myEnglishFileLevelThree);
        Set<String> third_level_Set_to_write = create_Set(myEnglishFileLevelThree);
        Scanner scan = new Scanner(System.in);
        for (String toFind : list_From_Map) {
            int how_many_chars_to_guess = 1;
            int[] ints_to_guess;
            if(second_level_Set.contains(toFind) == false) {
                ints_to_guess = get_correct_random_ints(toFind, second_level_Set, third_level_Set);
                how_many_chars_to_guess = 1;
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
                    second_level_Set_to_write.add(toFind);
                }
            }
            if(second_level_Set.contains(toFind) && third_level_Set.contains(toFind) == false) {
                ints_to_guess = get_correct_random_ints(toFind, second_level_Set, third_level_Set);
                how_many_chars_to_guess = 3;
                String hidden = randInt_to_hiddenString(toFind, ints_to_guess);
                System.out.println(hidden + " " + myHashMap.get(toFind).toLowerCase());
                char[] answer = get_chars_input(scan, how_many_chars_to_guess);
                char[] hidden_chars = chars_from_ints(ints_to_guess, toFind);
                if (answer_matches(answer, hidden_chars) == false) {
                    System.out.println("Wrong. It is \"" + toFind + "\".");
                    second_level_Set_to_write.remove(toFind);
                }
                if (answer_matches(answer, hidden_chars)) {
                    System.out.println("Correct. It is \"" + toFind + "\".");
                    third_level_Set_to_write.add(toFind);
                }
            }
            if(third_level_Set.contains(toFind)) {
                int intstoguess[] = new int[toFind.length()];
                for(int i = 0; i < toFind.length(); i++) {
                    intstoguess[i] = i;
                }
                ints_to_guess = intstoguess;
                how_many_chars_to_guess = toFind.length();
                String hidden = randInt_to_hiddenString(toFind, ints_to_guess);
                System.out.println(hidden + " " + myHashMap.get(toFind).toLowerCase());
                char[] answer = get_chars_input(scan, how_many_chars_to_guess);
                char[] hidden_chars = chars_from_ints(ints_to_guess, toFind);
                if (answer_matches(answer, hidden_chars) == false) {
                    System.out.println("Wrong. It is \"" + toFind + "\".");
                    third_level_Set_to_write.remove(toFind);
                }
                if (answer_matches(answer, hidden_chars)) {
                    System.out.println("Correct. It is \"" + toFind + "\".");
                }
            }
            write_Set_to_File(second_level_Set_to_write, myEnglishFileLevelTwo);
            write_Set_to_File(third_level_Set_to_write, myEnglishFileLevelThree);
        }
        scan.close();
    }
}
