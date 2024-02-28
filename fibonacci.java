import java.util.Scanner;

public class fibonacci {
    public static void main(String[] args) {
        System.out.println("How much count?");
        Scanner scan = new Scanner(System.in);
        int countTo = scan.nextInt();
        scan.close();
        int first = 0;
        int second = 1;
        System.out.println("Here are this numbers:");
        if (countTo >= 1) {
            System.out.print(first + " ");
        }
        if (countTo >= 2) {
            System.out.print(second + " ");
        }
        for (int i = 3; i <= countTo; i++) {
        int sum = first + second;
        System.out.print(sum + " ");
        first = second;
        second = sum;
        }
    }
}
