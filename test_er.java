import java.util.Scanner;
public class test_er {
    public static String phoneNumber(Scanner s) {
        String st = s.nextLine();
        char[] c = st.toCharArray();
        if (c[0] != '+') {
                System.out.println("Start from \'+\':");
                return phoneNumber(s);
            }
        if (c.length != 13) {
                System.out.println("It is not a phone number. Write 13 symbols:");
                return phoneNumber(s);
            }
        for(int ch = 1; ch < c.length; ch++) {
            if (Character.isDigit(c[ch]) == false) {
                System.out.println(c[ch] + " is not a digit. Write phone number:");
                return phoneNumber(s);
            }
        } return st;
    }
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println(phoneNumber(scan));
        scan.close();    
    }
}


/* import java.util.Scanner;
public class test_er {
    public static String phoneNumber() {
        Scanner s = new Scanner(System.in);
        String st = s.nextLine();
        char[] c = st.toCharArray();
        if (c[0] != '+') {
                System.out.println("Start from \'+\':");
                return phoneNumber();
            }
        if (c.length != 13) {
                System.out.println("It is not a phone number. Write 13 symbols:");
                return phoneNumber();
            }
        for(int ch = 1; ch < c.length; ch++) {
            if (Character.isDigit(c[ch]) == false) {
                System.out.println(c[ch] + " is not a digit. Write phone number:");
                return phoneNumber();
            }
        }s.close(); return st;
    }
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println(phoneNumber());
        scan.close();    
    }
} */
