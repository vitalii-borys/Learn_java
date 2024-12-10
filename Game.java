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
                System.out.println("Файл \"Відучити від java.txt\" успішно записаний");
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
        System.out.println("О, хтось ще грає текстові ігри в 2024 році? Як тебе звати?");
		Scanner scan = new Scanner(System.in);
        String name = scan.nextLine();
        System.out.println(name + ", привіт. Ти у звичайній грі, де треба знайти вихід з гри.");
        System.out.println("Тут ти можеш іти \"і\" в напрямку сторін горизонту або спробувати взаємодіяти \"в\" з предметами.\"");
        System.out.println("---Приклад---\"і північ\"---\"в стіл\"---");
        System.out.println("...");
        System.out.println("Ти просинаєшся на підлозі в пустій кімнаті одноповерхового будинку.");
        System.out.println("Прямо двері, справа двері. Справа стіна з картиною.");
        System.out.println("Ззаду вікно, в якому видно схід сонця. Але на ньому решітка.");
        System.out.println("Що робимо?");
        System.out.println("...");
        String input = scan.nextLine();
        if (input.equals("і північ")) {System.out.println("Ти відкриваєш двері, заходиш у нову схожу кімнату і бачиш бобра.");}
        if (input.equals("і захід")) {System.out.println("Ти відкриваєш двері, заходиш в нову кімнату і бачиш прямий коридор.");}
        if (input.equals("і схід")) {System.out.println("Решітка не пускає.");}
        if (input.equals("в картина")) {System.out.println("\"Ранок у сосновому лісі\" Іван Шишкін та Костянтин Савицький.\n За кртиною був захований ключ і вдалося його підібрати.");}
        if (input.equals("і північ") == false & input.equals("в картина") == false & input.equals("і схід") == false & input.equals("в картина") == false) {System.out.println("Ти щось не то вводиш.");}
        scan.close();
        String myString = name + "\n" + input;
        WriteInputToFile(myString);
        ReadInputFromFile();
    }
}
