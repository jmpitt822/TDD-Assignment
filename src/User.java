import java.util.HashMap;

/**
 * Created by jeremypitt on 9/16/16.
 */
public class User {

    public User() {
        accountInfo.put("Jeremy", 100.00);
        accountInfo.put("John", 117.00);
        accountInfo.put("Linda", 58.00);
    }
    private static String name;
    private static double balance;
    private static double newBal;

    public static double getNewBal() {
        return newBal;
    }

    public static HashMap<String, Double> accountInfo = new HashMap<>();

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public static double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public User(String name, double balance){
        this.name = name;
        this.balance = balance;
    }

    public static void makeUser(){
        Double balance = new Double(0);
        String balanceAmt = new String();
        boolean a = true;

        while (balance <= 0) {
            System.out.println("How much would you like to deposit?");
            balanceAmt = BankingMain.scanner.nextLine();
            balance = validatePosDouble(balanceAmt);
        }
        accountInfo.put(name, balance);
    }

    public boolean chooseUser() throws Exception {
        boolean a = true;
        boolean b = true;
        String nameEntry = new String();

        while (b) {
            System.out.println("Hello! Enter your name to log in.");
            name = BankingMain.scanner.nextLine();
            if (accountInfo.containsKey(name)) {
                System.out.println("Hello, " + name +"!");
                a = false;
                b = false;
            }
            else if (name.length() == 0){
                System.out.println("Name field can not be left blank!");
            }
            else {
                System.out.println("Would you like to create an account? [y/n]");
                String acctChoice = BankingMain.scanner.nextLine();
                if(acctChoice.equalsIgnoreCase("y")){
                    makeUser();
                    b = false;
                }
                else if (acctChoice.equalsIgnoreCase("n")){
                    System.out.println("Goodbye!");
                }
                else{
                    System.out.println("You must choose y or n!");
                }
            }
        }
        return a;
    }

    public boolean chooseAction() throws Exception {
        boolean b = false;
        boolean c = true;

        do {
            String choice;
            System.out.println("What would you like to do? [Check Balance, Withdraw, Delete Account, Cancel]");
            choice = BankingMain.scanner.nextLine();
            if (choice.equalsIgnoreCase("Check Balance")) {
                checkBalance();
                b = true;
            } else if (choice.equalsIgnoreCase("Withdraw")) {
                withdraw();
                b = true;
            } else if (choice.equalsIgnoreCase("Cancel")) {
                System.out.println("Thank you, and please come again.");
                b = false;
                c = false;
            } else if (choice.equalsIgnoreCase("Delete Account")) {
                b = deleteAccount();
                c = false;
            } else {
                System.out.println("Invalid choice: " + choice);
            }
        } while(b);
        return c;
    }

    public static void withdraw() {
        Double bal = getBalance();
        String input = BankingMain.scanner.nextLine();
        Double withdrawal = Double.parseDouble(input);
        newBal = (bal - withdrawal);
    }

    public static boolean deleteAccount() {
        boolean a = true;
        boolean b = true;
        String deleteChoice = new String();
        while (b) {
            System.out.println("Are you sure you want to delete your account? [y/n]");
            deleteChoice = BankingMain.scanner.nextLine();
            if (deleteChoice.equalsIgnoreCase("y")) {
                accountInfo.remove(name);
                System.out.println("Account deleted.");
                a = false;
                b = false;
            }
            else if (deleteChoice.equalsIgnoreCase("n")){
                b = false;
            }
            else {
                System.out.println("Error: must choose y or n");
            }
        }
        return a;
    }

    public static void checkBalance() {
        Double balance = accountInfo.get(name);
        System.out.println("Your balance is $" + balance);
    }

    public static Double validatePosDouble(String s){
        Double b = new Double(0);
        try {
            b = Double.parseDouble(s);
        } catch (Exception e) {
            System.out.println("Please enter a valid number");
        }
        return  b;
    }
}
