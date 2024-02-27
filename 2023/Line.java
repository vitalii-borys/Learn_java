class Person {
    String name;
    Person next;
    Person(String input) {
        this.name = input;
    }
}
public class Line {
    public static Person append(Person head, String s) {
        Person newOne = new Person(s);
        if (head == null) {
            return newOne;
        }
        Person last = head;
        while (last.next != null) {
            last = last.next;     
        }
        last.next = newOne;
        return newOne;
    }
    public static Person prepend(Person head, String s) {
        Person newOne = new Person(s);
        newOne.next = head;
        return newOne;
    }
    public static void main(String[] args) {
        Person p1 = new Person("Alice");
        Person p2 = new Person("Bob");
        Person p3 = new Person("Clara");
        p1.next = p2;
        p2.next = p3;
        append(p1, "Donald");
        append(p3, "Edmond");
        Person p0 = prepend(p1, "Oleh");
        Person header = p0;
        while (header != null) {
            System.out.println(header.name);
            header = header.next;
        }
    }
}
