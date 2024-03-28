import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

class Account implements Serializable  {

    private String accNumber = "+123456789321";
    private String name = "Bob";
    private double ballance = 0;
    private String FileName = "BankAccounts.dat";

    public void displayInfo(Account ba) {
        System.out.println("Acc №: " + ba.getAccNumber());
        System.out.println("Name : " + ba.getName());
        System.out.println("Ballance : " + ba.getBallance());
    }
    
    public String getAccNumber() {
        return accNumber;
    }

    public void setAccNumber(String accNumber) {
        this.accNumber = accNumber;
    }
    
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    
    public double getBallance() {
        return ballance;
    }

    public void setBallance(double ballance, Account ba) {
        this.ballance = ballance;
    }
    
    public String getFileName() {
        return FileName;
    }
}

public class BankAccountProgram {
    
    private Set<Account> mySet = new HashSet<Account>();
    
    public void addToSet(Account o) {
        mySet.add(o);
    }

    public void setMySet(HashSet<Account> mySet) {
        this.mySet = mySet;
    }

    public static HashSet<Account> getDefaultSet() {
        Account a = new Account();
        HashSet<Account> mySet = new HashSet<>();
        mySet.add(a);
        return mySet;
    }
    
    public static void WriteSetToFile(Set<Account> sba) {
        Account acc = new Account();
        String filename = acc.getFileName();
        try {
            FileOutputStream fos = new FileOutputStream(filename);
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(sba);
            oos.flush();
            oos.close();
            fos.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @SuppressWarnings("unchecked")
    public static Set<Account> ReadSetFromFile() {
        Account acc = new Account();
        String filename = acc.getFileName();
        Set<Account> sba = new HashSet<>();
        try {
            FileInputStream fis = new FileInputStream(filename);
            ObjectInputStream ois = new ObjectInputStream(fis);
            sba = (Set<Account>) ois.readObject();
            ois.close();
            fis.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (sba == null) {
            System.out.println("Not good. sba = null");
        } else {
        for(Account bob : sba) {
            if (bob != null) {
                bob.displayInfo(bob);
                }
            }
        }
        return sba;
    }

    
    public static void greet(Account bac) {
        System.out.println(
            "Congratulations! Now you have an account in bankBank bank. "
            + bac.getName() + " is your name. " + bac.getAccNumber() + " is your number."
            + bac.getBallance() + " is your ballance.");
    }
    
    public static String getPhoneNumber(Scanner scann) {
        String st = scann.nextLine();
        char[] c = st.toCharArray();
        if (c[0] != '+') {
            System.out.println("Start from \'+\':");
            return getPhoneNumber(scann);
        }
        if(c.length != 13) {
            System.out.println("It is not a phone number. Write 13 symbols:");
            return getPhoneNumber(scann);
        }
        for(int ch = 1; ch < c.length; ch++) {
            if (Character.isDigit(c[ch]) == false) {
                System.out.println(ch + " is not a digit.");
                return getPhoneNumber(scann);
            }
        }
        System.out.println("Your phone number is " + st);
        return st;
    }

    public void displayInfo(Account ba) {
        System.out.println("Acc №: " + ba.getAccNumber());
        System.out.println("Name : " + ba.getName());
        System.out.println("Ballance : " + ba.getBallance());
    }

    public static Account createAccount(Scanner sca) {
        System.out.println("Let's create account. Write your name:");
        String username = getText(sca);
        System.out.println("Write your phone number:");
        String accnum = getPhoneNumber(sca);
        Account b = new Account();
        b.setName(username);
        b.setAccNumber(accnum);
        b.setBallance(0,b);
        return b;
    }

    public static String getText(Scanner scant) {
        String s = scant.nextLine();
        char[] c = s.toCharArray();
        for(char ch : c) {
            if(Character.isDigit(ch)) {
                System.out.println(ch + " is a digit.");
                return getText(scant);
            }
        }
        return s;
    }

    public static int getInt(Scanner s) {
        if(s.hasNextInt()) {
            int i = s.nextInt();
            return i;
        } else {
            String r = s.next();
            System.out.println(r + " is not a number. Write number:");
            return getInt(s);
        }
    }
    
    public static void main(String[] args) {
        Set<Account> mySe = ReadSetFromFile();
        if (mySe == null) {mySe = getDefaultSet();}
        System.out.println("Do you have account in bankBank bank? 1 - yes, 0 - no");
        Scanner scan = new Scanner(System.in);
        int firstcheck = getInt(scan);
        scan.nextLine();
        if (firstcheck == 0) {
            Account b = createAccount(scan);
            greet(b);
            mySe.add(b);
        } if (firstcheck == 1) {
            System.out.println("What is your account number? (phone number)");
            String accNum = getPhoneNumber(scan);
            List<Account> myList = new ArrayList<>(mySe);
            Account ac = myList.get(0);
            for (Account a : mySe) {
                if (accNum.equals(a.getAccNumber())) {
                    a.displayInfo(ac);
                }
            } scan.close();
        }
        System.out.println("And finally write and read:");
        WriteSetToFile(mySe);
        ReadSetFromFile();
    }
}