package bankApp;

public class BankAccount {
    private int accNum;
    private String ownerName;
    private double bal;

    public static void main(String[] args) {
        BankAccount a = new BankAccount("Riya", 900, 12);
        a.deposit(7300);
        a.withdraw(37899);
        a.deposit(-100);
        a.withdraw(-390);
        a.withdraw(45.0);
        System.out.println(a);
    }
    public BankAccount(String name, double iniBal, int userNum){
        this.ownerName = name;
        this.bal = iniBal;
        this.accNum = 1000 + userNum;
    }

    public void deposit(double amt){
        if(amt <= 0){
            System.out.println("Invalid amount [Negative value]");
            return;
        }
        this.bal += amt;
        System.out.println("Deposit successful. Updated Balance: " + this.bal);
    }
    public void withdraw(double amt){
        if(amt <= 0){
            System.out.println("Invalid amount [Negative value]");
            return;
        }
        if(amt > this.bal){
            System.out.println("Insufficient balance.");
            return;
        }
        this.bal -= amt;
        System.out.println("Withdraw successful. Updated Balance: " + this.bal);
    }
    public void checkBal(){
        System.out.println("Balance: " + this.bal);
    }
    public String toString(){
        return "Bank Account{ " + "ACC. No.: " + this.accNum + ", NAME: " + this.ownerName + ", BALANCE: " + this.bal + "}";
    }
}
