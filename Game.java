import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Game {
    public static void WriteInputToFile (String n) {
        System.out.println("Ви ввели: " + n);
            try {
                FileWriter fw = new FileWriter("Відучити від java.txt");
                for (int i = 0; i < n.length(); i++) {
                    fw.write(n.charAt(i));
                }
                System.out.println("Файл успішно записаний");
                fw.close(); 
            } 
            catch (Exception e) { 
                e.getStackTrace(); 
            }
    }
    public static void ReadInputFromFile() {
        try (FileReader reader = new FileReader("Відучити від java.txt");
            BufferedReader br = new BufferedReader(reader)) {
            String line;
            while ((line = br.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static void main(String[] args) {
        System.out.println("Привіт");
		Scanner scan = new Scanner(System.in);
        String input = scan.nextLine();
        scan.close();
        WriteInputToFile(input);
        ReadInputFromFile();
    }
}
