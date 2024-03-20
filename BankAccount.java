import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class BankAccount {
    
    Set <Object> mySet = new HashSet<Object>();
    
    private int accNumber = 1;
    private String name = "Bob";
    double ballance = 0;

    public int getAccNumber() {
        return accNumber;
    }

    public void setAccNumber(int accNumber) {
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

    public void setBallance(float ballance) {
        this.ballance = ballance;
    }

    public static void main(String[] args) {
        System.out.println("Do you have account in bankBank bank? 1 - yes, 0 - no");
        Scanner scan = new Scanner(System.in);
        int firstcheck = scan.nextInt();
        if (firstcheck == 0) {
            System.out.println("So let's create one. Write your name:");
            String username = scan.nextLine();
            BankAccount b = new BankAccount();
            b.setName(username);
            b.setAccNumber(2);
        } if (firstcheck == 1) {
            System.out.println("What is your account number?");
            BankAccount a = new BankAccount();
            int acc = scan.nextInt(); scan.close();
            if (acc == a.getAccNumber()) {        
                System.out.println(a.getAccNumber() + " is your account number.");
                System.out.println(a.getName() + " is your name.");
                System.out.println(a.getBallance() + " is your ballance.");
            } else {System.out.println("We don't have account number " + acc);}
        }
    }
}
