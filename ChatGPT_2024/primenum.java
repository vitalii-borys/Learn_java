import java.util.Scanner;

public class primenum {
    public static void main(String[] args) {
        System.out.println("What number do you want to check?");
        Scanner scan = new Scanner(System.in);
        int myNumber = scan.nextInt();
        scan.close();
        int count = 0;
        for (int i = 2; i <= myNumber / 2; i++) {
            if (myNumber % i == 0) {
                count++;
            }
        }
        if (count > 0) {
            System.out.println(myNumber + " is not a Prime number.");
        }
        else {System.out.println(myNumber + " is Prime.");}
    }
}
