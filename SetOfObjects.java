import java.util.HashSet;
import java.util.Set;

public class SetOfObjects {
    String name;
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public static void main(String[] args) {
        SetOfObjects soo = new SetOfObjects();
        SetOfObjects so1 = new SetOfObjects();
        soo.setName("Boban");
        so1.setName("Biban");
        Set<Object> s = new HashSet<Object>();
        s.add(soo);
        s.add(so1);
        for (Object t : s) {
            System.out.println(((SetOfObjects) t).getName());
        }
    }
}
