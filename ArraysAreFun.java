import java.util.Scanner;

public class ArraysAreFun {
    public static void main(String[] args) {
        char [] vovels = {'a', 'e', 'i', 'o', 'u'};
        Scanner scan = new Scanner(System.in);
        String myString = scan.nextLine();
        scan.close();
        char [] charArray = new char[myString.length()];
        int vovelsCount = 0;
        for (int i = 0; i < myString.length(); i++) {
            charArray [i] = myString.charAt(i);
        }
        for (int a = 0; a < vovels.length; a++) {
            for (int b = 0; b < charArray.length; b++) {
                if (vovels[a] == charArray[b]) {
                    vovelsCount++;
                }
            }
        }
        System.out.println("Count of vovels is: " + vovelsCount);
    }
}