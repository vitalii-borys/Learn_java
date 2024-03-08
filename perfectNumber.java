import java.util.Scanner;
public class perfectNumber {
    public static void main(String[] args) {
        System.out.println("Write till what number to check perfect numbers:");
        Scanner scan = new Scanner(System.in);
        int count = scan.nextInt();
        scan.close();
        long initialTime = System.nanoTime();
        for (int a = 1; a <= count; a++) {
        int myNum = a;
        int[] myArray = new int[myNum - 1];
        for (int i = 0; i < myArray.length; i++) {
            myArray[i] = i + 1;
        }
        for (int i = 0; i < myArray.length; i++) {
        }
        int[] myArray2 = new int[myArray.length];
        for (int i = 0; i < myArray.length; i++) {
            if (myNum % myArray[i] == 0) {
                myArray2[i] = myArray[i];
            }
        }
        int sum = 0;
        for (int i = 0; i < myArray2.length; i++) {
            sum += myArray2[i];
        }
        if (sum == myNum) {
        System.out.println(sum + " is perfect number!");
        System.out.println((System.nanoTime() - initialTime) / 1000000 + " miliseconds took to count.");
    }    
    }
    }    
}