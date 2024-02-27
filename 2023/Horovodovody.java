class Horovodovid {
    String name;
    Horovodovid next;

    public Horovodovid(String input) {
        this.name = input;
        this.next = null;
    }
}
public class Horovodovody {
    public static Horovodovid append (Horovodovid head, String s) {
        Horovodovid newHorovodovid = new Horovodovid(s);
        if (head.next == null) {
            return newHorovodovid;
        }
        Horovodovid current = head;
        while (current.next != null) {
            current = current.next;
        }
        current.next = newHorovodovid;
        return head;
    }
    public static void main(String[] args) {
        Horovodovid h1 = new Horovodovid("Ivan");
        Horovodovid h2 = new Horovodovid("Ivanka");
        Horovodovid h3 = new Horovodovid("Vasyl");
        h1.next = h2;
        h2.next = h3;
        append(h1, "dick");
        Horovodovid current = h1;
        while (current != null) {
            System.out.println(current.name);
            current = current.next;
        }
    }    
}