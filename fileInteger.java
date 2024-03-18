import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;
public class fileInteger {
    public static void main(String[] args) throws FileNotFoundException {
        int count = 0;
        try {
            File myFile = new File("Integers.txt");
            Scanner scan = new Scanner(myFile);
            while (scan.hasNextInt()) {
                scan.nextInt();
                count++;
            }
            scan.close();
        } catch (FileNotFoundException e) {
            System.out.println("Error");
        }
        int[] myInts = new int[count];
        try {
            File myFile = new File("Integers.txt");
            Scanner scan2 = new Scanner(myFile);
        for (int i = 0; i < myInts.length; i++) {
            myInts[i] = scan2.nextInt();
            }
        scan2.close();
        } catch (FileNotFoundException e) {
            System.out.println("Error");
        }
        System.out.println(Arrays.toString(myInts) + " is my array of integers.");
        int sumEvens = 0; int prodOdds = 1;
        if (myInts.length > 0) {
            int max = myInts[0]; int min = myInts[0];
            for (int i = 0; i < myInts.length; i++) {
                if (myInts[i] < min) {
                    min = myInts[i];
                }
                if (myInts[i] > max) {
                    max = myInts[i];
                }
                if (myInts[i] % 2 == 0) {
                    sumEvens += myInts[i];
                }
                if (myInts[i] % 2 > 0) {
                    prodOdds *= myInts[i];
                }
            }
            System.out.println(sumEvens + " is sum of all even numbers of my array.");
            System.out.println(prodOdds + " is product of all odd numbers of my array.");
            System.out.println(max + " is maximum one.");
            System.out.println(min + " is minimum one");
            Arrays.sort(myInts);
        }
        Set <Integer> mySet = new HashSet<>();
        for (int myInt : myInts) {
            mySet.add(myInt);
        }
        for (int i : mySet) {
            int c = 0;
            for (int b : myInts) {
                if (i == b) {
                    c++;
                }
            }
            System.out.println(i + " occurs " + c + " times.");
        }
    }
}