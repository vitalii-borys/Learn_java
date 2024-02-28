import java.util.Arrays;

public class anagram {
    public static void main(String[] args) {
        String first = "listen";
        String second = "silent";
        char[] firstArray = first.toCharArray();
        char[] secondArray = second.toCharArray();
        Arrays.sort(firstArray);
        Arrays.sort(secondArray);
        if (Arrays.equals(firstArray, secondArray)) {
            System.out.println("Anagram");
        }
        else {
            System.out.println("is not anagram");
        }
    }
}
