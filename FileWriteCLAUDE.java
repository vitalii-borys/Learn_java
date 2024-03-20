import java.util.Arrays;
import java.util.List;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;

public class FileWriteCLAUDE {
    
    static void readFromFile() {
        char[] mychars = new char[12];
        char[] mynumbers = new char[15];
        try {
            FileReader fr = new FileReader("text.txt");
            FileReader fr2 = new FileReader("numbers.txt");
            fr.read(mychars);
            fr2.read(mynumbers);
            System.out.println(String.valueOf(mychars));
            System.out.println(String.valueOf(mynumbers));
            fr.close();            
            fr2.close();
        } catch (IOException i) {
            System.out.println("File not found");
            i.printStackTrace();
        }
    }
    static void BreadFromFile() {
        try {
            BufferedReader br = new BufferedReader(new FileReader("text.txt"));
            BufferedReader br2 = new BufferedReader(new FileReader("numbers.txt"));
            String m = br.readLine();
            String n = br2.readLine();
            System.out.println(m);
            System.out.println(n);
            br.close();
            br2.close();
        } catch (IOException p) {
            System.out.println("File not found");
            p.printStackTrace();
        }
    }
    static void CreadFromFile() {
        String numberscontent = "";
        String textcontent = "";
        StringBuilder sb = new StringBuilder();
        StringBuilder sb2 = new StringBuilder();
        try {
            BufferedReader bf = new BufferedReader(new FileReader("numbers.txt"));
            String current;
            while ((current = bf.readLine()) != null) {
            sb.append(current);
            } bf.close();
        } catch (IOException i) {
            System.out.println("File not found");
            i.printStackTrace();
        }
        try {
            BufferedReader bf2 = new BufferedReader(new FileReader("text.txt"));
            String current;
            while ((current = bf2.readLine()) != null) {
                sb2.append(current);
            } bf2.close();
        } catch (IOException f) {
            f.printStackTrace();
        }
        numberscontent = sb.toString();
        textcontent = sb2.toString();
        System.out.println(textcontent + " is \"text\" content");
        System.out.println(numberscontent + " is \"numbers\" content");
    }
    static void ReadFromFile(String file) {
        String content = "";
        StringBuilder sbl = new StringBuilder();
        try {
            BufferedReader b = new BufferedReader(new FileReader(file));
            String current;
            while ((current = b.readLine()) != null) {
                sbl.append(current);
            } b.close();
        } catch (IOException c) {
            System.out.println("File not found" + file);
            c.printStackTrace();
        } content = sbl.toString();
        System.out.println(content + " is contect of " + file);
    }
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(1,2,3,4,5);
        try {
            FileWriter fw = new FileWriter("numbers.txt");
            fw.write(numbers.toString());
            fw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        String s = "Floating";
        float f = 0.43f;
        try {
            PrintWriter pw = new PrintWriter("text.txt");
            pw.print(s + f); pw.flush(); pw.close();
        } catch (IOException a) {
            a.printStackTrace();
        }
        readFromFile();
        BreadFromFile();
        CreadFromFile();
        ReadFromFile("text.txt");
        ReadFromFile("numbers.txt");
    }
}