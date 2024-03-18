import java.util.Scanner;

public class divisor {
    public static void main(String[] args) {
        System.out.println("write first number:");
        Scanner scan = new Scanner(System.in);
        int a = scan.nextInt();
        System.out.println("Write second number:");
        int b = scan.nextInt();
        scan.close();
        int bigger; int smaller;
        int common = 1;
        if (a < 1 || b < 1) {System.out.println("Not good. Write positive number.");}
        if (a == b) {System.out.println("Not good. Numbers are equal.");}
        if (a < b) {bigger = b; smaller = a;}
        else {bigger = a; smaller = b;}
        for (int i = 1; i < smaller / 2 + 1; i++) {
            if (a % i == 0 && b % i == 0) {
                common = i;
            }
        }
        System.out.println(common + " is greatest common divisor for " + bigger + " and " + smaller);
    }
}
