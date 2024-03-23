import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class MisterObjectIO implements Serializable{
    private String name = "Theodor";
    private String sername = "Duncan";
    private int age = 65;
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getSername() {
        return sername;
    }
    public void setSername(String sername) {
        this.sername = sername;
    }
    public int getAge() {
        return age;
    }
    public void setAge(int age) {
        this.age = age;
    }
    public static void main(String[] args) {
        MisterObjectIO nio = new MisterObjectIO();
        String out = nio.getName() + " " + nio.getSername() + " " + nio.getAge();
        System.out.println(out);
        String filename = nio.getName() + " " + nio.getSername();
        try {
            FileOutputStream fio = new FileOutputStream(filename);
            ObjectOutputStream oos = new ObjectOutputStream(fio);
            oos.writeObject(nio);
            oos.flush();
            oos.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        MisterObjectIO myMAN = null;
        try {
            FileInputStream fis = new FileInputStream(filename);
            ObjectInputStream ois = new ObjectInputStream(fis);
            myMAN = (MisterObjectIO)ois.readObject();
            ois.close();
            fis.close();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException b) {
            b.printStackTrace();
        }
        System.out.println(myMAN.getName() + " is name from a file.");
    }
}