import java.util.Scanner;

public class sumOfDigits {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int input = scan.nextInt();
        scan.close();
        int sum = 0;
        while (input > 0) {
            int digit = input % 10;
            sum += digit;
            input /= 10;
        }
        System.out.println(sum);
    }
}
