package bankApp;

import java.util.Scanner;

public class BankAccount {
    private int accNum;


    private String ownerName;
    private double bal;

    public static void main(String[] args) {
        BankAccount a = new BankAccount("Riya", 900, 12);
        BankAccount b = new BankAccount("Reet", 1000, 2);
//        a.deposit(7300);
//        a.withdraw(37899);
//        a.deposit(-100);
//        a.withdraw(-390);
//        a.withdraw(45.0);
//        System.out.println(a);
        Scanner sc = new Scanner(System.in);
        while(true){
            System.out.println("\n*Select operation:\n1. Deposit\n2. Withdraw\n3. Check Balance\n4. Transfer\n5. Print account details\n6. Exit\n");
            switch(sc.nextInt()){
                case 1:
                    System.out.println("Enter amount: ");
                    a.deposit(sc.nextDouble());
                    break;
                case 2:
                    System.out.println("Enter amount: ");
                    a.withdraw(sc.nextDouble());
                    break;
                case 3:
                    System.out.println("Balance: " + a.getBal());
                    break;
                case 4:
                    System.out.println("Enter amount: ");
                    a.transferTo(b, sc.nextDouble());
                    break;
                case 5:
                    System.out.println("Enter Account num: ");
                    int i = sc.nextInt();
                    if(i == a.getAccNum()){
                        System.out.println(a);
                    } else if (i == b.getAccNum()) {
                        System.out.println(b);
                    } else{
                        System.out.println("Account doesn't exist.");
                    }
                    break;
                case 6:
                    sc.close();
                    return;
                default:
                    System.out.println("Invalid option, try again.");
            }
        }
    }
    public BankAccount(String name, double iniBal, int userNum){
        this.ownerName = name;
        this.bal = iniBal;
        this.accNum = 1000 + userNum;
    }

    public void deposit(double amt){
        if(amt <= 0){
            System.out.println("Amount must be greater than zero.");
            return;
        }
        this.bal += amt;
        System.out.println("Deposit successful. Updated Balance: " + this.bal);
    }
    public void withdraw(double amt){
        if(amt <= 0){
            System.out.println("Amount must be greater than zero.");
            return;
        }
        if(amt > this.bal){
            System.out.println("Insufficient balance.");
            return;
        }
        this.bal -= amt;
        System.out.println("Withdraw successful. Updated Balance: " + this.bal);
    }
    public double getBal(){
        return this.bal;
    }
    public int getAccNum(){
        return this.accNum;
    }
    @Override
    public String toString(){
        return "Bank Account{ " + "ACC. No.: " + this.accNum + ", NAME: " + this.ownerName + ", BALANCE: " + this.bal + "}";
    }
    public void transferTo(BankAccount creditor, double amt){
        if(amt <= 0){
            System.out.println("Invalid amount.");
            return;
        }
        if(amt > this.getBal()){
            System.out.println("Insufficient balance.");
            return;
        }
        this.bal -= amt;
        creditor.bal += amt;
        System.out.println("Transfer of " + amt + " to " + creditor.ownerName + " successful.\n" +
                "Your current balance: " + this.bal);
    }
}
