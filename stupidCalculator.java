import java.util.Scanner;
public class stupidCalculator {
    public static void main(String[] args) {
        boolean inputting = true;
        while (inputting) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Write first number");
        int a = scan.nextInt();
        scan.nextLine(); // to change nextInt to nextLine
        System.out.println("Write operator symbol");
        char c = scan.nextLine().charAt(0);
        while (c != '/' && c!= '*' && c != '-' && c != '+') {
            System.out.println("Please, write operator");
            c = scan.nextLine().charAt(0);
        }
        System.out.println("Write second number");
        int b = scan.nextInt();
        while (b == 0 && c == '/') {
            System.out.println("Thou shall not divide by zero! Write another number");
            b = scan.nextInt();}
        scan.close();
        System.out.print("The result of ");
        if (c == '/') {System.out.print("division of " + a + " and " + b + " is: " + a/b);}
        if (c == '*') {System.out.println("multiplication of " + a + " and " + b + " is: " + a*b);}
        if (c == '+') {System.out.println("addittion of " + a + " and " + b + " is: " + (a+b));}
        if (c == '-') {System.out.println("substraction of " + b + " from " + a + " is: " + (a-b));}    
        inputting = false;}
    }
}