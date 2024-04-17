import java.io.Console;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.HashSet;
import java.util.Scanner;

class Account implements Serializable  {

    private int accNumber = 555555;
    private String name = "Bob";
    private String FileName = "BankAccounts.dat";
    private double ballance = 0;
    private String password = "ADMIN";
    
    public void displayInfo(Account ba) {
        System.out.print("Acc № [" + ba.getAccNumber() + "] ");
        System.out.print("Name [" + ba.getName() + "] ");
        System.out.print("Ballance [" + ba.getBallance() + "] ");
        //System.out.println("Password [" + ba.getPassword() + "]");
        System.out.println();
    }
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getAccNumber() {
        return accNumber;
    }

    public void setAccNumber(int accnum) {
        this.accNumber = accnum;
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

    public static void removeObjFromSet(HashSet<Account> s, Account a) {
        s.remove(a);
    }
    
    public static Account currentAcc(HashSet<Account> hs,Scanner scan) {
        Account cur = null;
        int accIn = Integer.parseInt(PhoneNumber(scan).substring(4));
        for (Account a : hs) {
            if (a.getAccNumber() == accIn) {
                cur = a;
            }
        } return cur;
    }

    public static void adminSession (Scanner scan) {
        Account adminAcc = new Account();
        System.out.println("Write admin password:");
        Console cons = System.console();
        char[] cPass = cons.readPassword();
        String adminPasswordin = String.valueOf(cPass);
        while (adminPasswordin.equals(adminAcc.getPassword()) == false) {
            System.out.println("Incorrect password. Try again:");
            adminPasswordin = scan.nextLine();
        }
        if (adminPasswordin.equals(adminAcc.getPassword())) {
            adminPasswordin = null;
            System.out.println("Do you want to create or remove an account? Write \"create\" or \"remove\"");
        }
        HashSet<Account> mySe = ReadSetFromFile();
        if (mySe == null) {
            mySe = getDefaultSet();
        }
        String createOrRemove = scan.nextLine();
        while (createOrRemove.equals("create") == false & createOrRemove.equals("remove") == false) {
            System.out.println("Only \"create\" or \"remove\", please:");
            createOrRemove = scan.nextLine();
        }
        if (createOrRemove.equals("create")) {
            Account b = createAccount(/* scan */);
            greet(b);
            mySe.add(b);
        }
        if (createOrRemove.equals("remove")) {
            System.out.println("Write the phone number of customer's account to remove:");
            int intAccToremove = Integer.parseInt(PhoneNumber(scan).substring(4));
            Account current = new Account();
            int count = 0;
            for (Account d : mySe) {
                if (d.getAccNumber() == intAccToremove) {
                    System.out.println("You are going to remove " + d.getName() + "'s account:");
                    Console f = System.console();
                    char[] CharsPassw = f.readPassword("Write admin password:");
                    String pass = String.valueOf(CharsPassw);
                    while (pass.equals(current.getPassword()) == false) {
                        System.out.println("Incorrect password. Try again:");
                        pass = scan.nextLine();
                    }
                    if (pass.equals(current.getPassword())) {
                        pass = null;
                        System.out.println("Account of " + d.getName() + " has been removed.");
                        current = d;
                        count++;
                        }
                    }
                }
                if (count == 0) {
                    System.out.println("There is no account № " + intAccToremove);
                }
            removeObjFromSet(mySe,current);
        }
        System.out.println("And finally write and read:");
        WriteSetToFile(mySe);
        ReadSetFromFile();
}

    public static void newCustomer(boolean programWorks) {
        HashSet<Account> mySe = ReadSetFromFile();
        if (mySe == null) {
            mySe = getDefaultSet();
        }
        Scanner scan = new Scanner(System.in);
        System.out.println("Write your phone number:");
        Account current = currentAcc(mySe, scan);
        if (current != null) {
            for (Account a : mySe) {
                if (current.getAccNumber() == a.getAccNumber()) {
                    a.displayInfo(a);
                    System.out.println(" - is text from HashSet<Account> mySe");
                    current = a;
                }
            }
        }
        if (current == null) {
            Account b = createAccount(/* scan */);
            greet(b);
            mySe.add(b);
            current = b;
        }
        System.out.println(current.getName() + ", what do you want to do? \nWrite \"deposit\" or \"withdraw\"");
        String secondcheck = getText(scan);
        if (secondcheck.equals("deposit") == false & secondcheck.equals("withdraw") == false) {
            System.out.println("Only \"deposit\" and \"withdraw\", please");
            secondcheck = getText(scan);
        }
        if (secondcheck.equals("deposit")) {
            System.out.println("How much do you want to deposit?");
            double depositInput = getDSum(scan);
            System.out.println(current.getName() + ", you are going to deposit " + depositInput + " dollars.");
            Console d = System.console();
            char[] charPass = d.readPassword("Write your password:");
            String StringPassw = String.valueOf(charPass);
            if (StringPassw.equals(current.getPassword())) {
                current.setBallance((current.getBallance() + depositInput), current);
                StringPassw = null;
                System.out.println("Your new ballance is: " + current.getBallance() + " dollars.");
            }
        }
        if (secondcheck.equals("withdraw")) {
            System.out.println("How much do you want to withdraw?");
            double withdrawal = getDSum(scan);
            System.out.println(current.getName() + ", you are going to withdraw " + withdrawal + " dollars.");
            Console e = System.console();
            char[] myCPass = e.readPassword("Write your password:");
            String PassInput = String.valueOf(myCPass);
            if (PassInput.equals(current.getPassword()) == false) {
                System.out.println("Wrong password. Try again:");
                PassInput = getText(scan);
            }
            if (PassInput.equals(current.getPassword())) {
                PassInput = null;
                System.out.println(current.getName() + ", here is your " + withdrawal + " dollars.");
                current.setBallance((current.getBallance() - withdrawal), current);        
            }
            if (withdrawal > current.getBallance()) {
                System.out.println("You, " + current.getName() + ", don't have " + withdrawal + " dollars. Only " + current.getBallance());
            }
        }
    scan.close();
    System.out.println("And finally write and read:");
    WriteSetToFile(mySe);
    ReadSetFromFile();
}    
    private HashSet<Account> mySet = new HashSet<Account>();
    
    public void addToSet(Account o) {
        mySet.add(o);
    }

    public static HashSet<Account> setMySet(HashSet<Account> mySet) {
        HashSet<Account> newHashSet = mySet;
        return newHashSet;
    }

    public static HashSet<Account> getDefaultSet() {
        Account a = new Account();
        HashSet<Account> mySet = new HashSet<>();
        mySet.add(a);
        System.out.println("Data is missing. We got default set.");
        return mySet;
    }
    
    public static void WriteSetToFile(HashSet<Account> SetOfAccounts) {
        Account acc = new Account();
        String filename = acc.getFileName();
        try {
            FileOutputStream fos = new FileOutputStream(filename);
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(SetOfAccounts);
            oos.flush();
            oos.close();
            fos.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @SuppressWarnings("unchecked")
    public static HashSet<Account> ReadSetFromFile() {
        Account acc = new Account();
        String filename = acc.getFileName();
        HashSet<Account> SetOfAccounts = new HashSet<>();
        try {
            FileInputStream fis = new FileInputStream(filename);
            ObjectInputStream ois = new ObjectInputStream(fis);
            SetOfAccounts = (HashSet<Account>) ois.readObject();
            ois.close();
            fis.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (SetOfAccounts == null) {
            System.out.println("Not good. SetOfAccounts = null");
        } else {
        for(Account bob : SetOfAccounts) {
            if (bob != null) {
                bob.displayInfo(bob);
                }
            }
        }
        return SetOfAccounts;
    }
    
    public static void greet(Account bac) {
        System.out.println("Congratulations! Now you have an account number " + bac.getAccNumber()
            + " in bankBank bank. Ballance is " + bac.getBallance());
    }
    
    public static String PhoneNumber(Scanner scann) {
        //Scanner scann = new Scanner(System.in);
        String st = scann.nextLine();
        char[] c = st.toCharArray();
        if (c[0] != '+') {
            System.out.println("Start from \'+\':");
            return PhoneNumber(scann);
        }
        if(c.length != 13) {
            System.out.println("It is not a phone number. Write 13 symbols:");
            return PhoneNumber(scann);
        }
        for(int ch = 1; ch < c.length; ch++) {
            if (Character.isDigit(c[ch]) == false) {
                System.out.println(ch + " is not a digit.");
                return PhoneNumber(scann);
            }
        }
        return st;
    }

    public static void setPassw (Account a, Scanner sp) {
        Console b = System.console();
        char[] cPass1 = b.readPassword("Write password:");
        String first = String.valueOf(cPass1);
        char[] cPass2 = b.readPassword("Write password again:");
        String second = String.valueOf(cPass2);
        if (first.equals(second)) {
            a.setPassword(second);
            first = null;
            second = null;
        } else {
            System.out.println("Passwords should be the same.");
            setPassw(a, sp);
        }
    }

    public static Account createAccount(/* Scanner sca */) {
        Account b = new Account();
        Scanner sca = new Scanner(System.in);
        System.out.println("Write customer's phone number:");
        b.setAccNumber(Integer.parseInt(PhoneNumber(sca).substring(4)));
        System.out.println("Customer's full name:");
        b.setName(getText(sca));
        System.out.println("Ballance will be zero.");
        b.setBallance(0,b);
        setPassw(b, sca);
        sca.close();
        return b;
    }

    public static double getDSum(Scanner sc) {
        String input = sc.nextLine();
        char[] c = input.toCharArray();
        int count = 0; int countDots = 0;
        for(char ch : c) {
            if (Character.isDigit(ch) || ch == '.') {
                count++;
                if(ch == '.') {
                    countDots++;
                }
            } else {
                System.out.println(ch + " is char. Write number:");
                return getDSum(sc);
            }
        }
        if (count == c.length && countDots < 2) {
            DecimalFormat decFormatter  = new DecimalFormat("0.00", new DecimalFormatSymbols());
            decFormatter.setRoundingMode(java.math.RoundingMode.DOWN);
            double d = Double.parseDouble(input);
            String formatted = decFormatter.format(d);
            double end = Double.parseDouble(formatted);
            return end;
        } else {
            return getDSum(sc);
        }
    }

    public static String getText(Scanner scant) {
        //Scanner scant = new Scanner(System.in);
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

    public static int getInt(/* Scanner s */) {
        Scanner s = new Scanner(System.in);
        if (s.hasNextInt()) {
            int i = s.nextInt();
            s.close();
            return i;
        } else {
            String r = s.next();
            System.out.println(r + " is not a number. Write number:");
            s.close();
            return getInt(/* s */);
        }
    }        
    public static void main(String[] args) {
        System.out.println("Are you admin or customer? (Write \"admin\" or \"customer\")");
        Scanner scan = new Scanner(System.in);
        String adminOrCustomer = scan.nextLine();
        while (adminOrCustomer.equals("admin") == false & adminOrCustomer.equals("customer") == false) {
            System.out.println("Just \"admin\" or \"customer\", please. Try again:");
            adminOrCustomer = scan.nextLine();
        }
        if (adminOrCustomer.equals("admin")) {
            adminSession(scan);
        }
        if (adminOrCustomer.equals("customer")) {
            boolean works = true;
            newCustomer(works);
        }            
        scan.close();
    }
}