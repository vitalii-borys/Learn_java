import java.util.Scanner;

public class biggestnum {
    public static void main(String[] args) {
        int[] myArray = new int[5];
        Scanner scan = new Scanner(System.in);
        myArray[0] = scan.nextInt();
        myArray[1] = scan.nextInt();
        myArray[2] = scan.nextInt();
        myArray[3] = scan.nextInt();
        myArray[4] = scan.nextInt();
        scan.close();
        int maxNumber = myArray[0];
        for (int i = 0; i < myArray.length; i++) {
            if (myArray[i] > maxNumber) {                
                maxNumber = myArray[i];
            }
        }
        System.out.println(maxNumber + " is the biggest");
    }
}
