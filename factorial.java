import java.util.Scanner;

public class factorial {
    public static void main(String[] args) {
        System.out.println("Factorial of what number do you want me to calculate?");
        Scanner scan = new Scanner(System.in);
        int myInt = scan.nextInt();
        scan.close();
        for (int i = myInt - 1; i > 0; i--) {
        myInt = myInt * i;
        }
        System.out.println("Result is: " + myInt);
    }
}
