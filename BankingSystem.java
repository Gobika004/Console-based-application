import java.util.Scanner;
public class BankingSystem {
    private static Account[] accounts = new Account[10];
    private static int numAccounts = 0;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int choice;

        do {
            System.out.println();
            System.out.println("--------------------> ONLINE BANKING <--------------------");
            System.out.println();
            System.out.println("1. Create Account \t\t\t 2.Deposit amount");
            System.out.println();
            System.out.println("3. Withdraw \t\t\t     4.Check Balance");
            System.out.println();
            System.out.println("               5. Exit");
            System.out.println();
            System.out.println("--------------------> ENTER YOUR CHOICE <--------------------");
            System.out.println();

            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    createAccount();
                    break;
                case 2:
                    deposit();
                    break;
                case 3:
                    withdraw();
                    break;
                case 4:
                    checkBalance();
                    break;
                case 5:
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        } while (choice != 5);

        scanner.close();
    }

    private static void createAccount() {
        Scanner scanner = new Scanner(System.in);
        System.out.println(" ------------------> ENTER CUSTOMER DETAILS <-------------------");
        System.out.println();
        System.out.print("Enter account number: ");
        String accNumber = scanner.next();
        System.out.print("Enter Customer name: ");
        String CustomerName = scanner.next();
        System.out.print("Enter mobile number: ");
        String MobileNumber = scanner.next();
        System.out.print("Enter Bank name: ");
        String BankName = scanner.next();
        System.out.print("Enter Branch name: ");
        String BranchName = scanner.next();
        accounts[numAccounts] = new Account(accNumber, CustomerName, MobileNumber, BankName, BranchName);
        numAccounts++;
        System.out.println("Account created successfully.");
    }

    private static void deposit() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("--------------------> ENTER ACCOUNT DETAILS <--------------------");
        System.out.println();
        System.out.print("Enter account number: ");
        String accNumber = scanner.next();
        System.out.print("Enter amount to deposit: ");
        double amount = scanner.nextDouble();
        System.out.print("Amount deposited successfully");
        System.out.println();

        Account acc = findAccount(accNumber);
        if (acc != null) {
            acc.deposit(amount);
        } else {
            System.out.println("Account not found.");
        }
    }

    private static void withdraw() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("--------------------> ENTER ACCOUNT DETAILS <--------------------");
        System.out.println();
        System.out.print("Enter account number: ");
        String accNumber = scanner.next();
        System.out.print("Enter amount to withdraw: ");
        double amount = scanner.nextDouble();
        

        Account acc = findAccount(accNumber);
        if (acc != null) {
            acc.withdraw(amount);
        } else {
            System.out.println("Account not found.");
        }
    }

    private static void checkBalance() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("--------------------> ENTER ACCOUNT DETAILS <--------------------");
        System.out.println();
        System.out.print("Enter account number: ");
        String accNumber = scanner.next();

        Account acc = findAccount(accNumber);
        if (acc != null) {
            System.out.println("Balance: " + acc.getBalance());
        } else {
            System.out.println("Account not found.");
        }
    }

    private static Account findAccount(String accNumber) {
        for (int i = 0; i < numAccounts; i++) {
            if (accounts[i].getAccountNumber().equals(accNumber)) {
                return accounts[i];
            }
        }
        return null;
    }
}
  
ACCOUNT

import java.util.Scanner;

class Account {
    private String accountNumber;
    private String name;
    private String mobilenumber;
    private String bankname;
    private String branchname;
    private double balance;

    public Account(String accountNumber, String name, String bankname, String branchname, String mobileNumber) {
        this.accountNumber = accountNumber;
        this.name = name;
        this.mobilenumber = mobilenumber;
        this.bankname = bankname;
        this.branchname = branchname;
        this.balance = 0.0;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public String getName() {
        return name;
    }

    public String getMobileNumber() {
        return mobilenumber;
    }


    public String getBankName() {
        return bankname;
    }

    public String getBranchName() {
        return branchname;
    }

    public double getBalance() {
        return balance;
    }

    public void deposit(double amount) {
        balance += amount;
        System.out.println(amount + " deposited successfully.");
    }

    public void withdraw(double amount) {
        if (balance >= amount) {
            balance -= amount;
            System.out.println(amount + " withdrawn successfully.");
        } else {
            System.out.println("Insufficient funds.");
        }
    }
}