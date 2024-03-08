import java.util.Scanner;;
public class primeNumbers {
    public static void main(String[] args) {
        System.out.println("Write till what number to count Primes:");
        Scanner scan = new Scanner(System.in);
        int count = scan.nextInt();
        scan.close();
        long initialTime = System.nanoTime();
        for (int a = 2; a < count; a++) {
        int isPrime = 0;
        for (int i = 2; i <= Math.sqrt(a); i++) {
            if (a % i == 0) {isPrime++;}
        }
        if (isPrime == 0) {System.out.println(a + " is Prime");}
        }        
        System.out.println((System.nanoTime() - initialTime) / 1000000
        + " milliseconds took to count.");
    }
}
