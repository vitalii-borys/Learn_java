import java.util.Scanner;

public class reversestring {
    public static void main(String[] args) {
        System.out.println("Write the string you want to reverse:");
        Scanner scan = new Scanner(System.in);
        String myString = scan.nextLine();
        scan.close();
        String reversedString = new String();
        for (int i = myString.length() - 1; i >= 0; i--) {
            reversedString += myString.charAt(i);
        }
        System.out.println(reversedString);
    }
}
