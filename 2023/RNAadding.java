class RNA {
    String chain;
    RNA next;
    public RNA (String chain) {
        this.chain = chain;
    }
}
public class RNAadding {
    public static RNA prepend (RNA head, String s) {
        RNA newRNA = new RNA(s);
        newRNA.next = head;
        return newRNA;
    }
    public static RNA append (RNA head, String s) {
        RNA newRNA = new RNA(s);
        if (head.next == null) {
            return newRNA;
        }
        RNA current = head;
        while (current.next != null) {
            current = current.next;
        }
        current.next = newRNA;
        return current;
    }
    public static void main(String[] args) {
        RNA r1 = new RNA("1AGTC");
        RNA r2 = new RNA("2CTGA");
        RNA r3 = new RNA("3TCGA");
        r1.next = r2;
        r2.next = r3;
        append(r1, "4Fourth");
        RNA r0 = prepend(r2, "0First");
        RNA current = r0;
        while (current != null) {
            System.out.println(current.chain);
            current = current.next;
        }
    }
}