import java.util.ArrayList;

public class WriteSetOfPersonsToFile {
    public static void main(String[] args) {

        ArrayList<Person> myList = new ArrayList<>();
        
        
        Person first = new Person("Bob", 66);
        Person second = new Person("Dick", 44);
        
        
        myList.add(first);
        myList.add(second);
    }
}
class Person {
    private String name;
    private int age;
    public Person (String n, int a) {this.name = n; this.age = a;}
    public String getName() {return name;}
    public int getAge() {return age;}
}