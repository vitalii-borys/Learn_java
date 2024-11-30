import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Scanner;
import java.util.Set;

public class Learn_English_2_1 {
    public static boolean answer_matches(char[] user_chars, char[] hiddenChars) {
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
    public static char[] get_chars_input(Scanner external_Scanner, int chars_count) {
        char[] out = new char[chars_count];
        System.out.println("Guess hidden:");
        String input = external_Scanner.nextLine();
        if (input.equals("exit")) {
            System.exit(0);
        }
        for (int i = 0; i < chars_count; i++) {
            boolean input_fits = false;
            while (input_fits == false) {
                if (input.length() != chars_count) {
                    System.out.println("Letters count should be " + chars_count);
                    input = external_Scanner.nextLine();
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
    public static int[] get_correct_random_ints(Map.Entry<String, String> mapEntry, List<SerializableEntry<String, String>> second_level_list, List<SerializableEntry<String, String>> third_Level_Set) {
        String myString = mapEntry.getKey();
        int count_random_ints = 1;
        if(second_level_list.contains(mapEntry)) {
            count_random_ints = 3;
        }
        if(third_Level_Set.contains(mapEntry)) {
            count_random_ints = myString.length();
            char[] hashMapString_char_array = myString.toCharArray();
            for (char c : hashMapString_char_array) {
                if(c == ' ' || c == '-') {
                    count_random_ints--;
                }
            }
        }
        int[] out = new int[count_random_ints];
        Random rand = new Random();
        int myrand = rand.nextInt(myString.length());
        Set<Integer> intset = new HashSet<Integer>();
        while (intset.size() < count_random_ints) {
            if (myString.charAt(myrand) == ' ' || myString.charAt(myrand) == '-') {
                myrand = rand.nextInt(myString.length());
            } else if (myString.charAt(myrand) != ' ') {
                intset.add(myrand);
                myrand = rand.nextInt(myString.length());
            }
            int i = 0;
            for (int c : intset) {
                out[i] = c;
                i++;
            }
        }
        return out;
    }
    public static class SerializableEntry<K,V> implements Map.Entry<K,V>, Serializable {
        private static final long serialVersionUID = 1L;
        private final K key;
        private final V value;
        public SerializableEntry(K key, V value) {
            this.key = key;
            this.value = value;
        }
        @Override
        public K getKey() {
            return key;
        }
        @Override
        public V getValue() {
            return value;
        }
        @Override
        public V setValue(V value) {
            throw new UnsupportedOperationException("setValue is not supported");
        }
        // Override equals()
        @Override
        public boolean equals(Object obj) {
            if (this == obj) return true; // Same object reference
            if (obj == null || getClass() != obj.getClass()) return false; // Check class type
            SerializableEntry<?, ?> other = (SerializableEntry<?, ?>) obj;
            return (key == null ? other.key == null : key.equals(other.key)) &&
                   (value == null ? other.value == null : value.equals(other.value));
        }
        @Override
        public int hashCode() {
            int result = (key == null ? 0 : key.hashCode());
            result = 31 * result + (value == null ? 0 : value.hashCode());
            return result;
        }
        @Override
        public String toString() {
            return "SerializableEntry{" + "key=" + key + ", value=" + value + '}';
        }
    }
    @SuppressWarnings("unchecked")
    public static List<SerializableEntry<String,String>> ReadListFromFile (File f) throws ClassNotFoundException {
        List<SerializableEntry<String,String>> myList = new ArrayList<>();
        try(ObjectInputStream ois = new ObjectInputStream(new FileInputStream(f))) {
            myList = (ArrayList<SerializableEntry<String, String>>) ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return myList;
    }
    public static void writeListToFile(List<SerializableEntry<String,String>> l, File f) {
        try(ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(f))) {
            oos.writeObject(l);
            oos.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
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
    public static List<SerializableEntry<String, String>> create_List(File en, File cr) throws IOException {
        BufferedReader myBufferedEnglishReader = new BufferedReader(new FileReader(en));
        BufferedReader myBufferedCyrillicReader = new BufferedReader(new FileReader(cr));
        String myEnglishString;
        String myCyrillicString;
        List<SerializableEntry<String, String>> myList = new ArrayList<>();
        while ((myEnglishString = myBufferedEnglishReader.readLine()) != null && (myCyrillicString = myBufferedCyrillicReader.readLine()) != null) {
            SerializableEntry<String,String> a = new SerializableEntry<>(cut_tabulation(myEnglishString), (cut_tabulation(myCyrillicString)));
            myList.add(a);
        }
        myBufferedEnglishReader.close();
        myBufferedCyrillicReader.close();
        return myList;
    }
    public static String cut_tabulation(String a) {
        String first = a.replaceAll("[\\t\\s]+", " ");
        String out = first.replaceAll("^[\\s\\t]+|[\\s\\t]+$","");
        return out;
    }
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        File english_file = new File("English_words.txt");
        File cyrillic_file = new File("Cyrillic_words.txt");
        File second_level = new File("Level_two.ser");
        File third_level = new File("Level_three.ser");
        catch_exception(english_file);
        catch_exception(cyrillic_file);
        if (!second_level.exists()) {
            List<SerializableEntry<String, String>> levelTwo = new ArrayList<>();
            second_level.createNewFile();
            writeListToFile(levelTwo, second_level);
            System.out.println("New file with second level was created");
        }
        if (!third_level.exists()) {
            List<SerializableEntry<String, String>> levelThree = new ArrayList<>();
            third_level.createNewFile();
            writeListToFile(levelThree, third_level);
            System.out.println("New file with third level was created");
        }
        List<SerializableEntry<String,String>> mainList = create_List(english_file, cyrillic_file);
        List<SerializableEntry<String,String>> shuffledList = mainList;
        Collections.shuffle(shuffledList);
        List<SerializableEntry<String,String>> levelTwo = ReadListFromFile(second_level);
        List<SerializableEntry<String,String>> levelTwo_toWrite = ReadListFromFile(second_level);
        List<SerializableEntry<String,String>> levelThree = ReadListFromFile(third_level);
        List<SerializableEntry<String,String>> levelThree_toWrite = ReadListFromFile(third_level);
        Scanner scan = new Scanner(System.in);
        System.out.println(mainList.size() + " words to guess!");
        for (SerializableEntry<String, String> entryToFind : shuffledList) {
            int how_many_chars_to_guess = 1;
            int[] ints_to_guess;
            if(levelTwo.contains(entryToFind) == false) {
                ints_to_guess = get_correct_random_ints(entryToFind, levelTwo, levelThree);
                how_many_chars_to_guess = 1;
                String hidden = randInt_to_hiddenString(entryToFind.getKey(), ints_to_guess);
                System.out.println(hidden + " " + entryToFind.getValue().toLowerCase());
                char[] answer = get_chars_input(scan, how_many_chars_to_guess);
                char[] skipArray = {'0'};
                if (Arrays.equals(answer, skipArray)) {
                    continue;
                }
                char[] hidden_chars = chars_from_ints(ints_to_guess, entryToFind.getKey().toLowerCase());
                while (answer_matches(answer, hidden_chars) == false) {
                    System.out.println("Try again or type \"0\" to skip:");
                    System.out.println(hidden + " " + entryToFind.getValue().toLowerCase());
                    answer = get_chars_input(scan, how_many_chars_to_guess);
                    if (Arrays.equals(answer, skipArray)) {
                        break;
                    }
                }
                if (Arrays.equals(answer, skipArray)) {
                    continue;
                }
                if (answer_matches(answer, hidden_chars)) {
                    System.out.println("Correct. It is \"" + entryToFind.getKey() + "\".");
                    levelTwo_toWrite.add(entryToFind);
                }
            }
            if(levelTwo.contains(entryToFind) && levelThree.contains(entryToFind) == false) {
                ints_to_guess = get_correct_random_ints(entryToFind, levelTwo, levelThree);
                how_many_chars_to_guess = 3;
                String hidden = randInt_to_hiddenString(entryToFind.getKey(), ints_to_guess);
                System.out.println(hidden + " " + entryToFind.getValue().toLowerCase());
                char[] answer = get_chars_input(scan, how_many_chars_to_guess);
                char[] hidden_chars = chars_from_ints(ints_to_guess, entryToFind.getKey().toLowerCase());
                if (answer_matches(answer, hidden_chars) == false) {
                    System.out.println("Wrong. It is \"" + entryToFind.getKey() + "\".");
                    levelTwo_toWrite.remove(entryToFind);
                }
                if (answer_matches(answer, hidden_chars)) {
                    System.out.println("Correct. It is \"" + entryToFind.getKey() + "\".");
                    levelThree_toWrite.add(entryToFind);
                }
            }
            if(levelThree.contains(entryToFind)) {
                int intstoguess[] = new int[entryToFind.getKey().length()];
                for(int i = 0; i < entryToFind.getKey().length(); i++) {
                    intstoguess[i] = i;
                }
                ints_to_guess = intstoguess;
                how_many_chars_to_guess = entryToFind.getKey().length();
                String hidden = randInt_to_hiddenString(entryToFind.getKey(), ints_to_guess);
                System.out.println(hidden + " " + entryToFind.getValue().toLowerCase());
                char[] answer = get_chars_input(scan, how_many_chars_to_guess);
                char[] hidden_chars = chars_from_ints(ints_to_guess, entryToFind.getKey().toLowerCase());
                if (answer_matches(answer, hidden_chars) == false) {
                    System.out.println("Wrong. It is \"" + entryToFind.getKey() + "\".");
                    levelThree_toWrite.remove(entryToFind);
                }
                if (answer_matches(answer, hidden_chars)) {
                    System.out.println("Correct. It is \"" + entryToFind.getKey() + "\".");
                }
            }
            writeListToFile(levelTwo_toWrite, second_level);
            writeListToFile(levelThree_toWrite, third_level);
        }
        scan.close();
    }
}
