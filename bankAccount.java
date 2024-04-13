import java.util.Scanner;

public class bankAccount {
    public static String PhoneNumber(Scanner scann) {
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
        System.out.println("Your phone number is " + st);
        return st;
    }

    public static String getTextInput() {
        Scanner scan = new Scanner(System.in);
        String input = scan.nextLine(); scan.close();
        return input;
    }
    public static bankAccount[] newOne() {
        bankAccount first = createNewAccount("Bob",123456789);
        bankAccount second = createNewAccount("Bill",987654321);
        bankAccount third = createNewAccount("Jack",22);
        bankAccount fourth = createNewAccount("John",555555555);
        bankAccount[] arr = new bankAccount[4];
        arr[0] = first; arr[1] = second; arr[2] = third; arr[3] = fourth;
        return arr;
    }
    private int AccountNumber;
    private String name;
    public int getAccountNumber() {return AccountNumber;}
    public void setAccountNumber(int accountNumber) {AccountNumber = accountNumber;}
    public String getName() {return name;}
    public void setName(String name) {this.name = name;}
    public static bankAccount createNewAccount(String string, int i) {
        bankAccount ba = new bankAccount();
        ba.name = string; ba.AccountNumber = i; return ba;
    }
    public static bankAccount OneFromList(bankAccount[] a, int i) {
        bankAccount cur = new bankAccount();
        for(bankAccount b : a) {
            int myInt = b.getAccountNumber();
            String myString = b.getName();
            if (myInt == i) {
                System.out.println(myString + " is name");
                cur = b;
                System.out.println("Success!");
            }
        }
        return cur;
    }
    public static void main(String[] args) {
        bankAccount[] arr = newOne();
        Scanner scan = new Scanner(System.in);
        String myS = PhoneNumber(scan);
        String myS2 = myS.substring(4);
        int myI = Integer.parseInt(myS2);
        bankAccount currentAcc = OneFromList(arr, myI);
        System.out.println(currentAcc.AccountNumber + " " + currentAcc.name);
        System.out.println("Do you want to change your account number? Write new:");
        String inputString2 = getTextInput();
        int input2 = Integer.parseInt(inputString2);
        currentAcc.setAccountNumber(input2);
        System.out.println(currentAcc.getAccountNumber());
        scan.close();
    }
}