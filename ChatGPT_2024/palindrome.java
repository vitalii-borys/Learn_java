import java.util.Scanner;

public class palindrome {
    public static void main(String[] args) {
        System.out.println("Write palindrome:");
        Scanner scan = new Scanner(System.in);
        String myString = scan.nextLine();
        scan.close();
        char[] myChars = myString.toCharArray();
        char[] newChars = new char[myChars.length];
        for (int i = 0; i < myChars.length; i++) {newChars[i] = myChars[myChars.length - 1 - i];}
        /* String newString = String.valueOf(newChars); */
        String newString = String.copyValueOf(newChars);
        System.out.println(newString + " is new String");
        if (newString.equals(myString)) {System.out.println("Yes, " + myString + " is palindrome.");} else {
            System.out.println("No, " + myString + " and " + newString + " are not palindrome.");
        }
        String a = "bill"; String b = "bill"; if (a == b) {System.out.println("is works");}
    }
}
