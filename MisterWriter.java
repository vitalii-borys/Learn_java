import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class MisterWriter {
    private String name = "Theodor";
    private String surname = "Duncan";
    private int age = 60;
    public String getSurname() { 
        return surname;
    }
    public void setSurname(String surname) {
        this.surname = surname;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public int getAge() {
        return age;
    }
    public void setAge(int age) {
        this.age = age;
    }
    public static void main(String[] args) {
        MisterWriter nw = new MisterWriter();
        String filename = nw.getName() + " " + nw.getSurname() + ".txt";
        String output = "Hello, my name is " + nw.getName() +
        " " + nw.getSurname() + ". I am " + nw.getAge() + " years old.";
        try (FileWriter fw = new FileWriter(filename)) {
            fw.write(output);
            fw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            FileReader fr = new FileReader(filename);
            BufferedReader br = new BufferedReader(fr);
            String readed = br.readLine();
            br.close();
            System.out.println("\"" + readed + "\"- is readed content of the file. \"" + filename + "\"");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
